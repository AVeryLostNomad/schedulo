/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.util;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.schedulo.app.objects.ScheduleObject;
import com.schedulo.app.objects.StartEndTuple;
import com.schedulo.app.objects.StudentPreferences;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmaher
 */
public class ScheduleEvaluationUtil {
    
    // Section: Clumpedness metric
    
    // Send in all possible courses to get a total thing.
    public static void preClumpedness(List<List<JsonObject>> opts){
        if(InstanceData.contains("betweenTimes")){
            InstanceData.remove("betweenTimes");
        }
        for(List<JsonObject> list : opts){
            ScheduleObject so = new ScheduleObject();
            for(JsonObject jo : list){
                JsonArray arr = jo.get("meetingsFaculty").asArray();
                for(JsonValue val : arr){;
                    JsonObject thisMeeting = val.asObject();
                    JsonObject meetingTimeJson = thisMeeting.get("meetingTime").asObject();
                    so.addMeetingTime("RANDO", meetingTimeJson, jo); // Key is irrelevant here. We don't intend to fetch this owner.
                }
            }

            List<List<Long>> timeBetween = new ArrayList<List<Long>>();
            if(InstanceData.contains("betweenTimes")){
                timeBetween = (List<List<Long>>) InstanceData.fetch("betweenTimes");
            }
            List<Long> thisTimeBetween = new ArrayList<Long>();
            
            List<StartEndTuple> meets = so.getMeetingTimes();
            for(int i = 0; i < meets.size(); i++){
                StartEndTuple thisTuple = meets.get(i);
                if ((i + 1) != meets.size()) {
                    StartEndTuple nextTuple = meets.get(i + 1);
                    thisTimeBetween.add((nextTuple.getStartTime() % (60L * 24L)) - (thisTuple.getEndTime() % (60L * 24L)));
                }
            }
            timeBetween.add(thisTimeBetween);
            InstanceData.store("betweenTimes", timeBetween);
        };
    }
    
    // Run on a single schedule to generate a single clumpy value in comparison to the others.
    public static double clumpedness(List<JsonObject> options){
        ScheduleObject so = new ScheduleObject();
        for(JsonObject jo : options){
            JsonArray arr = jo.get("meetingsFaculty").asArray();
            for(JsonValue val : arr){;
                JsonObject thisMeeting = val.asObject();
                JsonObject meetingTimeJson = thisMeeting.get("meetingTime").asObject();
                so.addMeetingTime("RANDO", meetingTimeJson, jo); // Key is irrelevant here. We don't intend to fetch this owner.
            }
        }
        
        List<List<Long>> timeBetween = new ArrayList<List<Long>>();
        if(InstanceData.contains("betweenTimes")){
            timeBetween = (List<List<Long>>) InstanceData.fetch("betweenTimes");
        }
        Long avgClumpedness = 0L;
        int total = 0;
        for(List<Long> list : timeBetween){
            for(Long l : list){
                avgClumpedness += l;
                total += 1;
            }
        }
        double averageClump = avgClumpedness.doubleValue() / total;
        
        List<Long> thisTimeBetween = new ArrayList<Long>();
        List<StartEndTuple> meets = so.getMeetingTimes();
        for(int i = 0; i < meets.size(); i++){
            StartEndTuple thisTuple = meets.get(i);
            if ((i + 1) != meets.size()) {
                StartEndTuple nextTuple = meets.get(i + 1);
                thisTimeBetween.add((nextTuple.getStartTime() % (60L * 24L)) - (thisTuple.getEndTime() % (60L * 24L)));
            }
        }
        Long avg = 0L;
        int ttl = 0;
        for(Long l : thisTimeBetween){
            ttl += 1;
            avg += l;
        }
        double thisAvg = avg.doubleValue() / total;
        
        if(thisAvg < averageClump){
            return ((averageClump - thisAvg) / thisAvg) * (StudentPreferences.clumpednessImportance >= 0.5D ? 1.0D : -1.0D);
        }else{
            return (thisAvg - averageClump) / thisAvg * (StudentPreferences.clumpednessImportance >= 0.5D ? 1.0D : -1.0D);
        }
    }
    
    // End clumpedness metric
    
    
    // Start proximity metric
    
        // Insert stuff about calculating average distance here. 
    
    // End proximiy metric
    
    
    // Start previous professor metric
    
        // Goal of this metric is to determine if there was a previous class
        // taught by some professor that this individual did well in. If so, let's
        // give extra weight to new classes taught by those professors. 

    // End previous professor metric
    
}
