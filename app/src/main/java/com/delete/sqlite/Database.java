package com.delete.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Tri_Emp";
    private static final String TABLE = "Emp";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SALARY = "salary";
    private static final String KEY_A = "A";
    private static final String id = "_id";
    SQLiteDatabase dbRead = this.getReadableDatabase();

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public Database(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE + "("+id+" INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_ID + " numeric," + KEY_NAME + " varchar(20),"+KEY_A+" varchar(20),"+ KEY_SALARY + " numeric)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        SQLiteDatabase dbWrite = this.getWritableDatabase();
        dbWrite.execSQL("drop table  if exists " + TABLE);
        onCreate(dbWrite);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
    public boolean updateCartQuantity(int pid) {
        try {
           SQLiteDatabase db = this.getWritableDatabase();
            String updateCartQuantity = "update " + TABLE + " set " + id+ " = " + 2 + " where " + id + " = 79";
            db.execSQL(updateCartQuantity);
            db.close();
            return true;
        } catch (SQLException s) {
            s.printStackTrace();
            return false;
        }

    }
    void del(){
          SQLiteDatabase db = this.getWritableDatabase();
         String f="drop table "+TABLE;
         db.execSQL(f);
    }
    String getData() {
        String s = null;
        StringBuilder ss= new StringBuilder();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE, null);
        if (cursor.moveToFirst()) {
            do {
                s= cursor.getString(0)+" / " + cursor.getString(1)+" / "  + cursor.getString(2) +" / " +cursor.getString(3)+" / "+
                        cursor.getString(4)+"\n";

                ss.append(s);
                Log.e("Query",ss.toString());

            }
            while (cursor.moveToNext()) ;
            return ss.toString();

        }
        db.close();
        return "";

    }

   long getInsert(int id, String str, int num) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(KEY_NAME,str);
        values.put(KEY_A,str);
        values.put(KEY_SALARY,num);

       return db.insert(TABLE, null, values);
      //  db.close();

    }
    void update()
    {
     //  SQLiteDatabase db = this.getWritableDatabase();
      // String f="ALTER TABLE Emp 'A' TO 'X'";
      // db.execSQL(f);
    }
}
