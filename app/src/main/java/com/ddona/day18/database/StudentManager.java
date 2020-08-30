package com.ddona.day18.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ddona.day18.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private SQLiteDatabase mDb;
    private StudentDbOpenHelper mHelper;

    public StudentManager(Context context) {
        mHelper = new StudentDbOpenHelper(context);
        mDb = mHelper.getWritableDatabase();
    }

    public void addStudent(Student student) {
        ContentValues values = new ContentValues();
        values.put(StudentDbOpenHelper.COL_NAME, student.getName());
        values.put(StudentDbOpenHelper.COL_SCORE, student.getScore());
        mDb.insert(StudentDbOpenHelper.TB_STUDENT, null, values);
    }

    public void addStudent2(Student student) {
        String sql = "INSERT INTO " + StudentDbOpenHelper.TB_STUDENT + "(" +
                StudentDbOpenHelper.COL_NAME + "," +
                StudentDbOpenHelper.COL_SCORE + ") VALUES('" +
                student.getName() + "'," +
                student.getScore() + ");";
        mDb.execSQL(sql);

    }

    public List<Student> getAllStudents() {
        List<Student> result = new ArrayList<>();
        String sql = "SELECT * FROM " + StudentDbOpenHelper.TB_STUDENT;
        Cursor cursor = mDb.rawQuery(sql, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex(StudentDbOpenHelper.COL_ID);
                int nameIndex = cursor.getColumnIndex(StudentDbOpenHelper.COL_NAME);
                int scoreIndex = cursor.getColumnIndex(StudentDbOpenHelper.COL_SCORE);
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                int score = cursor.getInt(scoreIndex);
                Student student = new Student(id, name, score);
                result.add(student);
            }
        }
        return result;
    }

    public Student getAStudent(int id) {
//        Cursor cursor = mDb.query(StudentDbOpenHelper.TB_STUDENT,
//                new String[]{"_name", "_score"})
//        Cursor cursor = mDb.query(StudentDbOpenHelper.TB_STUDENT,
//                null, "_id=" + id + " AND name=doan" )
        Cursor cursor = mDb.query(StudentDbOpenHelper.TB_STUDENT,
                null, "_id=?", new String[]{String.valueOf(id)},
                null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(StudentDbOpenHelper.COL_ID);
                int nameIndex = cursor.getColumnIndex(StudentDbOpenHelper.COL_NAME);
                int scoreIndex = cursor.getColumnIndex(StudentDbOpenHelper.COL_SCORE);
                int sId = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                int score = cursor.getInt(scoreIndex);
                Student student = new Student(sId, name, score);
                return student;
            }
        }
        return null;
//        mDb.query(StudentDbOpenHelper.TB_STUDENT, null,null,null,null,null,null);
    }
}
