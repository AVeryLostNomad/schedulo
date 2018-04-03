/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author jmaher
 */
public class ScoredObject implements Comparable{
    
    public int index = 0;
    public Object obj;
    public Map<String, Double> scoreMap;
    
    public ScoredObject(Object obj, int index){
        this.index = index;
        this.obj = obj;
        scoreMap = new HashMap<String, Double>();
    }
    
    public Object getObject(){
        return obj;
    }
    
    public Double tabulate(){
        Double total = 0D;
        for(Entry<String, Double> e : scoreMap.entrySet()){
            total += e.getValue();
        }
        return total;
    }
    
    public void putScore(String scoreName, Double value){
        scoreMap.put(scoreName, value);
    }
    
    public Double getScore(String scoreName){
        return scoreMap.get(scoreName);
    }
    
    public String getHighestSubscore(){
        Double highest = - 1000000D;
        String highestString = "";
        for(Entry<String, Double> e : scoreMap.entrySet()){
            if(e.getValue() > highest){
                highest = e.getValue();
                highestString = e.getKey();
            }
        }
        return highestString;
    }
    
    public String getLowestSubscore(){
        Double lowest = 1000000D;
        String lowestString = "";
        for(Entry<String, Double> e : scoreMap.entrySet()){
            if(e.getValue() < lowest){
                lowest = e.getValue();
                lowestString = e.getKey();
            }
        }
        return lowestString;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof ScoredObject){
            return ((ScoredObject) o).tabulate().compareTo(this.tabulate());
        }
        return 0;
    }
    
}
