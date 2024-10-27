package com.example.mycitizeninfoapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mycitizeninfoapp.model.Person;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "citizen_ìno.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PERSON = "person";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_PERSON + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "age INTEGER," +
                "address TEXT," +
                "phone_number TEXT" +
                ")";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        onCreate(db);

    }
    public void addPerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", person.getName());
        values.put("age", person.getAge());
        values.put("address", person.getAddress());
        values.put("phone_number", person.getPhoneNumber());
        db.insert(TABLE_PERSON, null, values);
        db.close();
    }
}
