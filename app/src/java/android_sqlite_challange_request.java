package com.example.crazybeam.pkmoney_v7;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;

/**
 * Created by crazybeam on 8/13/2017.
 */

  public class android_sqlite_challange_request extends SQLiteOpenHelper
{

    public  static final  String DATABASE_NAME = "Pending_Challange_Request.db";

    public  static final  String TABLE_NAME = "Challange_Request_Table";

    // Now define column name.

    public  static final  String COL_1 = "subject_id";
    public  static final  String COL_2 = "challanger_name";

    public  static final String COL_3 = "challange_received_time";
    public  static final  String COL_4 = "challange_received_date";
    public  static final  String COL_5 = "time_gap";

    public android_sqlite_challange_request(Context context)
    {

        // whenever this constructor will call it will create database.

        super(context,DATABASE_NAME,null,1);
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

        sqLiteDatabase.execSQL("create table"+TABLE_NAME+" (subject_id TEXT PRIMARY KEY,challanger_name TEXT, challange_received_time TEXT, challange_received_date TEXT,time_gap INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
