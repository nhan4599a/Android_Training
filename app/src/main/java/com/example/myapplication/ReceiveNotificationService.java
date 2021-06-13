package com.example.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.logging.Logger;

public class ReceiveNotificationService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String s) {
        Logger.getLogger("DEBUG").warning("New token received: " + s);
        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Logger.getLogger("DEBUG").warning("Notification received");
        showNotification(remoteMessage);
    }

    private void showNotification(RemoteMessage message) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("VLU Notify App", "NotificationChannel", importance);
            channel.setDescription("Channel to notify student have new notification");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(
                        this, "VLU Notify App");
        builder.setContentTitle(message.getNotification().getTitle())
                .setContentText(message.getNotification().getBody())
                .setWhen(System.currentTimeMillis())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSmallIcon(R.mipmap.ic_launcher_round);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager
                .notify(0, builder.build());
    }
}
