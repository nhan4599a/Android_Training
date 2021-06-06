package com.example.vlunotifyapp;

public class ListNotify {
    private int mImageResource;
    private String mTitle;
    private String mName;
    private String mContent;
    private String mDate;

    public ListNotify(int imageResource, String title, String name, String content, String date) {
        mImageResource = imageResource;
        mTitle = title;
        mName = name;
        mContent = content;
        mDate = date;

    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
