/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.util;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author joeye
 */
public class WindowUtil {
    
    public static JFrame OpenUndecoratedFrame(JPanel panel){
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setUndecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        InstanceData.store("frame", frame);
        return frame;
    }
    
    public static JFrame OpenTemporaryFrame(String id, JPanel panel){
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        InstanceData.store("temp_" + id, frame);
        return frame; 
    }
    
    public static void CloseCurrentFrame(){
        JFrame frame = (JFrame) InstanceData.fetch("frame");
        frame.setVisible(false);
        frame.dispose();
    }
    
    public static void CloseTemporaryFrame(String id) {
        JFrame frame = (JFrame) InstanceData.fetch("temp_" + id);
        frame.setVisible(false);
        frame.dispose();
    }
    
}
