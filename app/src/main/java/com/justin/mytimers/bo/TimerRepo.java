package com.justin.mytimers.bo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.justin.mytimers.model.StopWatch;
import com.justin.mytimers.utils.DBHelper;

public class TimerRepo {
    private DBHelper dbHelper;

    public TimerRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    /**
     * Insert a new timer record
     */
    public void insert(StopWatch stopWatch) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(StopWatch.KEY_NAME, stopWatch.getName());
        values.put(StopWatch.KEY_START, stopWatch.getStartTime());

        db.insert(StopWatch.TABLE, null, values);
        db.close();
    }
}
