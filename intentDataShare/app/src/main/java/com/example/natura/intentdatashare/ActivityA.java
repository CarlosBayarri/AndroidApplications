package com.example.natura.intentdatashare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityA extends Activity {
    EditText et_data;

    public final static String IDRequest = "ActivityA";
    public final static int RequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitya);

        et_data = findViewById(R.id.tv_data);
    }
    public void gotoActivityB(View view) {
        String data = et_data.getText().toString();
        Intent intent = new Intent(this, ActivityB.class);
        intent.putExtra(IDRequest, data);
        startActivityForResult(intent, RequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RequestCode && resultCode == RESULT_OK) {
            String processed_data = data.getStringExtra(ActivityB.IDResult);
            et_data.setText(processed_data);
        }
    }
}
