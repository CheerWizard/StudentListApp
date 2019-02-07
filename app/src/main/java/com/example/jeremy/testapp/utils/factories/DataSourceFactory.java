package com.example.jeremy.testapp.utils.factories;

import android.content.Context;

import com.example.jeremy.testapp.constant.CourseType;
import com.example.jeremy.testapp.business_logic.datasources.StudentDataSource;
import com.example.jeremy.testapp.models.Student;

public class DataSourceFactory {

    private static StudentDataSource studentDataSource;

    public static StudentDataSource getStudentDataSource(Context context) {
        studentDataSource = new StudentDataSource(context);
        studentDataSource.open();
        initStudents();
        return studentDataSource;
    }

    private static void initStudents() {
        studentDataSource.add(new Student("John" , "Boland" , 19 , CourseType.JAVA));
        studentDataSource.add(new Student("Jessy" , "Stanford" , 22 , CourseType.PYTHON));
        studentDataSource.add(new Student("Rose" , "Hurry" , 18 , CourseType.KOTLIN));
        studentDataSource.add(new Student("William" , "Stone" , 25 , CourseType.JAVASCRIPT));
        studentDataSource.add(new Student("Michael" , "Greek" , 32 , CourseType.C));
    }
}
