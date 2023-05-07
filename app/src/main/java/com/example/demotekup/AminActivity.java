package com.example.demotekup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AminActivity extends AppCompatActivity {

    private Button Addprof;
    private Button Deleteprof;
    private Button Viewstudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhome);
        Addprof = findViewById(R.id.add_button_home);
        Deleteprof = findViewById(R.id.delete_button_home);
        Viewstudent = findViewById(R.id.view_button_home);

        Addprof.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(AminActivity.this, MainActivity.class));
                finish();

            }
        });
        Deleteprof.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(AminActivity.this, DeleteeActivity.class));
                finish();

            }
        });
        Viewstudent.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(AminActivity.this, StudenttList.class));
                finish();

            }
        });



    }
}