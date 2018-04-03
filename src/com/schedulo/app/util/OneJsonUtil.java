/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.util;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonObject.Member;
import com.eclipsesource.json.JsonValue;
import com.schedulo.app.objects.CourseObject;
import com.schedulo.app.objects.ScheduleObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jmaher
 */
public class OneJsonUtil {
    
    private JsonObject thisJson;
    
    public OneJsonUtil(){
        
    }
    
    public static ScheduleObject jsonObjToScheduleObj(List<JsonObject> obj){
        ScheduleObject so = new ScheduleObject();

        for(JsonObject jo : obj){
            JsonArray arr = jo.get("meetingsFaculty").asArray();
            for(JsonValue val : arr){;
                JsonObject thisMeeting = val.asObject();
                JsonObject meetingTimeJson = thisMeeting.get("meetingTime").asObject();
                so.addMeetingTime(jo.getString("subject", "") + " " + jo.getString("courseNumber", ""), meetingTimeJson, jo);
            }
        }
        return so;
    }
    
    public static List<List<JsonObject>> cartesianProduct(List<List<JsonObject>> set){
        if(set.size() < 2){
            return new ArrayList<>();
        }
        return _cartesianProduct(0, set);
    }
    
    private static List<List<JsonObject>> _cartesianProduct(int index, List<List<JsonObject>> sets){
        List<List<JsonObject>> ret = new ArrayList<>();
        if(index == sets.size()){
            ret.add(new ArrayList<>());
        }else{
            for(JsonObject obj : sets.get(index)){
                for(List<JsonObject> set : _cartesianProduct(index + 1, sets)){
                    set.add(obj);
                    ret.add(set);
                }
            }
        }
        return ret;
    }
    
    public List<List<JsonObject>> generateValidSchedules(String term, List<CourseObject> courses){
        List<List<JsonObject>> toReturn = new ArrayList<List<JsonObject>>();
        
        for(CourseObject co : courses){
            List<JsonObject> matching = searchClassesForTerm(term, co);
            toReturn.add(matching);
        }
        // To return now contains a list of matching courses in individual lists.
        //Need to crossproduct this gui
        List<List<JsonObject>> crossProduct = cartesianProduct(toReturn);
        List<List<JsonObject>> reallyToReturn = new ArrayList<>();
        for(List<JsonObject> scheduleListForm : crossProduct){
            ScheduleObject so = new ScheduleObject();
            
            for(JsonObject jo : scheduleListForm){
                JsonArray arr = jo.get("meetingsFaculty").asArray();
                for(JsonValue val : arr){
                    JsonObject thisMeeting = val.asObject();
                    JsonObject meetingTimeJson = thisMeeting.get("meetingTime").asObject();
                    so.addMeetingTime(jo.getString("subject", "") + " " + jo.getString("courseNumber", ""),meetingTimeJson, jo);
                }
            }
            if(so.isValid()){
                reallyToReturn.add(scheduleListForm);
            }
        }
        
        return reallyToReturn;
    }
    
    public List<JsonObject> searchClassesForTerm(String term, CourseObject searchTerms){
        JsonArray termArray = getTermJson(term);
        
        List<JsonObject> toReturn = new ArrayList<JsonObject>();
        for(JsonValue course : termArray){
            if(searchTerms.matches(course.asObject()) && course.asObject().getInt("seatsAvailable", 0) > 0){
                toReturn.add(course.asObject());
            }
        }
        
        return toReturn;
    }
    
    // Get json for a specific one of our terms
    // Comes in the form of an array of all courses in this term
    public JsonArray getTermJson(String term){
        Iterator<Member> it = thisJson.iterator();
        while(it.hasNext()){
            Member nex = it.next();
            if(nex.getName().equals(term)){
                return nex.getValue().asArray();
            }
        }
        return null;
    }
    
    // Load all jsons from a file
    public void loadJson(String string){
        try{
            JsonObject allJson = Json.parse(new BufferedReader(new FileReader(new File(string)))).asObject();
            this.thisJson = allJson;
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
    }
    
}
