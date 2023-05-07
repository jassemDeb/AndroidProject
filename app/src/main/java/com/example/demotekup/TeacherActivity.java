package com.example.demotekup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherActivity extends AppCompatActivity {


    private Button SetMark;
    private Button Viewstudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        SetMark = findViewById(R.id.set_mark);
        Viewstudent = findViewById(R.id.view_button_home);

        SetMark.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherActivity.this, SetMarkActivity.class));
                finish();

            }
        });

        Viewstudent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeacherActivity.this, StudenttList.class));
                finish();

            }
        });
    }
}