package com.example.natura.intentdatashare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;

import java.net.URI;
import java.util.Calendar;

public class ImplicitIntentDataSharing extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_data_sharing);
    }

    public void phoneCall (View view){
        Uri number = Uri.parse("tel: 374173964916369");
        Intent telephone_intent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(telephone_intent);
    }
    public void viewPosition(View view) {
        Uri location = Uri.parse("geo:49.013034,8.438760?z=16");
        Intent locationIntent = new Intent(Intent.ACTION_VIEW, location);
    }
    public void searchInWeb (View view) {
        Uri address = Uri.parse("http://www.android.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(webIntent);
    }
    public void calendarEvent(View view) {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar begTime = Calendar.getInstance();
        begTime.set(2018, 12, 14, 10, 50);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2018, 12, 14, 11, 20);
        Uri location = Uri.parse("geo:49.013034,8.438760?z=16");
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begTime);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Mobile nav");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "HopfStrasse 3");
        startActivity(calendarIntent);
    }
}
