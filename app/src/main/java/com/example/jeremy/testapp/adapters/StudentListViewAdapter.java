package com.example.jeremy.testapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeremy.testapp.R;
import com.example.jeremy.testapp.models.Student;

import java.util.List;

public class StudentListViewAdapter extends BaseAdapter {

    public interface StudentListEventListener {
        void onDeleteBtn(int position);
    }

    private List<Student> list;
    private StudentListEventListener studentListEventListener;
    private LayoutInflater layoutInflater;

    public StudentListViewAdapter(Context context, List<Student> list) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    public void addListener(StudentListEventListener studentListEventListener) {
        this.studentListEventListener = studentListEventListener;
    }

    public void onUpdateList(List<Student> newData) {
        list.clear();
        list.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StudentViewHolder studentViewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.student_view_holder_layout , parent , false);
            studentViewHolder = new StudentViewHolder(convertView);
            convertView.setTag(studentViewHolder);
        }
        else studentViewHolder = (StudentViewHolder) convertView.getTag();
        //save to final local var as we can't change parent method param to final
        final int i = position;
        Student student = list.get(i);
        studentViewHolder.studentAgeTextView.setText(student.getAge());
        studentViewHolder.studentNameTextView.setText(student.getName());
        studentViewHolder.studentSurnamTextView.setText(student.getSurname());
        studentViewHolder.studentCourseTypeTextView.setText(student.getCourseType().toString());
        studentViewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentListEventListener != null) studentListEventListener.onDeleteBtn(i);
            }
        });
        return convertView;
    }

    private class StudentViewHolder {

        private Button deleteButton;
        private TextView studentNameTextView, studentAgeTextView, studentSurnamTextView, studentCourseTypeTextView;

        private StudentViewHolder(View view) {
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
