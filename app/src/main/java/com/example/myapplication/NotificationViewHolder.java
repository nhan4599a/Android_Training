package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvTitle, tvContent, tvTime;
    private final ImageView imgHeart;

    public NotificationViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvContent = itemView.findViewById(R.id.tvContent);
        tvTime = itemView.findViewById(R.id.tvTime);
        imgHeart = itemView.findViewById(R.id.imgHeart);
    }

    public void setNotification(Notification notification) {
        tvTitle.setText(notification.getTitle());
        tvContent.setText(notification.getContent());
        long differenceTime = Calendar.getInstance().getTime().getTime()
                - notification.getReceivedDate().getTime().getTime();
        tvTime.setText(String.valueOf(differenceTime));
        int resId = notification.isInteracted() ? R.drawable.outline_favorite_black_18 :
                R.drawable.outline_favorite_border_black_18;
        imgHeart.setImageResource(resId);
    }
}
