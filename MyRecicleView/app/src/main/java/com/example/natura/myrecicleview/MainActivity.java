package com.example.natura.myrecicleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    RecyclerView recyclerView;
    MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MyCustomAdapter(this, getDataSources());
        recyclerView = (RecyclerView) findViewById(R.id.drawerlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    public List<dataSource> getDataSources() {
        List<dataSource> dataSources = new ArrayList<>();
        int icons[]={R.drawable.bug0, R.drawable.bug1, R.drawable.bug2, R.drawable.bug3, R.drawable.bug4, R.drawable.bug5, R.drawable.bug6, R.drawable.bug7, R.drawable.bug8, R.drawable.bug9};
        String points[] = {"Bug 0", "Bug 1", "Bug 2", "Bug 3", "Bug 4", "Bug 5", "Bug 6", "Bug 7", "Bug 8", "Bug 9"};
        String dates[] = {"05/12/2015", "07/12/2015", "10/12/2015", "10/12/2015", "11/12/2015", "15/12/2015", "20/12/2015", "21/12/2015", "21/12/2015", "25/12/2015"};
        String platform[] = {"Google Chrome", "Mozila Firefox", "Safari", "Opera", "Google Chrome", "Google Chrome", "Mozilla Firefox", "IExplorer", "Safari", "Google Chrome"};
        String subject[] = {"Carlos", "Raquel", "Mario", "Mario", "Raquel", "Carlos", "Carlos", "Raquel", "Mario", "Carlos"};

        for(int i=0; i<icons.length && i<points.length; i++) {
            dataSource dataSource = new dataSource();
            dataSource.picId = icons[i];
            dataSource.pointName = points[i];
            dataSource.dates = dates[i];
            dataSource.platform = platform[i];
            dataSource.subject = subject[i];
            dataSources.add(dataSource);
        }
        return dataSources;
    }
 }
