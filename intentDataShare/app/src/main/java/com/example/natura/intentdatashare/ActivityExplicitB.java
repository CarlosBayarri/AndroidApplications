package com.example.natura.intentdatashare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityExplicitB extends Activity {
    EditText et_dataB1, et_dataB2;

    public final static String IDRequest = "ActivityExplicitB";
    public final static int RequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_b);

        et_dataB1 = findViewById(R.id.tv_dataB1);
        et_dataB2 = findViewById(R.id.tv_dataB2);
        Intent request = getIntent();
        String request_data_a1 = request.getStringExtra(ActivityExplicitA.IDRequestA1);
        String request_data_a2 = request.getStringExtra(ActivityExplicitA.IDRequestA2);
        et_dataB1.setText(request_data_a1);
        et_dataB2.setText(request_data_a2);

    }
    public void gotoActivityExplicitA(View view) {
        String dataB1 = et_dataB1.getText().toString();
        String dataB2 = et_dataB2.getText().toString();
        String data = String.valueOf(Integer.parseInt(dataB1) + Integer.parseInt(dataB2));
        Intent intent = new Intent(this, ActivityExplicitA.class);
        intent.putExtra(IDRequest, data);
        setResult(RESULT_OK, intent);
        finish();
    }

}