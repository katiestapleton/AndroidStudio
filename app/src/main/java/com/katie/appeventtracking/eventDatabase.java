package com.katie.appeventtracking;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class eventDatabase {
    private static eventDatabase sEventDatabase;
    private Events<Events> mEvents;

    public static eventDatabase getInstance(Context context) {
        if (sEventDatabase == null) {
            sEventDatabase = new eventDatabase(context);
        }
        return sEventDatabase;
    }

    private eventDatabase(Context context) {

    }


}
