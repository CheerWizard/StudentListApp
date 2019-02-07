package com.example.jeremy.testapp.ui.activities;

import android.app.Application;

public class StudentApplication extends Application {

    private static StudentApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized StudentApplication getInstance() {
        return instance;
    }
}
