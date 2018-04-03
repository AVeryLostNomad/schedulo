/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app;

import com.schedulo.app.panels.TextClassSearch;
import com.schedulo.app.util.InstanceData;
import com.schedulo.app.util.WindowUtil;
import javax.swing.JFrame;

/**
 *
 * @author joeye
 */
public class test {
    
    public static void main(String[] args){
        JFrame frame = WindowUtil.OpenUndecoratedFrame(new TextClassSearch());
        InstanceData.store("frame", frame);
    }
    
}
