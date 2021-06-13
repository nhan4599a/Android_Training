package com.example.sepp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        ListView listView = (ListView)findViewById(R.id.listView);

        UserMail Quy = new UserMail("An", "dev");
        UserMail Nhan = new UserMail("Nhan","lead");

        UserMail[] users = new UserMail[]{Quy,Nhan};

        ArrayAdapter<UserMail>arrayAdapter = new ArrayAdapter<UserMail>(this, android.R.layout.simple_list_item_1 , users);

        listView.setAdapter(arrayAdapter);
    }
}
