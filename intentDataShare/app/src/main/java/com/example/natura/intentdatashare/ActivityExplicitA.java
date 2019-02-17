package com.example.natura.intentdatashare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityExplicitA extends Activity {
    EditText et_dataA1, et_dataA2, et_data;

    public final static String IDRequestA1 = "ActivityExplicitA1";
    public final static String IDRequestA2 = "ActivityExplicitA2";
    public final static String IDRequestB = "ActivityExplicitB";
    public final static String IDRequest = "ActivityExplicit";
    public final static int RequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_a);

        et_dataA1 = findViewById(R.id.tv_dataA1);
        et_dataA2 = findViewById(R.id.tv_dataA2);
        et_data = findViewById(R.id.tv_data);
    }
    public void gotoActivityExplicitB(View view) {
        String dataA1 = et_dataA1.getText().toString();
        String dataA2 = et_dataA2.getText().toString();
        Intent intent = new Intent(this, ActivityExplicitB.class);
        intent.putExtra(IDRequestA1, dataA1);
        intent.putExtra(IDRequestA2, dataA2);
        startActivityForResult(intent, RequestCode);
    }
    public void gotoActivityExplicitIntentDataSharing(View view) {
        String data = et_data.getText().toString();
        Intent intent = new Intent(this, ExplicitIntent.class);
        intent.putExtra(IDRequest, data);
        startActivityForResult(intent, RequestCode);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        et_data = findViewById(R.id.tv_data);

        if (requestCode == RequestCode && resultCode == RESULT_OK) {
            String processed_data = data.getStringExtra(ActivityExplicitB.IDRequest);
            et_data.setText(processed_data);
        }
    }
}
