package com.example.natura.viewandviewgroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn1);
        tv = findViewById(R.id.tv_text);

        btn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Ey, que he cambiado");
            }

        });
    }

    public void doSomething (View view) {
        tv.setText("Ey, que ha cambiado");
    }
}
