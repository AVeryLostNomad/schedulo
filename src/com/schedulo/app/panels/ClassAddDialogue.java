/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.schedulo.app.panels;

import com.schedulo.app.objects.CourseObject;
import com.schedulo.app.util.InstanceData;
import com.schedulo.app.util.WindowUtil;
import javax.swing.AbstractListModel;
import javax.swing.JList;

/**
 *
 * @author jmaher
 */
public class ClassAddDialogue extends javax.swing.JPanel {

    private boolean fromBase = false;
    private String prevKey = "";
    
    /**
     * Creates new form ClassAddDialogue
     */  
    public ClassAddDialogue() {
        initComponents();
    }
    
    public ClassAddDialogue(String key){
        initComponents();
        fromBase = true;
        prevKey = key;
        jButton1.setText("Save");
        loadContentsFromPrevious();
    }
    
    private void loadContentsFromPrevious(){
        CourseObject prev = (CourseObject) InstanceData.fetch(prevKey);
        building.setText(prev.getBuilding());
        title.setText(prev.getTitle());
        college.setText(prev.getCollege());
        creditsAmt.setText(prev.getCreditsAmount());
        wildcardMatch.setText(prev.getWildcard());
        courseNum.setText(prev.getCourseNumber());
        teacherName.setText(prev.getTeacher());
        subjectName.setText(prev.getSubject());
        monday.setSelected(prev.getMonday());
        tuesday.setSelected(prev.getTuesday());
        wednesday.setSelected(prev.getWednesday());
        thursday.setSelected(prev.getThursday());
        friday.setSelected(prev.getFriday());
        taughtByProfessor.setSelected(prev.getTaughtByProfessor());
        taughtByTA.setSelected(prev.getTaughtByTA());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        teacherName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        subjectName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        creditsAmt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        college = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        courseNum = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        wildcardMatch = new javax.swing.JTextField();
        taughtByTA = new javax.swing.JCheckBox();
        taughtByProfessor = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        monday = new javax.swing.JCheckBox();
        tuesday = new javax.swing.JCheckBox();
        wednesday = new javax.swing.JCheckBox();
        thursday = new javax.swing.JCheckBox();
        friday = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        building = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 246));
        setToolTipText("The class will match all filled-in fields");

        jPanel1.setBackground(new java.awt.Color(198, 40, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add a class");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        jButton1.setText("Add");
        jButton1.setToolTipText("Add this set of search parameters as an entry in your course search");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.setToolTipText("Clear all parameters in all tabs");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jTabbedPane1.setToolTipText("");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Teacher");
        jLabel2.setToolTipText("Match professors with this name. '-' to match all but this professor.");

        teacherName.setToolTipText("Match professors with this name. '-' to match all but this professor.");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Subject");
        jLabel3.setToolTipText("Match subjects with this name. '-' to match all but this subject.");

        subjectName.setToolTipText("Match subjects with this name. '-' to match all but this subject.");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Credits");
        jLabel4.setToolTipText("Match courses with this many credit hours. '-' for all but.");

        creditsAmt.setToolTipText("Match courses with this many credit hours. '-' for all but.");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("College");
        jLabel5.setToolTipText("Match courses in this college. '-' for all but.");

        college.setToolTipText("Match courses in this college. '-' for all but.");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Title");
        jLabel8.setToolTipText("Match courses meeting in the building with this name. '-' for all but.");

        title.setToolTipText("Match courses meeting in the building with this name. '-' for all but.");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Course #");
        jLabel11.setToolTipText("Match courses with this course number. '-' for all but.");

        courseNum.setToolTipText("Match courses with this course number. '-' for all but.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creditsAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(college))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(courseNum))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditsAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(college, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Basic", jPanel2);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Wildcard");
        jLabel6.setToolTipText("Match a wildcard flag. See *help_wildcard* for more.");

        wildcardMatch.setToolTipText("Match a wildcard flag. See *help_wildcard* for more.");

        taughtByTA.setSelected(true);
        taughtByTA.setText("Taught by TA");
        taughtByTA.setToolTipText("Check if you are okay with TAs/GAs teaching this class");

        taughtByProfessor.setSelected(true);
        taughtByProfessor.setText("Taught by Professor");
        taughtByProfessor.setToolTipText("Check if you are okay with professors teaching this class");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Prof Type");
        jLabel7.setToolTipText("Select which types of lecturers are matched by this course");

        monday.setSelected(true);
        monday.setText("M");
        monday.setToolTipText("Class can meet on Mondays");

        tuesday.setSelected(true);
        tuesday.setText("T");
        tuesday.setToolTipText("Class can meet on Tuesdays");

        wednesday.setSelected(true);
        wednesday.setText("W");
        wednesday.setToolTipText("Class can meet on Wednesdays");

        thursday.setSelected(true);
        thursday.setText("TH");
        thursday.setToolTipText("Class can meet on Thursdays");

        friday.setSelected(true);
        friday.setText("F");
        friday.setToolTipText("Class can meet on Fridays");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Day of Week");
        jLabel10.setToolTipText("Select which days of the week matched courses may meet");

        building.setToolTipText("Match a wildcard flag. See *help_wildcard* for more.");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Building");
        jLabel12.setToolTipText("Match a wildcard flag. See *help_wildcard* for more.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wildcardMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taughtByTA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taughtByProfessor))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tuesday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wednesday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thursday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friday))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(building, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wildcardMatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taughtByTA)
                    .addComponent(taughtByProfessor)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monday)
                    .addComponent(tuesday)
                    .addComponent(wednesday)
                    .addComponent(thursday)
                    .addComponent(friday)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(building, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Advanced", jPanel3);

        jLabel9.setText("*Any field may be left blank");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel9))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(fromBase){
            //We are using a base item. 
            JList list = (JList) InstanceData.fetch("list_to_update");
            AbstractListModel alm = (AbstractListModel<String>) list.getModel();
            String[] newContents = new String[alm.getSize()];
            for(int i = 0; i < alm.getSize(); i++){
                newContents[i] = (String) alm.getElementAt(i);
            }
            
            // Remake the object
            CourseObject co = new CourseObject();
            co.setBuilding(building.getText()); 
            co.setTitle(title.getText());
            co.setCollege(college.getText()); 
            co.setCreditAmount(creditsAmt.getText()); 
            co.setWildcard(wildcardMatch.getText()); 
            co.setCourseNumber(courseNum.getText()); 
            co.setTeacher(teacherName.getText()); 
            co.setSubject(subjectName.getText()); 

            co.setMonday(monday.isSelected());
            co.setTuesday(tuesday.isSelected());
            co.setWednesday(wednesday.isSelected());
            co.setThursday(thursday.isSelected());
            co.setFriday(friday.isSelected());

            co.setTaughtByProfessor(taughtByProfessor.isSelected());
            co.setTaughtByTA(taughtByTA.isSelected());

            String key = co.getKey();
            
            int spot = -1;
            for(int i = 0; i < newContents.length; i++){
                if(newContents[i].equals(prevKey)){
                    spot = i;
                    break;
                }
            }
            newContents[spot] = key;
            
            InstanceData.store(key, co);
            InstanceData.remove(prevKey);
            
            list.setListData(newContents);
            WindowUtil.CloseTemporaryFrame("add_class");
            return;
        }
        //This is a brand new item
        JList list = (JList) InstanceData.fetch("list_to_update");
        AbstractListModel alm = (AbstractListModel<String>) list.getModel();
        String[] newContents = new String[alm.getSize() + 1];
        for(int i = 0; i < alm.getSize(); i++){
            newContents[i] = (String) alm.getElementAt(i);
        }
        
        // Make the object
        CourseObject co = new CourseObject();
        co.setBuilding(building.getText()); 
        co.setTitle(title.getText());
        co.setCollege(college.getText()); 
        co.setCreditAmount(creditsAmt.getText()); 
        co.setWildcard(wildcardMatch.getText()); 
        co.setCourseNumber(courseNum.getText()); 
        co.setTeacher(teacherName.getText()); 
        co.setSubject(subjectName.getText()); 
        
        co.setMonday(monday.isSelected());
        co.setTuesday(tuesday.isSelected());
        co.setWednesday(wednesday.isSelected());
        co.setThursday(thursday.isSelected());
        co.setFriday(friday.isSelected());
        
        co.setTaughtByProfessor(taughtByProfessor.isSelected());
        co.setTaughtByTA(taughtByTA.isSelected());
        
        String key =  co.getKey();
        
        InstanceData.store(key, co);
        
        newContents[newContents.length - 1] = key; // Some sort of thing.
        list.setListData(newContents);
        WindowUtil.CloseTemporaryFrame("add_class"); //6-237?
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        //This button will reset to default values
        friday.setSelected(true);
        thursday.setSelected(true);
        wednesday.setSelected(true);
        thursday.setSelected(true);
        friday.setSelected(true);
        
        subjectName.setText("");
        teacherName.setText("");
        courseNum.setText("");
        wildcardMatch.setText("");
        creditsAmt.setText("");
        college.setText("");
        title.setText("");
        building.setText("");
        
        taughtByTA.setSelected(true);
        taughtByProfessor.setSelected(true);
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField building;
    private javax.swing.JTextField college;
    private javax.swing.JTextField courseNum;
    private javax.swing.JTextField creditsAmt;
    private javax.swing.JCheckBox friday;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox monday;
    private javax.swing.JTextField subjectName;
    private javax.swing.JCheckBox taughtByProfessor;
    private javax.swing.JCheckBox taughtByTA;
    private javax.swing.JTextField teacherName;
    private javax.swing.JCheckBox thursday;
    private javax.swing.JTextField title;
    private javax.swing.JCheckBox tuesday;
    private javax.swing.JCheckBox wednesday;
    private javax.swing.JTextField wildcardMatch;
    // End of variables declaration//GEN-END:variables
}