package com.example.demotekup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdddActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText addEmail, addPassword ;
    private Button addButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.addteacher);

        auth = FirebaseAuth.getInstance();
        addEmail = findViewById(R.id.add_mail);
        addPassword = findViewById(R.id.add_password);
        addButton = findViewById(R.id.add_button);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = addEmail.getText().toString().trim();
                String pass = addPassword.getText().toString().trim();
                if (user.isEmpty()){
                    addEmail.setError("Email cannot be empty");
                }
                if (pass.isEmpty()){
                    addEmail.setError("Password cannot be empty");
                } else{
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(AdddActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AdddActivity.this , AminActivity.class));
                            } else {
                                Toast.makeText(AdddActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}