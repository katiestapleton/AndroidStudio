package com.katie.appeventtracking;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class eventDatabase {
    private static eventDatabase sEventDatabase;
    private List<Events> mEvents;

    public static eventDatabase getInstance(Context context) {
        if (sEventDatabase == null) {
            sEventDatabase = new eventDatabase(context);
        }
        return sEventDatabase;
    }

    private eventDatabase(Context context) {
        mEvents = new ArrayList<>();
        Resources res = context.getResources();
        String [] eventDate = res.getStringArray(R.array.eventsDateArray);
        String [] eventTime = res.getStringArray(R.array.eventsTimeArray);
        String [] eventName = res.getStringArray(R.array.eventsNameArray);
        String [] eventDescribe = res.getStringArray(R.array.eventsDescribeArray);
        // loops to add each event
        for(int i = 0; i < eventDate.length; i++) {
            mEvents.add(new Events(i + 1, eventDate[i], eventTime[i], eventName[i], eventDescribe[i]));
        }
    }

    public List<Events> getEvents() {
        return getEvents();
    }

    public Events getEvents(int eventID) {
        for (Events events : mEvents) {
            if (events.getEventID() == eventID) {
                return events;
            }
        }
        return null;
    }
}
