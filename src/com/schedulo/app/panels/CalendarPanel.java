/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//TODO choose from pastels for different class colors. 
//TODO add a tooltip on hover with in-depth description of the thing.
package com.schedulo.app.panels;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.schedulo.app.objects.ScheduleObject;
import com.schedulo.app.objects.StartEndTuple;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 *
 * @author jmaher
 */
public class CalendarPanel extends javax.swing.JPanel {
    
    private boolean isDirty = false;

    private ScheduleObject sObj;
    
    Map<Integer, Values> dayValues = new HashMap<Integer, Values>();
    Map<Long, Values> hourValues = new HashMap<Long, Values>();
    Map<String, Color> colorMap = new HashMap<String, Color>();
    
    Long oneHour = 60L;
    Long minutesInDay = 24L * 60L;

    class Values {

        public int x = -1, y = -1;
        public int width = -1, height = -1;
    }

    /**
     * Creates new form CalendarPanel
     */
    public CalendarPanel(ScheduleObject so) {
        initComponents();
        initValuesforDays();
        initValuesforHours();
           
        this.sObj = so;
        List<StartEndTuple> meetingTimes = so.getMeetingTimes();
        for (StartEndTuple setO : meetingTimes) {
            long begin = setO.getStartTime();
            long end = setO.getEndTime();

            int dayOfWeek = (int) (begin / minutesInDay) + 1;

            // Will be one for monday, two for tuesday, etc...
            long beginOnDay = begin % minutesInDay;
            long endOnDay = end % minutesInDay;

            long extraBegin = beginOnDay % oneHour; // Amt between hours.
            Long closestHourDownBegin = (beginOnDay - extraBegin); // The closest last hour.

            long extraEnd = endOnDay % oneHour;
            Long closestHourDownEnd = (endOnDay - extraEnd);

            int yOffset = hourValues.get(closestHourDownBegin).y;
            int yEndset = hourValues.get(closestHourDownEnd).y;
            int yAfterY = hourValues.get(closestHourDownEnd + 60).y;

            int height = yEndset - yOffset;
            int afterHeight = yAfterY - yEndset;

            double mod = ((double) extraBegin / 60L);
            double toAddAfter = ((double) extraEnd / 60L);

            double amtToAdd = mod * height;
            double amtToAddAfter = toAddAfter * afterHeight;

            yOffset += amtToAdd;
            yEndset += amtToAddAfter;

            height = yEndset - yOffset;

            int xPos = dayValues.get(dayOfWeek).x;
            int width = dayValues.get(dayOfWeek).width;

            javax.swing.JPanel newRect = new javax.swing.JPanel();

            Color c;
            if (this.colorMap.containsKey(so.getOwner(setO))) {
                c = this.colorMap.get(so.getOwner(setO));
            } else {
                //Generate a new one.
                Random rand = new Random();
                c = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                this.colorMap.put(so.getOwner(setO), c);
            }

            newRect.setBackground(c);
            newRect.addMouseListener(new ItemListen());
            jPanel2.add(newRect, new org.netbeans.lib.awtextra.AbsoluteConstraints(xPos, yOffset, width, height)); //x, y, width, heigt
        }

    }

    private void initValuesforHours() {
        Values sval = new Values();
        sval.y = 65;
        hourValues.put(oneHour * 7, sval);

        Values eival = new Values();
        eival.y = 100;
        hourValues.put(oneHour * 8, eival);

        Values nival = new Values();
        nival.y = 130;
        hourValues.put(oneHour * 9, nival);

        Values tenval = new Values();
        tenval.y = 162;
        hourValues.put(oneHour * 10, tenval);

        Values elevenval = new Values();
        elevenval.y = 193;
        hourValues.put(oneHour * 11, elevenval);

        Values twelveval = new Values();
        twelveval.y = 221;
        hourValues.put(oneHour * 12, twelveval);

        Values oneval = new Values();
        oneval.y = 254;
        hourValues.put(oneHour * 13, oneval);

        Values twoval = new Values();
        twoval.y = 285;
        hourValues.put(oneHour * 14, twoval);

        Values threeval = new Values();
        threeval.y = 315;
        hourValues.put(oneHour * 15, threeval);

        Values fourval = new Values();
        fourval.y = 347;
        hourValues.put(oneHour * 16, fourval);

        Values fiveval = new Values();
        fiveval.y = 378;
        hourValues.put(oneHour * 17, fiveval);

        Values sixval = new Values();
        sixval.y = 405;
        hourValues.put(oneHour * 18, sixval);

        Values sevenval = new Values();
        sevenval.y = 437;
        hourValues.put(oneHour * 19, sevenval);

        Values eightval = new Values();
        eightval.y = 460;
        hourValues.put(oneHour * 20, eightval);

        Values nineval = new Values();
        nineval.y = 495;
        hourValues.put(oneHour * 21, nineval);
    }

    private void initValuesforDays() {
        Values val = new Values();
        val.width = 90;
        val.x = 72;
        dayValues.put(1, val);

        Values sval = new Values();
        sval.width = 107;
        sval.x = 175;
        dayValues.put(2, sval);

        Values dval = new Values();
        dval.width = 106;
        dval.x = 296;
        dayValues.put(3, dval);

        Values thVal = new Values();
        thVal.width = 107;
        thVal.x = 415;
        dayValues.put(4, thVal);

        Values fVal = new Values();
        fVal.width = 98;
        fVal.x = 535;
        dayValues.put(5, fVal);
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
        jLabel22 = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        professor = new javax.swing.JLabel();
        courseNum = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        subject = new javax.swing.JLabel();
        seatsAvailable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        triangle = new javax.swing.JPanel();
        triangle1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 246));

        jPanel1.setBackground(new java.awt.Color(198, 40, 40));

        jLabel22.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Planner Schedule View");

        courseName.setForeground(new java.awt.Color(255, 255, 255));

        professor.setForeground(new java.awt.Color(255, 255, 255));
        professor.setText("Professor: ");

        courseNum.setForeground(new java.awt.Color(255, 255, 255));
        courseNum.setText("Course Number:");

        type.setForeground(new java.awt.Color(255, 255, 255));
        type.setText("Type:");

        subject.setForeground(new java.awt.Color(255, 255, 255));
        subject.setText("Subject:");

        seatsAvailable.setForeground(new java.awt.Color(255, 255, 255));
        seatsAvailable.setText("Seats Available:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(professor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseNum, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatsAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseName)
                            .addComponent(type))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(professor)
                            .addComponent(seatsAvailable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseNum)
                            .addComponent(subject)))
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(245, 245, 246));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(245, 245, 246));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Monday");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 6, 96, 28));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 50, 10, 450));

        jLabel2.setBackground(new java.awt.Color(245, 245, 246));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tuesday");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 6, 96, 28));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 6, -1, 28));

        jLabel3.setBackground(new java.awt.Color(245, 245, 246));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Wednesday");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 6, 96, 28));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 6, -1, 28));

        jLabel4.setBackground(new java.awt.Color(245, 245, 246));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thursday");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 6, 96, 28));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 6, -1, 28));

        jLabel5.setBackground(new java.awt.Color(245, 245, 246));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Friday");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 6, 96, 28));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 40, 576, 10));

        jLabel6.setBackground(new java.awt.Color(245, 245, 246));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("7:00 AM");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, -1, 25));

        jLabel7.setBackground(new java.awt.Color(245, 245, 246));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("8:00 AM");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 87, -1, 25));

        jLabel8.setBackground(new java.awt.Color(245, 245, 246));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("9:00 AM");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 118, -1, 25));

        jLabel9.setBackground(new java.awt.Color(245, 245, 246));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("10:00 AM");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, 25));

        jLabel10.setBackground(new java.awt.Color(245, 245, 246));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("11:00 AM");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, 25));

        jLabel11.setBackground(new java.awt.Color(245, 245, 246));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("12:00 PM");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, 25));

        jLabel12.setBackground(new java.awt.Color(245, 245, 246));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("1:00 PM");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 242, -1, 25));

        jLabel13.setBackground(new java.awt.Color(245, 245, 246));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("2:00 PM");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 273, -1, 25));

        jLabel14.setBackground(new java.awt.Color(245, 245, 246));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("3:00 PM");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 304, -1, 25));

        jLabel15.setBackground(new java.awt.Color(245, 245, 246));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("4:00 PM");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 335, -1, 25));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 6, -1, 28));

        jLabel17.setBackground(new java.awt.Color(245, 245, 246));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("9:00 PM");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 60, 30));

        jLabel18.setBackground(new java.awt.Color(245, 245, 246));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("5:00 PM");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 366, -1, 25));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, 450));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 50, 10, 450));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 50, 10, 450));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 50, 10, 450));

        triangle.setBackground(new java.awt.Color(255, 102, 255));

        javax.swing.GroupLayout triangleLayout = new javax.swing.GroupLayout(triangle);
        triangle.setLayout(triangleLayout);
        triangleLayout.setHorizontalGroup(
            triangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        triangleLayout.setVerticalGroup(
            triangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(triangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 130, 106, -1));

        triangle1.setBackground(new java.awt.Color(255, 102, 255));

        javax.swing.GroupLayout triangle1Layout = new javax.swing.GroupLayout(triangle1);
        triangle1.setLayout(triangle1Layout);
        triangle1Layout.setHorizontalGroup(
            triangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        triangle1Layout.setVerticalGroup(
            triangle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(triangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 70, 107, -1));

        jLabel19.setBackground(new java.awt.Color(245, 245, 246));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("6:00 PM");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 60, 30));

        jLabel20.setBackground(new java.awt.Color(245, 245, 246));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("7:00 PM");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 60, 30));

        jLabel21.setBackground(new java.awt.Color(245, 245, 246));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("8:00 PM");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 60, 30));

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseName;
    private javax.swing.JLabel courseNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel professor;
    private javax.swing.JLabel seatsAvailable;
    private javax.swing.JLabel subject;
    private javax.swing.JPanel triangle;
    private javax.swing.JPanel triangle1;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables

    private class ItemListen implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //Open a new class add window, but for readonly, all windows disabled for editing.
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            if(isDirty){
                Component co = e.getComponent();

                if(co == null){
                    return;
                }
                JsonObject thisObj = null;
                Color background = co.getBackground();
                for(Entry<String, Color> e1 : colorMap.entrySet()){
                    if(e1.getValue() == background){
                        String owner = e1.getKey();
                        thisObj = sObj.getCourseJson(owner);
                        break;
                    }
                }
                String profName = "-";
                for(JsonValue val : thisObj.get("faculty").asArray()){
                    JsonObject subObj = val.asObject();
                    profName = subObj.getString("displayName", "");
                    if(subObj.getBoolean("primaryIndicator", false)){
                        break;
                    }
                }
                
                // We need to set the label
                courseName.setText(thisObj.getString("courseTitle", "-"));
                professor.setText("Professor: " + profName);
                courseNum.setText("Course Number: " + thisObj.getString("courseNumber", "-"));
                type.setText("Type: " + thisObj.getString("scheduleTypeDescription", "-"));
                subject.setText("Subject: " + thisObj.getString("subject", "-"));
                seatsAvailable.setText("Seats Available: " + String.valueOf(thisObj.getInt("seatsAvailable", 0)));
                isDirty = false;
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!isDirty){
                courseName.setText("-");
                professor.setText("Professor: -");
                courseNum.setText("Course Number: -");
                type.setText("Type: -");
                subject.setText("Subject: -");
                seatsAvailable.setText("Seats Available: 0");
                isDirty = true;
            }
        }
        
    }
    
}
