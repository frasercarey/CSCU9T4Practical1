// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField where = new JTextField(10);
    private JTextField terrain = new JTextField(10);
    private JTextField tempo = new JTextField(10);
    private JTextField sprints = new JTextField(2);
    private JTextField recovery = new JTextField(2);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labst = new JLabel(" Session Type:");
    private JLabel labw = new JLabel(" Where:");
    private JLabel labt = new JLabel(" Terrain:");
    private JLabel labte = new JLabel(" Tempo:");
    private JLabel labsp = new JLabel(" Sprints:");
    private JLabel labr = new JLabel(" Recovery:");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("FindAllByDate");
    
    private enum sessionTypes {
        CYCLE, RUN, SPRINT, SWIM
    }
    
    private JComboBox sessionType = new JComboBox(sessionTypes.values());

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labst);
        add(sessionType);
        sessionType.addActionListener(this);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labw);
        add(where);
        where.setEditable(false);
        add(labt);
        add(terrain);
        terrain.setEditable(true);
        add(labte);
        add(tempo);
        tempo.setEditable(true);
        add(labsp);
        add(sprints);
        sprints.setEditable(false);
        add(labr);
        add(recovery);
        recovery.setEditable(false);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(800, 250);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            String session = sessionType.getSelectedItem().toString();
            message = addEntry(session);
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = lookupEntries();
        }
        if (event.getSource() == sessionType) {
            String session = sessionType.getSelectedItem().toString();
            switch (session) {
                case "CYCLE":
                    where.setEditable(false);
                    terrain.setEditable(true);
                    tempo.setEditable(true);
                    sprints.setEditable(false);
                    recovery.setEditable(false);
                    break;
                case "RUN":
                    where.setEditable(false);
                    terrain.setEditable(false);
                    tempo.setEditable(false);
                    sprints.setEditable(false);
                    recovery.setEditable(false);
                    break;
                case "SPRINT":
                    where.setEditable(false);
                    terrain.setEditable(false);
                    tempo.setEditable(false);
                    sprints.setEditable(true);
                    recovery.setEditable(true);
                    break;
                case "SWIM":
                    where.setEditable(true);
                    terrain.setEditable(false);
                    tempo.setEditable(false);
                    sprints.setEditable(false);
                    recovery.setEditable(false);
                    break;
            }
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String session = sessionType.getSelectedItem().toString();
        Entry entry;
        switch(session) {
            case "CYCLE":
                String t = terrain.getText();
                String te = tempo.getText();
                entry = new Cycle(n, d, m, y, h, mm, s, km, t, te);
                break;
            case "RUN":
                entry = new Run(n, d, m, y, h, mm, s, km);
                break;
            case "SPRINT":
                int sp = Integer.parseInt(sprints.getText());
                int r = Integer.parseInt(recovery.getText());
                entry = new Sprint(n, d, m, y, h, mm, s, km, sp, r);
                break;
            case "SWIM":
                String w = where.getText();
                entry = new Swim(n, d, m, y, h, mm, s, km, w);
                break;
            default:
                entry = new Entry(n, d, m, y, h, mm, s, km);
        }
        
        //Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(entry);
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    
    public String lookupEntries() {
        int d = Integer.parseInt(day.getText());
        int m = Integer.parseInt(month.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up records...");
        return myAthletes.lookupEntries(d, m, y);
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        where.setText("");
        terrain.setText("");
        tempo.setText("");
        sprints.setText("");
        recovery.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

