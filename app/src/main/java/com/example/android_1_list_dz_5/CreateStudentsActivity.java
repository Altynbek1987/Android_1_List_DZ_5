package com.example.android_1_list_dz_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateStudentsActivity extends AppCompatActivity {

    private EditText et_add_name, et_add_surname, et_add_patronymic, et_add_birthday,
            et_add_phone, et_add_address, et_add_group, et_add_assessments;
    private Button btn_save_csa;
    public static final String EXTRA_KEY = "key";
    public static final String KEY = "ky";
    private Intent intent;
    private Students students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_students);
        initView();
        getIntentA();
        btn_save_csa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextEd();
                Intent intent = new Intent(CreateStudentsActivity.this,MainActivity.class);
                intent.putExtra(EXTRA_KEY, students);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }

    public void initView() {
        et_add_name = findViewById(R.id.et_add_name);
        et_add_surname = findViewById(R.id.et_add_surname);
        et_add_patronymic = findViewById(R.id.et_add_patronymic);
        et_add_birthday = findViewById(R.id.et_add_birthday);
        et_add_phone = findViewById(R.id.et_add_phone);
        et_add_address = findViewById(R.id.et_add_address);
        et_add_group = findViewById(R.id.et_add_group);
        et_add_assessments = findViewById(R.id.et_add_assessments);
        btn_save_csa = findViewById(R.id.btn_save_csa);
    }

    public void getTextEd() {
        students = new Students();
        students.setEt_add_name(et_add_name.getText().toString());
        students.setEt_add_surname(et_add_surname.getText().toString());
        students.setEt_add_patronymic(et_add_patronymic.getText().toString());
        students.setEt_add_birthday(et_add_birthday.getText().toString());
        students.setEt_add_phone(et_add_phone.getText().toString());
        students.setEt_add_address(et_add_address.getText().toString());
        students.setEt_add_group(et_add_group.getText().toString());
        students.setEt_add_assessments(et_add_assessments.getText().toString());
    }


    public void getIntentA() {
        intent = getIntent();
        students = (Students) intent.getSerializableExtra("result");
        if (students != null) {
            getText();
        }
    }

    public void getText() {
        et_add_name.setText(students.getEt_add_name());
        et_add_surname.setText(students.getEt_add_surname());
        et_add_patronymic.setText(students.getEt_add_patronymic());
        et_add_assessments.setText(students.getEt_add_assessments());
        et_add_group.setText(students.getEt_add_group());
        et_add_address.setText(students.getEt_add_address());
        et_add_birthday.setText(students.getEt_add_birthday());
        et_add_phone.setText(students.getEt_add_phone());
    }


}
