/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.objects;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.Random;

/**
 *
 * @author jmaher
 */
public class CourseObject {
    
    private String teacher = "";
    private String subject = "";
    private String creditAmt = "";
    private String college = "";
    private String building = "";
    private String wildcard = "";
    private boolean taughtByTA = true;
    private boolean taughtByProf = true;
    private String courseNumber = "";
    private String title = "";
    
    private boolean monday = true, tuesday = true, wednesday= true,
            thursday = true, friday = true;
    
    public CourseObject() {}
    
    public boolean matches(JsonObject courseJson){
        if(!teacher.equals("")){
            // We care about matching teacher.
            String filter = teacher;
            boolean not = false;
            if(filter.startsWith("-")){
                not = true;
                filter = filter.substring(1);
            }
            
            JsonArray facultyList = courseJson.get("faculty").asArray();
            for(JsonValue fac : facultyList){
                JsonObject mtObj = fac.asObject();
                //Get associated faculty
                String dispName = mtObj.getString("displayName", "");
                    
                if(dispName.toLowerCase().contains(filter.toLowerCase())){
                    // A match
                    if(not){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        
        if(!subject.equals("")){
            // We care about matching subject.
            String filter = subject;
            boolean not = false;
            if(filter.startsWith("-")){
                not = true;
                filter = filter.substring(1);
            }
            
            String subj = courseJson.getString("subject", "");
            if(subj.toLowerCase().contains(filter.toLowerCase())){
                // A match
                if(not){
                    return false;
                }
            }else{
                return false;
            }
        }
        
        if(!title.equals("")){
            String filter = title;
            boolean not = false;
            if(filter.startsWith("-")){
                not = true;
                filter = filter.substring(1);
            }
            
            String subj = courseJson.getString("courseTitle", "");
            if(subj.toLowerCase().contains(filter.toLowerCase())){
                // A match
                if(not){
                    return false;
                }
            }else{
                return false;
            }
        }
        
        if(!creditAmt.equals("")){
            String filter = creditAmt;
            boolean not = false;
            if(filter.startsWith("-")){
                not = true;
                filter = filter.substring(1);
            }
            
            String subj = courseJson.getString("subjectCourse", "");
            subj = subj.substring(subj.length() - 1);
            if(subj.toLowerCase().contains(filter.toLowerCase())){
                // A match
                if(not){
                    return false;
                }
            }else{
                return false;
            }
        }
        
        if(!courseNumber.equals("")){
            String filter = courseNumber;
            boolean not = false;
            if(filter.startsWith("-")){
                not = true;
                filter = filter.substring(1);
            }
            
            String subj = courseJson.getString("courseNumber", "");
            if(subj.toLowerCase().contains(filter.toLowerCase())){
                // A match
                if(not){
                    return false;
                }
            }else{
                return false;
            }
        }
        
//      TODO unimplemented, also do building
//        if(!college.equals("")){
//            String filter = college;
//            boolean not = false;
//            if(filter.startsWith("-")){
//                not = true;
//                filter = filter.substring(1);
//            }
//            
//            String subj = courseJson.getString("subjectCourse", "");
//            subj = subj.substring(subj.length() - 1);
//            if(subj.toLowerCase().contains(filter.toLowerCase())){
//                // A match
//                if(not){
//                    return false;
//                }
//            }else{
//                return false;
//            }
//        }

//        ALSO do wildcard
//        if(!wildcard.equals("")){
//            
//        }
       
//    private boolean taughtByTA;
//    private boolean taughtByProf;
//    private String courseNumber;
//    
//    private boolean monday, tuesday, wednesday, thursday, friday;
//    
        return true;
    }
    
    public String getKey(){
        if(!subject.equals("") && !courseNumber.equals("")){
            return subject + " " + courseNumber;
        }
        if(!title.equals("")){
            return "'" + title + "'";
        }
        //Both subject and course number are not filled in. 
        if(!teacher.equals("")){
            return "[" + teacher + "]";
        }
        //Also teacher is blank
        if(!college.equals("")){
            return "{" + college + "}";
        }
        
        if(!building.equals("")){
            return "<" + building + ">";
        }
        
        if(!creditAmt.equals("")){
            return "##";
        }
        
        return String.valueOf(new Random().nextInt(10000));
    }
    
    public void setTeacher(String newTeacher){
        teacher = newTeacher;
    }
    
    public String getTeacher(){
        return teacher;
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setCreditAmount(String credits){
        creditAmt = credits;
    }
    
    public String getCreditsAmount(){
        return this.creditAmt;
    }
    
    public void setCollege(String college){
        this.college = college;
    }
    
    public String getCollege(){
        return this.college;
    }
    
    public void setBuilding(String building){
        this.building = building;
    }
    
    public String getBuilding(){
        return this.building;
    }
    
    public void setWildcard(String wildcard){
        this.wildcard = wildcard;
    }
    
    public String getWildcard(){
        return this.wildcard;
    }
    
    public void setTaughtByTA(boolean tbyTA){
        this.taughtByTA = tbyTA;
    }
    
    public boolean getTaughtByTA(){
        return this.taughtByTA;
    }
    
    public void setTaughtByProfessor(boolean tbyProf){
        this.taughtByProf = tbyProf;
    }
    
    public boolean getTaughtByProfessor(){
        return this.taughtByProf;
    }
    
    public void setMonday(boolean bool){
        this.monday = bool;
    }
    
    public boolean getMonday(){
        return this.monday;
    }
    
    public void setTuesday(boolean bool){
        this.tuesday = bool;
    }
    
    public boolean getTuesday(){
        return this.tuesday;
    }
    
    public void setWednesday(boolean bool){
        this.wednesday = bool;
    }
    
    public boolean getWednesday(){
        return this.wednesday;
    }
    
    public void setThursday(boolean bool){
        this.thursday = bool;
    }
    
    public boolean getThursday(){
        return this.thursday;
    }
    
    public void setFriday(boolean bool){
        this.friday = bool;
    }
    
    public boolean getFriday(){
        return this.friday;
    }
    
    public void setCourseNumber(String courseNumber){
        this.courseNumber = courseNumber;
    }
    
    public String getCourseNumber() {
        return this.courseNumber;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return this.title;
    }
    
}
