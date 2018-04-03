/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.util;

import java.io.File;

/**
 *
 * @author joeye
 */
public class ConfigurationUtil {
    
    /*
     * Evaluate whether there is login and license information stored on this 
       computer.
     * @return True or false 
     */
    public static boolean canContinueStraightToWorkspace(){
        if(!new File(FileSystemUtil.getLocalFileDirectory() + "user.json").exists()){
            // We are missing user information. Must login.
            return false;
        }
        if(!new File(FileSystemUtil.getLocalFileDirectory() + "license.txt").exists()){
            // User file exists but no license is detected. 
            //This will limit the functionality of this program severely, 
            //so let's force the user to login again to fetch a new copy
            //of their license.
            return false;
        }
        return true;
    }
    
}
