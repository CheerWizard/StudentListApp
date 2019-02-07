package com.example.jeremy.testapp.business_logic.repositories;

import android.os.Handler;

import com.example.jeremy.testapp.constant.ProcessStates;
import com.example.jeremy.testapp.business_logic.datasources.StudentDataSource;
import com.example.jeremy.testapp.models.Student;

import java.util.List;

public class StudentRepository implements IStudentRepository {

    private Handler handler;
    private StudentDataSource studentDataSource;

    public StudentRepository(StudentDataSource studentDataSource , Handler handler) {
        this.studentDataSource = studentDataSource;
        this.handler = handler;
    }

    @Override
    public void delete(final Student student) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                studentDataSource.remove(student.getId());
                handler.sendEmptyMessage(ProcessStates.STATUS_STUDENT_REMOVED);
            }
        }).start();
    }

    @Override
    public List<Student> getAll() {
        return studentDataSource.getAll();
    }

    @Override
    public void close() {
        studentDataSource.close();
    }
}
