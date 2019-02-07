package com.example.jeremy.testapp.business_logic.datasources;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jeremy.testapp.models.Student;
import com.example.jeremy.testapp.business_logic.CustomSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentDataSource implements IDataSource<Student> {

    private SQLiteDatabase database;
    private CustomSQLiteOpenHelper dbHelper;
    private String[] allColumns = {CustomSQLiteOpenHelper.TB_ID,
            CustomSQLiteOpenHelper.TB_NAME , CustomSQLiteOpenHelper.TB_SURNAME , CustomSQLiteOpenHelper.TB_AGE , CustomSQLiteOpenHelper.TB_COURSE_TYPE};

    public StudentDataSource(Context context) {
        dbHelper = new CustomSQLiteOpenHelper(context);
    }

    @Override
    public void open() {
       database = dbHelper.getWritableDatabase();
    }

    @Override
    public void close() {
        dbHelper.close();
        database = null;
    }

    @Override
    public void add(Student student) {
        ContentValues values = new ContentValues();
        values.put(CustomSQLiteOpenHelper.TB_NAME, student.getName());
        values.put(CustomSQLiteOpenHelper.TB_SURNAME, student.getSurname());
        values.put(CustomSQLiteOpenHelper.TB_AGE, student.getAge());
        values.put(CustomSQLiteOpenHelper.TB_COURSE_TYPE, student.getCourseType().toString());
        database.insert(CustomSQLiteOpenHelper.TABLE_STUDENTS, null,
                values);
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Cursor cursor = database.query(CustomSQLiteOpenHelper.TABLE_STUDENTS,
                allColumns, null, null, null, null, null);
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                students.add(cursorToStudent(cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return students;
    }

    @Override
    public void remove(int id) {
        database.delete(CustomSQLiteOpenHelper.TABLE_STUDENTS,
                CustomSQLiteOpenHelper.TB_ID + " = " + id , null);
    }

    @Override
    public void removeAll() {
        database.delete(CustomSQLiteOpenHelper.TABLE_STUDENTS, null , null);
    }

    private Student cursorToStudent(Cursor cursor) {
        Student student = new Student();
        student.setId(cursor.getInt(cursor.getColumnIndex(CustomSQLiteOpenHelper.TB_ID)));
        student.setName(cursor.getString(cursor.getColumnIndex(CustomSQLiteOpenHelper.TB_NAME)));
        student.setSurname(cursor.getString(cursor.getColumnIndex(CustomSQLiteOpenHelper.TB_SURNAME)));
        student.setAge(cursor.getInt(cursor.getColumnIndex(CustomSQLiteOpenHelper.TB_AGE)));
        student.setCourseType(cursor.getString(cursor.getColumnIndex(CustomSQLiteOpenHelper.TB_COURSE_TYPE)));
        return student;
    }
}
