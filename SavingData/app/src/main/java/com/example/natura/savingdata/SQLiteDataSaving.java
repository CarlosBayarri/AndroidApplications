package com.example.natura.savingdata;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteDataSaving extends Activity {

    EditText et_id, et_title, et_director, et_year;
    //MySQLiteOpenHelper mySQLiteOpenHelper;
    OwnSQLiteAdapter ownSQLiteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_data_saving);
        ownSQLiteAdapter = new OwnSQLiteAdapter(this);

        et_id = findViewById(R.id.et_id);
        et_title = findViewById(R.id.et_title);
        et_director = findViewById(R.id.et_director);
        et_year = findViewById(R.id.et_year);

    }

    public void addData(View view) {
        String title = et_title.getText().toString();
        String director = et_director.getText().toString();
        String year = et_year.getText().toString();

        if (ownSQLiteAdapter.insertData(title, director, year) < 0) {
            Toast.makeText(this, "Data can not be inserted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show();
        }
    }
    public void viewData(View view) {
        String allData = ownSQLiteAdapter.getAllData();
        Toast.makeText(this, allData, Toast.LENGTH_SHORT).show();
    }
    public void deleteData(View view) {
        String id = et_id.getText().toString();
        ownSQLiteAdapter.deleteDataFromDB(id);
        Toast.makeText(this, "Data deleted for the id: " + id, Toast.LENGTH_SHORT).show();
    }
    public void updateData(View view) {
        String id = et_id.getText().toString();
        String title = et_title.getText().toString();
        String director = et_director.getText().toString();
        String year = et_year.getText().toString();

        ownSQLiteAdapter.updateDataFromDB(id, title, director, year);
        Toast.makeText(this, "Data updated successfully for the id: " + id, Toast.LENGTH_SHORT).show();
    }
}
