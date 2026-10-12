package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StudentDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "students";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT NOT NULL, "
                + COL_EMAIL + " TEXT NOT NULL"
                + ")";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert student data
    public boolean insertData(String name, String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);

        long result = -1;

        try {
            result = db.insert(TABLE_NAME, null, values);
        } finally {
            db.close();
        }

        return result != -1;
    }

    // Retrieve all student records
    public String getAllData() {

        SQLiteDatabase db = this.getReadableDatabase();

        StringBuilder result = new StringBuilder();

        try (Cursor cursor = db.rawQuery(
                "SELECT " + COL_ID + ", "
                        + COL_NAME + ", "
                        + COL_EMAIL
                        + " FROM " + TABLE_NAME
                        + " ORDER BY " + COL_ID + " ASC",
                null)) {

            if (cursor.moveToFirst()) {

                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String email = cursor.getString(2);

                    result.append("ID: ").append(id)
                            .append("\nName: ").append(name)
                            .append("\nEmail: ").append(email)
                            .append("\n\n");

                } while (cursor.moveToNext());

            } else {
                result.append("No records found.");
            }

        } finally {
            db.close();
        }

        return result.toString();
    }
}