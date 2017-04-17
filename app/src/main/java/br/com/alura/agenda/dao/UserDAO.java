package br.com.alura.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.User;

/**
 * Created by lucas on 16/04/2017.
 */

public class UserDAO extends SQLiteOpenHelper{

    public UserDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String QUERY_CREATE_DATABASE = "CREATE TABLE Users (id INTEGER, name TEXT NOT NULL, address TEXT, phone TEXT, site TEXT, rating REAL);";
        db.execSQL(QUERY_CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String QUERY_DROP_DATABASE = "DROP TABLE IF EXISTS Users";
        db.execSQL(QUERY_DROP_DATABASE);
        onCreate(db);
    }

    public void insert(User user) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put("name", user.getName());
        data.put("address", user.getAddress());
        data.put("phone", user.getPhone());
        data.put("site", user.getSite());
        data.put("rating", user.getRating());

        db.insert("Users", null, data);
    }

    public List<User> findUsers(){
        String selectQuery = "SELECT * FROM Users";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        List<User> userList = new ArrayList<>();
        while(cursor.moveToNext()){
            User user = new User (
                    cursor.getLong(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("address")),
                    cursor.getString(cursor.getColumnIndex("phone")),
                    cursor.getString(cursor.getColumnIndex("site")),
                    cursor.getDouble(cursor.getColumnIndex("rating"))
            );
            userList.add(user);
        }

        cursor.close();

        return userList;
    }


}
