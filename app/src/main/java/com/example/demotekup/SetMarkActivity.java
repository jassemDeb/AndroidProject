package com.example.demotekup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SetMarkActivity extends AppCompatActivity {

    private Button SetMark;
    private Button Home ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_mark);
        SetMark = findViewById(R.id.set_mark);
        Home = findViewById(R.id.homeTeacher);

        SetMark.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(SetMarkActivity.this, "Mark Setted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SetMarkActivity.this, TeacherActivity.class));
                finish();

            }
        });

        Home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(SetMarkActivity.this, TeacherActivity.class));
                finish();

            }
        });
    }
}