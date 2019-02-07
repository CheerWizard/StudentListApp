package com.example.jeremy.testapp.presenters;

import android.os.Handler;

import com.example.jeremy.testapp.IContract;
import com.example.jeremy.testapp.business_logic.repositories.IStudentRepository;
import com.example.jeremy.testapp.business_logic.repositories.StudentRepository;
import com.example.jeremy.testapp.ui.activities.StudentApplication;
import com.example.jeremy.testapp.utils.factories.DataSourceFactory;
import com.example.jeremy.testapp.models.Student;

import java.util.List;

public class StudentPresenter implements IContract.IPresenter {

    private IContract.IView view;
    private IStudentRepository studentRepository;

    public StudentPresenter(IContract.IView view , Handler handler) {
        this.view = view;
        studentRepository = new StudentRepository(DataSourceFactory.getStudentDataSource(StudentApplication.getInstance()) , handler);
    }

    public List<Student> onCreate() {
        return studentRepository.getAll();
    }

    public List<Student> onTouchDeleteBtn(int position) {
        Student student = new Student();
        student.setId(position);
        studentRepository.delete(student);
        return studentRepository.getAll();
    }

    @Override
    public void onClear() {
        studentRepository.close();
    }
}
