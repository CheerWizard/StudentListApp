package com.example.jeremy.testapp.business_logic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class CustomSQLiteOpenHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "container.db";

    private final static int DB_VERSION = 1;

//    public final static String TAG = "CustomSQLiteOpenHelper";


//    public final static String AUTHORITY = "com.example.jeremy.android.db.container";
//    public final static String BASE_PATH = "source_database";

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //- - - - - - - TABLE NAMES - - - - - - - - - - - - - - - -
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public final static String TABLE_STUDENTS = "STUDENTS";

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //- - - - - - - TABLE URI - - - - - - - - - - - - - - - - -
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -

//    public final static Uri TABLE_STUDENTS_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_STUDENTS);
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //- - - - - - - TABLE IDS - - - - - - - - - - - - - - - - -
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -

//    public static final int TABLE_STUDENTS_ID = 1;

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //- - - - - - - TABLE FIELDS- - - - - - - - - - - - - - - -
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static final String TB_ID = "ID";

    //TABLE_STUDENTS
    public static final String TB_NAME = "NAME";
    public static final String TB_SURNAME = "SURNAME";
    public static final String TB_AGE = "AGE";
    public static final String TB_COURSE_TYPE = "COURSE_TYPE";

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //- - - - - - - CREATE TABLE- - - - - - - - - - - - - - - -
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private final static String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS + "\n" +
            "                 ( " + TB_ID + " integer primary key\n" +
            "                 , " + TB_NAME + " varchar not NULL\n" +
            "                 , " + TB_SURNAME + " varchar not NULL\n" +
            "                 , " + TB_AGE + " varchar not NULL\n" +
            "                 , " + TB_COURSE_TYPE + " varchar not NULL)";

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    //- - - - - - - SELECT TABLE- - - - - - - - - - - - - - - -
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

//    public CustomSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, DB_NAME, null, DB_VERSION);
//    }

    public CustomSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

}
