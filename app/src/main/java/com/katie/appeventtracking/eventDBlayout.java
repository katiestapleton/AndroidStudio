package com.katie.appeventtracking;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public abstract class eventDBlayout extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eventDB.db";

    public eventDBlayout(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    private static final class EventTable {
        private static final String TABLE = "Events";
        private static final String COL_ID = "_ID";
        private static final String COL_DATE = "Date";
        private static final String COL_TIME = "Time";
        private static final String COL_NAME = "Name";
        private static final String COL_DESC = "Description";
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("create table " + EventTable.TABLE + " (" +
            EventTable.COL_ID + " integer primary key autoincrement, " +
            EventTable.COL_DATE + " text, " +
            EventTable.COL_TIME + " text, " +
            EventTable.COL_NAME + " text, " +
            EventTable.COL_DESC + " text)"
        );
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + EventTable.TABLE);
        onCreate(db);
    }
}
