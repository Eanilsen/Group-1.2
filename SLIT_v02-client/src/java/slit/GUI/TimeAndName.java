/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javafx.scene.layout.Pane;
 
/**
 *A Class to handle time and dates 
 * Are displayed from Superview. In the GUI.
 * @author Jørgen HG.
 */
public class TimeAndName extends Pane {
 
    private int hour;
    private int min;
    private int sec;
    private int year;
    private int month;
    private int day_Of_Month;
    private String currentUser;
    private String timestamp;

    
 
    /**
     * Constructor for Time and Name.
     * Makes a new GregorianCalendar and a new SimpleDateFormat
     */
    public TimeAndName() {
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
        
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.min = cal.get(Calendar.MINUTE);
        this.sec = cal.get(Calendar.SECOND);
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH)+1;
        this.day_Of_Month = cal.get(Calendar.DAY_OF_MONTH);
        timestamp = sdf.format(cal.getTime());
        this.currentUser = "Student Studentson";
    }
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
 
    public String getCurrentUser() {
        return currentUser;
    }
 
    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
 
    public int getYear() {
        return year;
    }
 
    public void setYear(int year) {
        this.year = year;
    }
 
    public int getMonth() {
        return month;
    }
 
    public void setMonth(int month) {
        this.month = month;
    }
 
    public int getDay_Of_Month() {
        return day_Of_Month;
    }
 
    public void setDay_Of_Month(int day_Of_Month) {
        this.day_Of_Month = day_Of_Month;
    }
 
    public int getHour() {
        return hour;
    }
 
    public void setHour(int hour) {
        this.hour = hour;
    }
 
    public int getMin() {
        return min;
    }
 
    public void setMin(int min) {
        this.min = min;
    }
 
    public int getSec() {
        return sec;
 
    }
 
    public void setSec(int sec) {
        this.sec = sec;
 
    }
 
    /**
     * This metod returns. A HH:mm:ss time format. 
     * As a string.
     * @return timestamp 
     */
    protected String getTimeString() {
        return timestamp;
    }
    /**
     * This metods returns and formats
     * @return day.month.year
     */
    protected String getDateString() {
        return day_Of_Month + "." + month + "." + year;
    }
 
    /**
     * This metod return
     * 2 Desember 2015 Note; 
     * This is hardcoded as and do
     * not correctly display the current user. 
     * @return String + currentUser 
     */
    protected String getUserString() {
        return "Welcome " + currentUser;
    }
 
}