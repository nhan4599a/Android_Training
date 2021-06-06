package com.example.vlunotifyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListNotifyAdapter extends ArrayAdapter<ListNotify> {
    private Context context;
    private List<ListNotify> list;
    public ListNotifyAdapter(@NonNull Context context, @NonNull List<ListNotify> objects) {
        super(context, 0, objects);
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView =layoutInflater.inflate(R.layout.list_notify,parent,false);

        ImageView imageView1= convertView.findViewById(R.id.logoUser);
        TextView titleView = convertView.findViewById(R.id.title1);
        TextView nameView = convertView.findViewById(R.id.name1);
        TextView contentView = convertView.findViewById(R.id.content);
        TextView dateView = convertView.findViewById(R.id.date1);

        ListNotify notify = getItem(position);
        imageView1.setImageResource(notify.getmImageResource());
        titleView.setText(notify.getmTitle());
        nameView.setText(notify.getmName());
        contentView.setText(notify.getmContent());
        dateView.setText(notify.getmDate());

        return convertView;
    }
}
