package com.ddona.day18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ddona.day18.database.StudentManager;
import com.ddona.day18.model.Student;

public class WelcomeActivity extends AppCompatActivity {
    private StudentManager studentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        studentManager = new StudentManager(this);
        studentManager.addStudent(new Student(1, "Doan", 10));
        studentManager.addStudent2(new Student(2, "Mai", 1));
    }
}