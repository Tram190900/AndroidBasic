package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accountsManager";
    private static final String TABLE_CONTACTS = "accounts";
    private static final String KEY_Email = "Email";
    private static final String KEY_Name = "Name";
    private static final String KEY_Password = "Password";
    private static final String KEY_Smile = "Smile";
    private static final String KEY_Normal = "Normal";
    private static final String KEY_Sad = "Sad";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_Email +" TEXT PRIMARY KEY,"+ KEY_Name + " TEXT,"+ KEY_Password + " TEXT," + KEY_Smile + " INT,"+ KEY_Normal + " INT,"+ KEY_Sad + " INT"+")";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
    void addAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Normal, account.getNormal());
        values.put(KEY_Sad, account.getSad());
        values.put(KEY_Name, account.getName());
        values.put(KEY_Email, account.geteMail());
        values.put(KEY_Smile, account.getSmile());
        values.put(KEY_Password, account.getPassword());



        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    Account getAccount(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_Email, KEY_Name, KEY_Password,
                        KEY_Smile, KEY_Normal, KEY_Sad}, KEY_Email + "=?",
                new String[] { String.valueOf(email) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Account account = new Account(cursor.getString(0), cursor.getString(1),
                cursor.getString(2), cursor.getInt(3), cursor.getInt(4),cursor.getInt(5));
        // return contact
        return account;
    }

    public List<Account> getAllAccount() {
        List<Account> accountList = new ArrayList<Account>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Account account = new Account();
                account.seteMail(cursor.getString(0));
                account.setName(cursor.getString(1));
                account.setPassword(cursor.getString(2));
                account.setSmile(cursor.getInt(3));
                account.setNormal(cursor.getInt(4));
                account.setSad(cursor.getInt(5));
                // Adding contact to list
                accountList.add(account);
            } while (cursor.moveToNext());
        }
        return accountList;
    }
    public int updateSreenAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Smile, account.getSmile());
        values.put(KEY_Normal, account.getNormal());
        values.put(KEY_Sad, account.getSad());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_Email + " = ?",
                new String[] { String.valueOf(account.geteMail()) });
    }
//    public void deleteName(Name name) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACTS, KEY_Name + " = ?",
//                new String[] { String.valueOf(name.getName()) });
//        db.close();
//    }
    public int getNamesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
