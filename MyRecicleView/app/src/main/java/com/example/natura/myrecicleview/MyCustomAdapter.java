package com.example.natura.myrecicleview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomViewHolder> {
    Context context;
    List<dataSource>dataList;
    LayoutInflater inflater;

    public MyCustomAdapter(Context context, List<dataSource>data) {
        this.context = context;
        this.dataList = data;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public MyCustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.activity_customrows, viewGroup, false);
        MyCustomViewHolder holder = new MyCustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomViewHolder holder, int position) {
        dataSource dataItem = dataList.get(position);
        holder.img.setImageResource(dataItem.picId);
        holder.point.setText(dataItem.pointName);
        holder.date.setText(dataItem.dates);
        holder.platform.setText(dataItem.platform);
        holder.subject.setText(dataItem.subject);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyCustomViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView point;
        TextView date;
        TextView platform;
        TextView subject;
        public MyCustomViewHolder(@NonNull final View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgView);
            point = itemView.findViewById(R.id.pointName);
            date = itemView.findViewById(R.id.dates);
            platform = itemView.findViewById(R.id.platform);
            subject = itemView.findViewById(R.id.subject);
            itemView.setTag(this);
            // Handle item click and set the selection
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int icons[]={R.drawable.bug0, R.drawable.bug1, R.drawable.bug2, R.drawable.bug3, R.drawable.bug4, R.drawable.bug5, R.drawable.bug6, R.drawable.bug7, R.drawable.bug8, R.drawable.bug9};
                    String points[] = {"Bug 0", "Bug 1", "Bug 2", "Bug 3", "Bug 4", "Bug 5", "Bug 6", "Bug 7", "Bug 8", "Bug 9"};
                    dataSource dataSource = new dataSource();
                    /** int cont = getAdapterPosition(); */
                    int cont = 0;
                    for (int i = 0; i < points.length; i++) {
                        if (points[i] == point.getText()) {
                            cont = i;
                        }
                    }
                    Log.d("textRecicled","" + cont);
                    dataSource.picId = icons[cont];
                    dataSource.pointName = (String) point.getText();
                    dataSource.dates =(String) date.getText();
                    dataSource.platform = (String) platform.getText();
                    dataSource.subject = (String) subject.getText();
                    dataList.add(dataSource);
                    Log.d("textRecicled","" + point.getText());
                    notifyDataSetChanged();
                }
            });
        }


    }

}
