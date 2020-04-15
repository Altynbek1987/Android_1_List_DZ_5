package com.example.android_1_list_dz_5;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView tv_name;
    private TextView tv_surname;
    private CreateStudentsActivity activity;
    private Students students;
    onClick listener;
    public ViewHolder(@NonNull final View itemView) {
        super(itemView);
        tv_name = itemView.findViewById(R.id.tv_add_Name);
        tv_surname = itemView.findViewById(R.id.tv_add_surname);
        activity = new CreateStudentsActivity();
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click(getAdapterPosition(),students);
            }
        });
    }

    public void onBind(Students students){
        this.students = students;
        tv_name.setText(students.getEt_add_name());
        tv_surname.setText(students.getEt_add_surname());
    }
}
