package com.example.jeremy.testapp.models;

import com.example.jeremy.testapp.constant.CourseType;

public class Student {

    private String name;
    private String surname;
    private int age;
    private CourseType courseType;
    private int id;

    public Student(String name, String surname, int age, CourseType courseType) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.courseType = courseType;
    }

    public Student() {}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = CourseType.toCourseType(courseType);
    }
}
