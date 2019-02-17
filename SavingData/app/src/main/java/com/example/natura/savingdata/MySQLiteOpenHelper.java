package com.example.natura.savingdata;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "mydatabase.db";
    private final static int DATABASE_VERSION = 1;
    private final static String TABLE_NAME = "mytable";
    private final static String USER_ID = "Id";
    private final static String USER_NAME = "Name";
    private final static String USER_AGE = "AGE";

    private final static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " VARCHAR(250), " +  USER_AGE + " VARCHAR(250));";
    private Context myContext;

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
