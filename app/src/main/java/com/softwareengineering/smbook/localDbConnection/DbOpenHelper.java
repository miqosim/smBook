package com.softwareengineering.smbook.localDbConnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.softwareengineering.smbook.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikayel on 12/4/2017.
 */

public class DbOpenHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "usersManager";

    // User table information

    private static final String KEY_ID = "id";
    public static final String USER_TABLE_NAME = "user_data";
    public static final String USER_PASSWORD_COLUMN_NAME = "password";
    public static final String USER_LOGIN_COLUMN_NAME = "login";

    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + USER_TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + USER_LOGIN_COLUMN_NAME + " TEXT,"
                + USER_PASSWORD_COLUMN_NAME + " TEXT" + ")";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public void addUserCredentials (User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_LOGIN_COLUMN_NAME, user.getUsername());
        values.put(USER_PASSWORD_COLUMN_NAME, user.getPassword());

        // Inserting Row
        db.insert(USER_TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(USER_TABLE_NAME, new String[] { KEY_ID,
                        USER_LOGIN_COLUMN_NAME, USER_PASSWORD_COLUMN_NAME }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return user
        return user;
    }

    // Getting All users
    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + USER_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setUserId(Integer.parseInt(cursor.getString(0)));
                user.setUsername(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                // Adding user to list
                usersList.add(user);
            } while (cursor.moveToNext());
        }

        // return user list
        return usersList;
    }

    // Updating single user
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_LOGIN_COLUMN_NAME, user.getUsername());
        values.put(USER_PASSWORD_COLUMN_NAME, user.getPassword());

        // updating row
        return db.update(USER_TABLE_NAME, values, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getUserId()) });
    }

    // Deleting single user
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(USER_TABLE_NAME, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getUserId()) });
        db.close();
    }


    // Getting users Count
    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + USER_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }


}
