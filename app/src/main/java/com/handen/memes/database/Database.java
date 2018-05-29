package com.handen.memes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.handen.memes.App;
import com.handen.memes.Group;

import java.util.ArrayList;

import static com.handen.memes.database.Schema.GroupsTable.NAME;
import static com.handen.memes.database.Schema.GroupsTable.SELECTED;
import static com.handen.memes.database.Schema.GroupsTable.TABLENAME;

/**
 * Created by user2 on 29.05.2018.
 */

public class Database {
    private static Database database;
    private SQLiteDatabase mDatabase;

    public static Database get() {
        if(database == null)
            database = new Database(App.getContext());
        return database;
    }

    private Database(Context context) {
        mDatabase = new DatabaseHelper(context.getApplicationContext()).getWritableDatabase();
    }

    public ArrayList<Group> getGroupsNames() {
        ArrayList<Group> ret = new ArrayList<>();
        String[] columns = new String[2];
        columns[0] = NAME;
        columns[1] = SELECTED;
        Cursor cursor = mDatabase.query(false,
                TABLENAME,
                columns,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i ++) {
            String name = cursor.getString(0);
            boolean isSelected = cursor.getInt(1) == 1;
            Group group = new Group(name, isSelected);
            ret.add(group);
            cursor.moveToNext();
        }
        cursor.close();
        return  ret;
    }

    public void addGroup(Group group) {
        ContentValues contentValues = Group.toContentValues(group);
        mDatabase.insert(TABLENAME, null, contentValues);
    }
}
