package com.katie.appeventtracking.data.model;

import java.io.Serializable;


public class eventSample implements Serializable {

    //FIXME: switch date and time to proper variable after basic table is established
    // APPLIES TO DEFINITIONS, SETTERS, GETTERS, AND PRODUCTS
    private  String data_eventID;
    private  String data_eventDate;
    private  String data_eventTime;
    private  String data_eventName;
    private  String data_eventDescribe;


    public String getData_eventID() { return data_eventID;}

    public void setData_eventID(String data_eventID) {
        this.data_eventID = data_eventID;
    }

    public String getData_eventDate() {
        return data_eventDate;
    }

    public void setData_eventDate(String data_eventDate) {
        this.data_eventDate = data_eventDate;
    }

    public String getData_eventTime() {
        return data_eventTime;
    }

    public void setData_eventTime(String data_eventTime) {
        this.data_eventTime = data_eventTime;
    }

    public String getData_eventName() {
        return data_eventName;
    }

    public void setData_eventName(String data_eventName) {
        this.data_eventName = data_eventName;
    }

    public String getData_eventDescribe() {
        return data_eventDescribe;
    }

    public void setData_eventDescribe(String data_eventDescribe) {
        this.data_eventDescribe = data_eventDescribe;
    }

    public eventSample (String data_eventDate, String data_eventTime, String data_eventName, String data_eventDescribe) {
        this.data_eventDate = data_eventDate;
        this.data_eventTime = data_eventTime;
        this.data_eventName = data_eventName;
        this.data_eventDescribe = data_eventDescribe;
    }
}
