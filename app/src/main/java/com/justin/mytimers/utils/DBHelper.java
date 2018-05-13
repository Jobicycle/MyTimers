package com.justin.mytimers.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.justin.mytimers.model.StopWatch;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + StopWatch.TABLE + "( "
                + StopWatch.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StopWatch.KEY_NAME + " TEXT, "
                + StopWatch.KEY_START + " INTEGER, "
                + StopWatch.KEY_STOP + " INTEGER, "
                + StopWatch.KEY_DURATION + " INTEGER )";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + StopWatch.TABLE);
        onCreate(db);
    }
}