package com.example.alwaysactive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBAlwaysActive {

    private static final String TABLE_NAME_EVENT = "Event";
    private static final String COLUMN_TIME_START = "time_start";
    private static final String COLUMN_TIME_END = "time_end";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE = "date";
    private final SQLiteDatabase db;


    public DBAlwaysActive(Context context) {
        OpenHelper mOpenHelper = new OpenHelper(context);
        db = mOpenHelper.getWritableDatabase();
        Cursor c = db.query(TABLE_NAME_EVENT, null, null, null, null, null, null);
    }

    public void insertEvent(String data){
        String[] i = data.split(" ");
        String[] dateS = i[0].split("-");
        String date = Integer.parseInt(dateS[0]) + "-" + Integer.parseInt(dateS[1]) + "-" + Integer.parseInt(dateS[2]);
        String timeS = i[1];
        String timeE = i[2];
        String name = i[3];

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_TIME_START, timeS);
        cv.put(COLUMN_TIME_END, timeE);
        cv.put(COLUMN_NAME, name);
        db.insert(TABLE_NAME_EVENT, null, cv);

    }

    public ArrayList<String> getDayEvents(String date){
        ArrayList<String> events = new ArrayList<>();

        Cursor c = db.query(TABLE_NAME_EVENT, null,  COLUMN_DATE + " = ?",
                new String[]{String.valueOf(date)}, null, null, COLUMN_TIME_START);
        if (c == null){
            return events;
        }

        String str;
        String name;
        String ts;
        String te;

        c.moveToFirst();

        name = c.getString(4);
        ts = c.getString(1);
        te = c.getString(2);
        str = ts + " " + te + " " + name;
        events.add(str);

        while (!c.isLast()){
            c.moveToNext();
            name = c.getString(4);
            ts = c.getString(1);
            te = c.getString(2);
            str = ts + " " + te + " " + name;
            events.add(str);
        }
        return events;
    }

    public class OpenHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "alwaysActive.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME_EVENT = "Event";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_TIME_START = "time_start";
        private static final String COLUMN_TIME_END = "time_end";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_DATE = "date";


        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME_EVENT + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TIME_START + " TEXT, " +
                    COLUMN_TIME_END + " TEXT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_NAME + " TEXT);";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EVENT);
            onCreate(db);
        }


    }

}
