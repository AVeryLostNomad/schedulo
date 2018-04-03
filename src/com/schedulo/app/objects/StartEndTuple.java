/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.objects;

/**
 *
 * @author jmaher
 */
public class StartEndTuple {
    
    private final long start, end;
    
    StartEndTuple(long start, long end){
        this.start = start;
        this.end = end;
    }
    
    public long getStartTime() {
        return this.start;
    }
    
    public long getEndTime() {
        return this.end;
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof StartEndTuple){
            StartEndTuple oset = (StartEndTuple) other;
            if(oset.getStartTime() == this.getStartTime() && oset.getEndTime() == this.getEndTime()){
                return true;
            }
            return false;
        }
        return false;
    }
    
}
