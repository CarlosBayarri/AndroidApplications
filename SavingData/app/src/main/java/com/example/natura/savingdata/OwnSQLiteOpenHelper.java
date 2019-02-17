package com.example.natura.savingdata;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OwnSQLiteOpenHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "films.db";
    private final static int DATABASE_VERSION = 1;
    public final static String TABLE_NAME = "films";
    public final static String FILM_ID = "Id";
    public final static String FILM_TITLE = "Title";
    public final static String FILM_DIRECTOR = "Director";
    public final static String FILM_YEAR = "Year";

    private final static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + FILM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FILM_TITLE + " VARCHAR(250), " + FILM_DIRECTOR + " VARCHAR(250), " +  FILM_YEAR + " VARCHAR(250));";
    private Context myContext;

    public OwnSQLiteOpenHelper(Context context) {
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
