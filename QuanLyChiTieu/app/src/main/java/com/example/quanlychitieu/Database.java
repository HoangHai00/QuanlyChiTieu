package com.example.quanlychitieu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // truy vấn không trả kết quả : CREATE, INSERT, UPDATA, DELETE,...
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        // getWritableDatabase() ghi và đọc dữ liệu
        database.execSQL(sql);
    }
    // truy vấn có trả kết quả: SELECT || cursor là con trỏ để đọc dữ liệu
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        //getReadableDatabase đọc dữ liệu và không ghi
        return database.rawQuery(sql,null);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}