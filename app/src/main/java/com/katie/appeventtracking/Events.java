package com.katie.appeventtracking;

import java.io.Serializable;

public class Events<E> implements Serializable {

        //FIXME: switch date and time to proper variable after basic table is established
        // ISSUE APPLIES TO DEFINITIONS, SETTERS, GETTERS, AND PRODUCTS

        private int eventID;
        private String eventDate;
        private String eventTime;
        private String eventName;
        private String eventDescribe;

        // Event Details constructor
        public Events() {}

        public Events(int eventID, String eventDate, String eventTime, String eventName, String eventDescribe) {
            this.eventID = eventID;
            this.eventDate = eventDate;
            this.eventTime = eventTime;
            this.eventName = eventName;
            this.eventDescribe = eventDescribe;
       }


        // setters and getters

        public int getEventID() {
           return eventID;}

        public void setEventID(int eventID) {
            this.eventID = eventID;
        }

        public String getEventDate() {
            return eventDate;
        }

        public void seteventDate(String eventDate) {
            this.eventDate = eventDate;
        }

        public String getEventTime() {
            return eventTime;
        }

        public void setEventTime(String eventTime) {
            this.eventTime = eventTime;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getEventDescribe() {
            return eventDescribe;
        }

        public void setEventDescribe(String eventDescribe) {
            this.eventDescribe = eventDescribe;
        }
    }

