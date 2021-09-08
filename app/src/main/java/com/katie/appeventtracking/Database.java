package com.katie.appeventtracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// creates event database
public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "events.db";
    private static final int VERSION = 1;

    private static Database mEventDB;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public static Database getInstance(Context context) {
        if (mEventDB == null) {
            mEventDB = new Database(context);
        }
        return mEventDB;
    }

    private static final class EventTable {
        private static final String TABLE = "events";
        private static final String COL_ID = "_id";
        private static final String COL_DATE = "date";
        private static final String COL_TIME = "time";
        private static final String COL_NAME = "name";
        private static final String COL_DESC = "describe";
    }

    private static final class UserTable {
        private static final String TABLE = "users";
        private static final String COL_ID = "_id";
        private static final String COL_USER = "user";
        private static final String COL_PASS = "pass";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + EventTable.TABLE + " (" +
                EventTable.COL_ID + " integer primary key autoincrement, " +
                EventTable.COL_DATE + " text, " +
                EventTable.COL_TIME + " text, " +
                EventTable.COL_NAME + " text, " +
                EventTable.COL_DESC + " text)");

        db.execSQL("create table " + UserTable.TABLE + " (" +
                UserTable.COL_ID + " integer primary key autoincrement, " +
                UserTable.COL_USER + " text, " +
                UserTable.COL_PASS + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists " + EventTable.TABLE);
        onCreate(db);
    }

    // EVENTS - CRUD
    // add event to DB
    public long addEvent(Event event) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EventTable.COL_DATE, event.getmDate());
        values.put(EventTable.COL_TIME, event.getmTime());
        values.put(EventTable.COL_NAME, event.getmName());
        values.put(EventTable.COL_DESC, event.getmDescribe());

        long eventId = db.insert(EventTable.TABLE, null, values);
        return eventId;
    }

    // read event from DB
    public void getEvent(Event mId) {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "select * from " + EventTable.TABLE + " where rating = ?";
        Cursor cursor = db.rawQuery(sql, new String[] {});
        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(0);
                String user = cursor.getString(1);
                String pass = cursor.getString(2);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    // update event from DB
    public void updateEvent(Event event) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EventTable.COL_ID, event.getmId());
        values.put(EventTable.COL_DATE, event.getmDate());
        values.put(EventTable.COL_TIME, event.getmTime());
        values.put(EventTable.COL_NAME, event.getmName());
        values.put(EventTable.COL_DESC, event.getmDescribe());

        db.update(EventTable.TABLE, values, EventTable.COL_ID + " = " + event.getmId(), null);
    }

    // delete event from DB
    public void deleteEvent(Event eventId) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(EventTable.TABLE,EventTable.COL_ID + " = " + eventId, null);
    }

    // USER
    // add new user
    public long addUser(User user) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserTable.COL_USER, user.getmUser());
        values.put(UserTable.COL_PASS, user.getmPass());

        long userId = db.insert(UserTable.TABLE, null, values);
        return userId;
    }

    // read user/pass by reading user data first
    public void getUserbyName(String mUser) {
        User users = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "select * from " + UserTable.TABLE + " where " + UserTable.COL_USER + " = ?";
        Cursor cursor = db.rawQuery(sql,new String[] { mUser });
        if(cursor.moveToFirst()) {
            users = new User();
            long id = cursor.getLong(0);
            String user = cursor.getString(1);
            String pass = cursor.getString(2);
        }

    }


}
