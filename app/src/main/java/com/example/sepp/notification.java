package com.example.sepp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class notification extends  AppCompatActivity{
    private static final int NOTIFICATION_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button btnSendNotification = findViewById(R.id.btn_send_noification);
        btnSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }
    private void sendNotification(){
        Notification notification = new Notification.Builder(this)
                .setContentTitle("Title push notification")
                .setContentText("Message push notification")
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager !=null) {
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }
}
