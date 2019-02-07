package com.example.jeremy.testapp.ui.activities;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jeremy.testapp.IContract;
import com.example.jeremy.testapp.R;
import com.example.jeremy.testapp.adapters.StudentListViewAdapter;
import com.example.jeremy.testapp.adapters.StudentRecyclerViewAdapter;
import com.example.jeremy.testapp.constant.ProcessStates;
import com.example.jeremy.testapp.presenters.StudentPresenter;

public class StudentListActivity extends AppCompatActivity implements IContract.IView , View.OnClickListener , Handler.Callback {
    //adapters
    private StudentListViewAdapter studentListViewAdapter;
    private StudentRecyclerViewAdapter studentRecyclerViewAdapter;
    //presenters
    private StudentPresenter studentPresenter;
    //views
    private RecyclerView studentRecyclerView;
    private ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initVars();
        initListeners();
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case ProcessStates.STATUS_STUDENT_REMOVED:
                Toast.makeText(this, R.string.student_removed, Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT < 24) {
            studentListViewAdapter.addListener(new StudentListViewAdapter.StudentListEventListener() {
                @Override
                public void onDeleteBtn(int position) {
                    studentListViewAdapter.onUpdateList(studentPresenter.onTouchDeleteBtn(position));
                }
            });
        }
        else{
            studentRecyclerViewAdapter.addListener(new StudentRecyclerViewAdapter.StudentListEventListener() {
                @Override
                public void onDeleteBtn(int position) {
                    studentRecyclerViewAdapter.onUpdateList(studentPresenter.onTouchDeleteBtn(position));
                }
            });
        }
    }

    private void initVars() {
        studentPresenter = new StudentPresenter(this , new Handler(this));
        if (Build.VERSION.SDK_INT < 24) {
            studentListViewAdapter = new StudentListViewAdapter(this , studentPresenter.onCreate());
            studentListView.setAdapter(studentListViewAdapter);
        }
        else {
            studentRecyclerViewAdapter = new StudentRecyclerViewAdapter(this , studentPresenter.onCreate());
            studentRecyclerView.setAdapter(studentRecyclerViewAdapter);
        }
    }

    private void initViews() {
        if (Build.VERSION.SDK_INT < 24) studentListView = findViewById(R.id.student_list_view);
        else studentRecyclerView = findViewById(R.id.student_recycler_view);
    }

    private void initListeners() {
        //empty method
    }

    @Override
    protected void onStop() {
        super.onStop();
        studentPresenter.onClear();
    }

    @Override
    public void animate() {
        //recently empty method
    }
}
