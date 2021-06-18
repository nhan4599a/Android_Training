package com.example.vlunotifyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayAdapter<ListNotify> notifyArrayAdapter;
    ArrayList<ListNotify> notifyArrayList;
    ListView listView;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView tvUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView=findViewById(R.id.ListViewItem);
        notifyArrayList=getMock();
        notifyArrayAdapter=new ListNotifyAdapter(this,notifyArrayList);
        listView.setAdapter(notifyArrayAdapter);

        navigationView = findViewById(R.id.NavigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);

        tvUsername = findViewById(R.id.UserMailAddress);
        tvUsername.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}