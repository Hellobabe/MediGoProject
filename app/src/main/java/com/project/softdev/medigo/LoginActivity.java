package com.project.softdev.medigo;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    EditText eemail, psswrd;
    ProgressBar progbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btnLSU).setOnClickListener(this);
        findViewById(R.id.btnLSI).setOnClickListener(this);

        eemail = (EditText) findViewById(R.id.eemail);
        psswrd = (EditText) findViewById(R.id.psswrd);
        progbar = findViewById(R.id.progbar);
    }

    private void userLogin() {
        String password = psswrd.getText().toString().trim();
        String email = eemail.getText().toString().trim();

        if (email.isEmpty()) {
            eemail.setError("Enter an email");
            eemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            eemail.setError("Enter a valid Email");
            eemail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            psswrd.setError("Enter a password");
            psswrd.requestFocus();
            return;
        }

        if (password.length() < 6) {
            psswrd.setError("Password must be at least 6 characters");
            psswrd.requestFocus();
            return;
            }

            progbar.setVisibility(View.VISIBLE);

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progbar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        @Override
        public void onClick (View view){
            switch (view.getId()) {
                case R.id.btnLSI:
                    userLogin();
                    break;

                case R.id.btnLSU:
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                    break;

            }
        }
    }