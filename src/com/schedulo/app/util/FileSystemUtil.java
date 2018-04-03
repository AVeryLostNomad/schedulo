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
public class FileSystemUtil {
    
    public static String getLocalFileDirectory(){
        String workingDirectory;
        //here, we assign the name of the OS, according to Java, to a variable...
        String OS = (System.getProperty("os.name")).toUpperCase();
        //to determine what the workingDirectory is.
        //if it is some version of Windows
        if (OS.contains("WIN"))
        {
            //it is simply the location of the "AppData" folder
            workingDirectory = System.getenv("AppData");
        }
        //Otherwise, we assume Linux or Mac
        else
        {
            //in either case, we would start in the user's home directory
            workingDirectory = System.getProperty("user.home");
            //if we are on a Mac, we are not done, we look for "Application Support"
            workingDirectory += "/Library/Application Support";
        }
        return workingDirectory + File.separatorChar + "Schedulo" + File.separatorChar;
    }
    
}
