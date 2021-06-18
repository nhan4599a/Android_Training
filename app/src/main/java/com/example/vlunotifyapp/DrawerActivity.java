package com.example.vlunotifyapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Logger;

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.getLogger("DEBUG").warning("Activity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
    }
}