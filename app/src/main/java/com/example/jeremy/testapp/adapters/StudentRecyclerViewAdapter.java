package com.example.jeremy.testapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeremy.testapp.R;
import com.example.jeremy.testapp.models.Student;

import java.util.List;

public class StudentRecyclerViewAdapter extends RecyclerView.Adapter<StudentRecyclerViewAdapter.StudentViewHolder> {

    public interface StudentListEventListener {
        void onDeleteBtn(int position);
    }

    private List<Student> list;
    private StudentListEventListener studentListEventListener;
    private LayoutInflater layoutInflater;

    public StudentRecyclerViewAdapter(Context context, List<Student> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    public void addListener(StudentListEventListener studentListEventListener) {
        this.studentListEventListener = studentListEventListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new StudentViewHolder(layoutInflater.inflate(R.layout.student_view_holder_layout , viewGroup));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        final int position = i;
        Student student = list.get(position);
        studentViewHolder.studentAgeTextView.setText(student.getAge());
        studentViewHolder.studentNameTextView.setText(student.getName());
        studentViewHolder.studentSurnamTextView.setText(student.getSurname());
        studentViewHolder.studentCourseTypeTextView.setText(student.getCourseType().toString());
        studentViewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentListEventListener != null) studentListEventListener.onDeleteBtn(position);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void onUpdateList(List<Student> newData) {
        list.clear();
        list.addAll(newData);
        notifyDataSetChanged();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        private Button deleteButton;
        private TextView studentNameTextView, studentAgeTextView, studentSurnamTextView, studentCourseTypeTextView;

        private StudentViewHolder(View view) {
            super(view);
            initViews(view);
        }

        private void initViews(View view) {
            //init text views
            studentAgeTextView = (TextView) view.findViewById(R.id.student_age);
            studentNameTextView = (TextView) view.findViewById(R.id.student_name);
            studentSurnamTextView = (TextView) view.findViewById(R.id.student_surname);
            studentCourseTypeTextView = (TextView) view.findViewById(R.id.student_course_type);
            deleteButton = (Button) view.findViewById(R.id.delete_btn);
        }

    }
}
