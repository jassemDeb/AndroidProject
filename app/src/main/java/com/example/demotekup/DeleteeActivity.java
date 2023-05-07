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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DeleteeActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText deleteEmail, deletePassword ;
    private Button deleteButton ;

    private FirebaseUser user1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.deleteteacher);

        auth = FirebaseAuth.getInstance();
        deleteEmail = findViewById(R.id.delete_mail);
        deletePassword = findViewById(R.id.delete_password);
        deleteButton = findViewById(R.id.delete_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = deleteEmail.getText().toString().trim();
                String pass = deletePassword.getText().toString().trim();

                if (user.isEmpty()){
                    deleteEmail.setError("Email cannot be empty");
                }
                if (pass.isEmpty()){
                    deletePassword.setError("Password cannot be empty");
                } else {
                    user1.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(DeleteeActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DeleteeActivity.this , AminActivity.class));
                            } else {
                                Toast.makeText(DeleteeActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }
}