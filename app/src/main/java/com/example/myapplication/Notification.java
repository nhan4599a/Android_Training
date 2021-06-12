package com.example.myapplication;

import java.util.Calendar;

import lombok.Getter;

@Getter
public class Notification {

    private String title, content;
    private Calendar receivedDate;
    private boolean isInteracted;

    private Notification() {}

    static class Builder {
        private Notification notification;

        public Builder() {
            notification = new Notification();
        }

        public Builder setTitle(String title) {
            notification.title = title;
            return this;
        }

        public Builder setContent(String content) {
            notification.content = content;
            return this;
        }

        public Builder setReceivedDate(Calendar receivedDate) {
            notification.receivedDate = receivedDate;
            return this;
        }

        public Builder setIsInteracted(boolean isInteracted) {
            notification.isInteracted = isInteracted;
            return this;
        }

        public Notification build() {
            return notification;
        }
    }
}
