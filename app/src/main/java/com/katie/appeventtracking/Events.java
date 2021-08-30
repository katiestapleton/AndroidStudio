package com.katie.appeventtracking;

import java.io.Serializable;

public class Events<E> implements Serializable {

        //FIXME: switch date and time to proper variable after basic table is established
        // ISSUE APPLIES TO DEFINITIONS, SETTERS, GETTERS, AND PRODUCTS

        private  int data_eventID;
        private  String data_eventDate;
        private  String data_eventTime;
        private  String data_eventName;
        private  String data_eventDescribe;

        // Event Details constructor
        public Events() {}

        public Events(int eventID, String eventDate, String eventTime, String eventName, String eventDescribe) {
            this.data_eventID = eventID;
            this.data_eventDate = eventDate;
            this.data_eventTime = eventTime;
            this.data_eventName = eventName;
            this.data_eventDescribe = eventDescribe;
        }

        // setters and getters

        public int getData_eventID() {
            return data_eventID;}

        public void setData_eventID(int eventID) {
            this.data_eventID = eventID;
        }

        public String getData_eventDate() {
            return data_eventDate;
        }

        public void setData_eventDate(String eventDate) {
            this.data_eventDate = eventDate;
        }

        public String getData_eventTime() {
            return data_eventTime;
        }

        public void setData_eventTime(String eventTime) {
            this.data_eventTime = eventTime;
        }

        public String getData_eventName() {
            return data_eventName;
        }

        public void setData_eventName(String eventName) {
            this.data_eventName = eventName;
        }

        public String getData_eventDescribe() {
            return data_eventDescribe;
        }

        public void setData_eventDescribe(String eventDescribe) {
            this.data_eventDescribe = eventDescribe;
        }
    }

