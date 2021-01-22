package com.example.pause;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pause.data.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    Button registerButton;
    EditText emailET,passwordET,fullnameET;
    TextView loginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        loginTextView = findViewById(R.id.loginTextView);
        registerButton = findViewById(R.id.registerButton);
        emailET = findViewById(R.id.emailEditText);
        passwordET = findViewById(R.id.passwordEditText);
        fullnameET = findViewById(R.id.fullnameEditText);

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password,fullname;
                email = emailET.getText().toString();
                password = passwordET.getText().toString();
                fullname = fullnameET.getText().toString();
                if(email.isEmpty() || password.isEmpty() || fullname.isEmpty()){
                    Snackbar.make(v, "all fields are required", Snackbar.LENGTH_LONG)
                            .setAction("Fill your infos", null).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(fullname).build();
                                        user.updateProfile(profileUpdates);
                                        User userInfos = new User(user.getUid(),email,fullname,"",
                                                false,"add your description here ...",new Date().getTime(),
                                                0,0,fullname);
                                        db.collection("users").document(user.getUid())
                                                .set(userInfos).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()) {
                                                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                                                    finish();
                                                    startActivity(intent);
                                                }
                                            }
                                        });
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Snackbar.make(v, "Oops looks like there is an error", Snackbar.LENGTH_LONG)
                                            .setAction("Error", null).show();
                                }
                            });
                }

            }
        });
    }
}