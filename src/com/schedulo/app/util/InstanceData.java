/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joeye
 */
public class InstanceData {
    
    private static final Map<String, Object> DATA;
    
    static {
        DATA = new HashMap<>();
    }
    
    public static void store(String key, Object object){
        DATA.put(key, object);
    }
    
    public static Object fetch(String key){
        if(DATA.containsKey(key)){
            return DATA.get(key);
        }
        return null;
    }
    
    public static void remove(String key){
        DATA.remove(key);
    }
    
    public static boolean contains(String key){
        return DATA.containsKey(key);
    }
    
}
