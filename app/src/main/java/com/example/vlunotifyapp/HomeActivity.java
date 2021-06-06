package com.example.vlunotifyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayAdapter<ListNotify> notifyArrayAdapter;
    ArrayList<ListNotify> notifyArrayList;
    ListView listView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView=findViewById(R.id.ListViewItem);
        notifyArrayList=getMock();
        notifyArrayAdapter=new ListNotifyAdapter(this,notifyArrayList);
        listView.setAdapter(notifyArrayAdapter);

    }

    public ArrayList<ListNotify> getMock(){
        ArrayList<ListNotify> tmp=new ArrayList<>();
        tmp.add(new ListNotify(R.drawable.logouser, "ABC" ,"XY", "Thong bao nghi hoc", "Tuesday"));
        tmp.add(new ListNotify(R.drawable.logouser, "abc" ,"XY", "Thong bao nghi hoc", "Tuesday"));
        tmp.add(new ListNotify(R.drawable.logouser, "ac" ,"XY", "Thong bao nghi hoc", "Tuesday"));
        tmp.add(new ListNotify(R.drawable.logouser, "a" ,"XY", "Thong bao nghi hoc", "Tuesday"));
        tmp.add(new ListNotify(R.drawable.logouser, "b" ,"XY", "Thong bao nghi hoc", "Tuesday"));
        tmp.add(new ListNotify(R.drawable.logouser, "c" ,"XY", "Thong bao nghi hoc", "Tuesday"));
        tmp.add(new ListNotify(R.drawable.logouser, "XYZ" ,"XY", "Thong bao nghi hoc", "Tuesday"));
        return  tmp;
    }
}