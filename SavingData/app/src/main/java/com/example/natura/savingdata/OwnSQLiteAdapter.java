package com.example.natura.savingdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OwnSQLiteAdapter {

    OwnSQLiteOpenHelper ownSQLiteOpenHelper;

    public OwnSQLiteAdapter(Context context) {
        ownSQLiteOpenHelper = new OwnSQLiteOpenHelper(context);
        SQLiteDatabase db = ownSQLiteOpenHelper.getWritableDatabase();
    }
    public long insertData(String title, String director, String year) {
        SQLiteDatabase db = ownSQLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ownSQLiteOpenHelper.FILM_TITLE, title);
        contentValues.put(ownSQLiteOpenHelper.FILM_DIRECTOR, director);
        contentValues.put(ownSQLiteOpenHelper.FILM_YEAR, year);

        long result = db.insert(ownSQLiteOpenHelper.TABLE_NAME, null, contentValues);

        return result;
    }

    public String getAllData() {
        SQLiteDatabase db = ownSQLiteOpenHelper.getWritableDatabase();
        String [] columns = {ownSQLiteOpenHelper.FILM_TITLE, ownSQLiteOpenHelper.FILM_DIRECTOR, ownSQLiteOpenHelper.FILM_YEAR};
        StringBuffer sb = new StringBuffer();
        Cursor cursor = db.query(ownSQLiteOpenHelper.TABLE_NAME, columns, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int index0 = cursor.getColumnIndex(ownSQLiteOpenHelper.FILM_ID);
            int index1 = cursor.getColumnIndex(ownSQLiteOpenHelper.FILM_TITLE);
            int index2 = cursor.getColumnIndex(ownSQLiteOpenHelper.FILM_DIRECTOR);
            int index3 = cursor.getColumnIndex(ownSQLiteOpenHelper.FILM_YEAR);
            String title = cursor.getString(index1);
            String director = cursor.getString(index2);
            String year = cursor.getString(index3);
            sb.append(" Film " + " \n " + title + " \n " + director + " \n " + year + " \n");
        }
        db.close();
        return sb.toString();
    }

    public int deleteDataFromDB(String id) {
        SQLiteDatabase db = ownSQLiteOpenHelper.getWritableDatabase();
        int state = db.delete(ownSQLiteOpenHelper.TABLE_NAME, "Id = ?", new String[]{id});
        return state;
    }

    public boolean updateDataFromDB(String id, String title, String director, String year) {
        SQLiteDatabase db = ownSQLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ownSQLiteOpenHelper.FILM_ID, id);
        contentValues.put(ownSQLiteOpenHelper.FILM_TITLE, title);
        contentValues.put(ownSQLiteOpenHelper.FILM_DIRECTOR, director);
        contentValues.put(ownSQLiteOpenHelper.FILM_YEAR, year);
        db.update(ownSQLiteOpenHelper.TABLE_NAME, contentValues, "Id = ?", new String[]{id});

        //int state = db.delete(mySQLiteOpenHelper.TABLE_NAME, "Id = ?", new String[]{id});
        return true;
    }

}

