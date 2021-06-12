package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView notificationList = view.findViewById(R.id.notificationList);
        Notification.Builder builder = new Notification.Builder();
        builder.setTitle("Nghỉ học");
        builder.setContent("Sinh viên được nghỉ lễ 30/5 1/5");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 5, 10, 19, 51, 32);
        builder.setReceivedDate(calendar);
        builder.setIsInteracted(false);
        ArrayList<Notification> notifications = new ArrayList<>();
        notifications.add(builder.build());
        notificationList.setAdapter(new NotificationAdapter(notifications));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        notificationList.setLayoutManager(layoutManager);
    }
}
