/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.GUI;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
 
/**
 *
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
     *
     */
    public TimeAndName() {
        Calendar cal = new GregorianCalendar();
 
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.min = cal.get(Calendar.MINUTE);
        this.sec = cal.get(Calendar.SECOND);
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH);
        this.day_Of_Month = cal.get(Calendar.DAY_OF_MONTH);
 
    }
 
    protected void drawClock() {
 
        TimeAndName time = new TimeAndName();
        this.currentUser = "Simen";
 
    }
 
    protected String getTimeString() {
        return hour + ":" + min + ":" + sec;
    }
 
    protected String getDateString() {
        return year + " " + month + "/" + day_Of_Month;
    }
 
    protected String getUserString() {
        return "Welcome " + currentUser;
    }
 
}