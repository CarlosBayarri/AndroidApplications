package com.example.natura.savingdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteAdapter {

    MySQLiteOpenHelper mySQLiteOpenHelper;

    public MySQLiteAdapter(Context context) {
        mySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
    }
    public long insertData(String name, String age) {
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(mySQLiteOpenHelper.USER_NAME, name);
        contentValues.put(mySQLiteOpenHelper.USER_AGE, age);

        long result = db.insert(mySQLiteOpenHelper.TABLE_NAME, null, contentValues);

        return result;
    }

    public String getAllData() {
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        String [] columns = {mySQLiteOpenHelper.USER_NAME, mySQLiteOpenHelper.USER_AGE};
        StringBuffer sb = new StringBuffer();
        Cursor cursor = db.query(mySQLiteOpenHelper.TABLE_NAME, columns, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(mySQLiteOpenHelper.USER_NAME);
            int index2 = cursor.getColumnIndex(mySQLiteOpenHelper.USER_AGE);
            String name = cursor.getString(index1);
            String age = cursor.getString(index2);
            sb.append(name + "  " + age + "\n");
        }
        db.close();
        return sb.toString();
    }

    public int deleteDataFromDB(String id) {
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        int state = db.delete(mySQLiteOpenHelper.TABLE_NAME, "Id = ?", new String[]{id});
        return state;
    }

    public boolean updateDataFromDB(String id, String name, String age) {
        SQLiteDatabase db = mySQLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(mySQLiteOpenHelper.USER_ID, id);
        contentValues.put(mySQLiteOpenHelper.USER_NAME, name);
        contentValues.put(mySQLiteOpenHelper.USER_AGE, age);
        db.update(mySQLiteOpenHelper.TABLE_NAME, contentValues, "Id = ?", new String[]{id});

        //int state = db.delete(mySQLiteOpenHelper.TABLE_NAME, "Id = ?", new String[]{id});
        return true;
    }

    static class MySQLiteOpenHelper extends SQLiteOpenHelper {

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

}
