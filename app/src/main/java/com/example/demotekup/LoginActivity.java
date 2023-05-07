package com.example.demotekup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText loginEmail, loginPassword ;
    private Button loginButton;
    private Button fbButton ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        loginEmail = findViewById(R.id.login_mail);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        fbButton = findViewById(R.id.fb_buttom);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String pass = loginPassword.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        if (email == "admin@gmail.com") {
                                            startActivity(new Intent(LoginActivity.this, AminActivity.class));
                                            finish();

                                        } else {
                                            startActivity(new Intent(LoginActivity.this, TeacherActivity.class));
                                            finish();
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        loginPassword.setError("Password cannot be empty");
                    }
                }
                else if (email.isEmpty()){
                    loginEmail.setError("Email cannot be empty");

                } else {
                    loginEmail.setError("Please enter valid mail");
                }
            }
        });

        fbButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/tekup.de/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}