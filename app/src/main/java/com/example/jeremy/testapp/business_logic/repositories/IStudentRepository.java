package com.example.jeremy.testapp.business_logic.repositories;

import com.example.jeremy.testapp.models.Student;

import java.util.List;

public interface IStudentRepository {
    void delete(final Student student);
    List<Student> getAll();
    void close();
}
