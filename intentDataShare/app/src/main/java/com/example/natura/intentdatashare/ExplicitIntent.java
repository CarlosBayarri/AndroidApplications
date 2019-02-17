package com.example.natura.intentdatashare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExplicitIntent extends Activity {

    EditText et_data;

    public final static String IDRequest = "ActivityExplicit";
    public final static int RequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent request = getIntent();
        String request_data = request.getStringExtra(ActivityExplicitA.IDRequest);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "bayarricebrecos@hotmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hi, here is my result! ");
        intent.putExtra(Intent.EXTRA_TEXT, "" + request_data);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
