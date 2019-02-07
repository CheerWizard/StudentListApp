package com.example.jeremy.testapp.constant;

import android.support.annotation.NonNull;

public enum CourseType {
    C,
    JAVA,
    KOTLIN,
    PYTHON,
    JAVASCRIPT,
    SWIFT,
    SCALA;

    public static CourseType toCourseType(String courseString) {
        CourseType courseType = null;
        switch (courseString) {
            case "C":
                courseType = C;
                break;
            case "Java":
                courseType = JAVA;
                break;
            case "JavaScript":
                courseType = JAVASCRIPT;
                break;
            case "Python":
                courseType = PYTHON;
                break;
            case "Swift":
                courseType = SWIFT;
                break;
            case "Kotlin":
                courseType = KOTLIN;
                break;
            case "Scala":
                courseType = SCALA;
                break;
        }
        return courseType;
    }

    @NonNull
    @Override
    public String toString() {
        String course = null;
        switch (this) {
            case C:
                course = "C";
                break;
            case JAVA:
                course = "Java";
                break;
            case SCALA:
                course = "Scala";
                break;
            case KOTLIN:
                course = "Kotlin";
                break;
            case SWIFT:
                course = "Swift";
                break;
            case PYTHON:
                course = "Python";
                break;
            case JAVASCRIPT:
                course = "Javascript";
                break;
                default: course = "empty";
        }
        return course;
    }
}
