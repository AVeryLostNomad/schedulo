/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.objects;

import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jmaher
 */
public class ScheduleObject {
    
    private List<StartEndTuple> times;
    private Map<StartEndTuple, String> ownerMap;
    private Map<String, JsonObject> ownerToJsonMap;
    private long minutes_in_day = 24 * 60;
    private boolean invalid = false;
    
    private List<JsonObject> courseJsonData = new ArrayList<>();
    
    public ScheduleObject(){
        times = new ArrayList<StartEndTuple>();
        ownerMap = new HashMap<StartEndTuple, String>();
        ownerToJsonMap = new HashMap<String, JsonObject>();
    }
    
    public JsonObject getCourseJson(String owner){
        return ownerToJsonMap.get(owner);
    }
    
    public List<StartEndTuple> getMeetingTimes(){
        return times;
    }
    
    public void addMeetingTime(String owner, JsonObject meetingJson, JsonObject classJson){
        if(invalid){
            return;
        }
        if(meetingJson.getString("endDate", "").equals(meetingJson.getString("startDate", ""))){
            //A final. Return
            return;
        }
        String beginTime = meetingJson.getString("beginTime", "");
        String endTime = meetingJson.getString("endTime", "");
        if(beginTime.equals("")){
            this.invalid = true;
            return;
        }
       
        Integer beginTimeHours = Integer.parseInt(beginTime.substring(0, 2));
        Integer beginTimeMinutes = Integer.parseInt(beginTime.substring(2, 4));
        
        long beginTimeMins = (beginTimeHours.longValue() * 60L) + beginTimeMinutes.longValue();
        
        Integer endTimeHours = Integer.parseInt(endTime.substring(0, 2));
        Integer endTimeMinutes = Integer.parseInt(endTime.substring(2, 4));
        
        long endTimeMins = (endTimeHours.longValue() * 60L) + endTimeMinutes.longValue();
        
        boolean monday = meetingJson.getBoolean("monday", false);
        boolean tuesday = meetingJson.getBoolean("tuesday", false);
        boolean wednesday = meetingJson.getBoolean("wednesday", false);
        boolean thursday = meetingJson.getBoolean("thursday", false);
        boolean friday = meetingJson.getBoolean("friday", false);
        boolean saturday = meetingJson.getBoolean("saturday", false);
        boolean sunday = meetingJson.getBoolean("sunday", false);
    
        if (monday) {
            StartEndTuple set = new StartEndTuple(beginTimeMins, endTimeMins);
            this.times.add(set);
            this.ownerMap.put(set, owner);
            this.ownerToJsonMap.put(owner, classJson);
        }
        if (tuesday) {
            StartEndTuple set = new StartEndTuple(beginTimeMins + (1L * this.minutes_in_day), endTimeMins + (1L * this.minutes_in_day));
            this.times.add(set);
            this.ownerMap.put(set, owner);
            this.ownerToJsonMap.put(owner, classJson);
        }
        if (wednesday) {
            StartEndTuple set = new StartEndTuple(beginTimeMins + (2L * this.minutes_in_day), endTimeMins + (2L * this.minutes_in_day));
            this.times.add(set);
            this.ownerMap.put(set, owner);
            this.ownerToJsonMap.put(owner, classJson);
        }
        if (thursday) {
            StartEndTuple set = new StartEndTuple(beginTimeMins + (3L * this.minutes_in_day), endTimeMins + (3L * this.minutes_in_day));
            this.times.add(set);
            this.ownerMap.put(set, owner);
            this.ownerToJsonMap.put(owner, classJson);
        }
        if (friday) {
            StartEndTuple set = new StartEndTuple(beginTimeMins + (4L * this.minutes_in_day), endTimeMins + (4L * this.minutes_in_day)); 
            this.times.add(set);
            this.ownerMap.put(set, owner);
            this.ownerToJsonMap.put(owner, classJson);
        }
        if (saturday) {
            StartEndTuple set = new StartEndTuple(beginTimeMins + (5L * this.minutes_in_day), endTimeMins + (5L * this.minutes_in_day));
            this.times.add(set);
            this.ownerMap.put(set, owner);
            this.ownerToJsonMap.put(owner, classJson);
        }
        if (sunday) {
            StartEndTuple set = new StartEndTuple(beginTimeMins + (6L * this.minutes_in_day), endTimeMins + (6L * this.minutes_in_day));
            this.times.add(set);
            this.ownerMap.put(set, owner);
            this.ownerToJsonMap.put(owner, classJson);
        }
    }
    
    public String getOwner(StartEndTuple set){
        return this.ownerMap.get(set);
    }
    
    public boolean isValid(){
        if(this.invalid){
            return false;
        }
        for(int i = 0; i < 10080; i++){
            int count = 0;
            for(StartEndTuple set : this.times){
                if(i <= set.getEndTime() && i >= set.getStartTime()){
                    count += 1;
                }
            }
            if(count > 1){
                return false;
            }
        }
        
        return true;
    }
    
}


