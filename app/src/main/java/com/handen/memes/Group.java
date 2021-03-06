package com.handen.memes;

import android.content.ContentValues;

import com.handen.memes.database.Schema;

/**
 * Created by user2 on 29.05.2018.
 */

public class Group {
    private int id;
    private String name;
    private boolean isSelected;

    //Эти поля используются только в PostDownloader
    private long lastPostDownloadedMillis;
    private int postDownloadedCount;

    public Group(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public Group(int id, String name, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.isSelected = isSelected;
    }

    public Group(int id) {
        this.id = id;
    }

    public Group(int id, boolean isSelected) {
        this.id = id;
        this.isSelected = isSelected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public long getLastPostDownloadedMillis() {
        return lastPostDownloadedMillis;
    }

    public void setLastPostDownloadedMillis(long lastPostDownloadedMillis) {
        this.lastPostDownloadedMillis = lastPostDownloadedMillis;
    }

    public int getPostDownloadedCount() {
        return postDownloadedCount;
    }

    public void setPostDownloadedCount(int postDownloadedCount) {
        this.postDownloadedCount = postDownloadedCount;
    }

    public static ContentValues toContentValues(Group group) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Schema.GroupsTable.ID, group.getId());
        contentValues.put(Schema.GroupsTable.NAME, group.getName());
        contentValues.put(Schema.GroupsTable.SELECTED, group.getIsSelected() ? 1 : 0);

        return  contentValues;
    }
}
