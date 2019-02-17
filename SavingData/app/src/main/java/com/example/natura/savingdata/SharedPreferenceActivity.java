package com.example.natura.savingdata;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferenceActivity extends Activity {

    SharedPreferences sp;
    EditText et_subject, et_message;
    private final String SUBJECT = "subject";
    private final String MESSAGE = "message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        et_subject = findViewById(R.id.et_sub);
        et_message = findViewById(R.id.et_mess);

        sp = getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        String sub = sp.getString(SUBJECT, "No subject found");
        String mess = sp.getString(MESSAGE, "No message found");

        et_subject.setText(sub);
        et_message.setText(mess);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String sub = et_subject.getText().toString();
        String mess = et_message.getText().toString();

        SharedPreferences.Editor editor = sp.edit();
        editor.putString(SUBJECT, sub);
        editor.putString(MESSAGE, mess);
        editor.commit();
    }
}
