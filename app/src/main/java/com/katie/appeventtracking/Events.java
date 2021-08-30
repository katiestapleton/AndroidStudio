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

        public int getEventID() {
            return data_eventID;}

        public void setEventID(int eventID) {
            this.data_eventID = eventID;
        }

        public String getEventDate() {
            return data_eventDate;
        }

        public void setData_eventDate(String eventDate) {
            this.data_eventDate = eventDate;
        }

        public String getEventTime() {
            return data_eventTime;
        }

        public void setEventTime(String eventTime) {
            this.data_eventTime = eventTime;
        }

        public String getEventName() {
            return data_eventName;
        }

        public void setEventName(String eventName) {
            this.data_eventName = eventName;
        }

        public String getEventDescribe() {
            return data_eventDescribe;
        }

        public void setEventDescribe(String eventDescribe) {
            this.data_eventDescribe = eventDescribe;
        }
    }

