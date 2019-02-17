package com.example.natura.intentdatashare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class ActivityB extends Activity {
    TextView tv_info;
    RadioButton rb_chocolate, rb_pizza;

    public final static String IDResult = "ActivityB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityb);

        tv_info = findViewById(R.id.tv_info);
        rb_chocolate = findViewById(R.id.rb_chocolate);
        rb_pizza = findViewById(R.id.rb_pizza);

        Intent request = getIntent();
        String request_data = request.getStringExtra(ActivityA.IDRequest);
        tv_info.setText(request_data);
    }
    public void gotoActivityA(View view) {
        String selection = "Nothing selected";
        Intent result_intent = new Intent(this, ActivityA.class);

        if (rb_chocolate.isChecked()){
            selection = "chocolate";
        }
        if (rb_pizza.isChecked()){
            selection = "pizza";
        }
        result_intent.putExtra(IDResult, selection);
        setResult(RESULT_OK, result_intent);
        finish();
    }
}
