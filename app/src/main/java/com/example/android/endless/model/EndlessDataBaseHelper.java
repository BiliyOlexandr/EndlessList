package com.example.android.endless.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EndlessDataBaseHelper extends SQLiteOpenHelper {

  public static final String FIRST_NAME = "FIRST_NAME";
  public static final String LAST_NAME = "LAST_NAME";
  private static final String TABLE_NAME = "USERS";
  private static final String DB_NAME = "database";
  private static final int DB_VERSION = 1;

  public EndlessDataBaseHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE "
        + TABLE_NAME
        + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
        + FIRST_NAME
        + ", "
        + LAST_NAME
        + ");");
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  public Cursor getCursor() {
    SQLiteDatabase db = getWritableDatabase();
    return db.query(EndlessDataBaseHelper.TABLE_NAME, null, null, null, null, null, null);
  }

  public boolean isUserTableEmpty() {
    SQLiteDatabase db = getWritableDatabase();
    Cursor cursor = db.query(EndlessDataBaseHelper.TABLE_NAME, null, null, null, null, null, null);
    int itemsCount = cursor.getCount();
    cursor.close();
    return itemsCount <= 0;
  }

  public void insertUser(String firstName, String lastName) {
    SQLiteDatabase database = getWritableDatabase();
    ContentValues userValues = new ContentValues();
    userValues.put(EndlessDataBaseHelper.FIRST_NAME, firstName);
    userValues.put(EndlessDataBaseHelper.LAST_NAME, lastName);
    database.insert(EndlessDataBaseHelper.TABLE_NAME, null, userValues);
  }
}
