package com.ddona.day18.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDbOpenHelper extends SQLiteOpenHelper {
    private static final String STUDENT_DB_NAME = "student.db";
    private static final int DB_VERSION = 1;
    private static final String TB_STUDENT = "tb_student";
    private static final String COL_ID = "_id";
    private static final String COL_NAME = "_name";
    private static final String COL_SCORE = "_score";
    private static final String CREATE_STUDENT_TABLE =
            "CREATE TABLE " + TB_STUDENT + "("
                    + COL_ID + " integer primary key autoincrement,"
                    + COL_NAME + " text,"
                    + COL_SCORE + " int)";


    public StudentDbOpenHelper(@Nullable Context context) {
        super(context, STUDENT_DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

    }
}
