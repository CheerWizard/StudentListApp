package com.example.jeremy.testapp;

public interface IContract {

    interface IView {
        void animate();
    }

    interface IPresenter {
        //involves all presenters
        void onClear();
    }
}