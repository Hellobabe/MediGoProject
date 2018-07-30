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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText eemail, Uname, psswrd, aaddress;
    ProgressBar progbar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btnSU).setOnClickListener(this);
        findViewById(R.id.btnSI).setOnClickListener(this);

        eemail = (EditText) findViewById(R.id.eemail);
        psswrd = (EditText) findViewById(R.id.psswrd);
        Uname  = (EditText) findViewById(R.id.Uname);
        aaddress = (EditText) findViewById(R.id.aaddress);
        progbar = findViewById(R.id.progbar);

    }
    private void registerUser() {
        String email = eemail.getText().toString().trim();
        String password = psswrd.getText().toString().trim();
        String username = Uname.getText().toString().trim();
        String address = aaddress.getText().toString().trim();

            if (username.isEmpty()) {
                Uname.setError("Enter a username");
                Uname.requestFocus();
                return;
            }
            if (email.isEmpty()) {
                eemail.setError("Enter an email");
                eemail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                eemail.setError("Enter a valid Email!");
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
            if (address.isEmpty()) {
                aaddress.setError("Enter an address");
                aaddress.requestFocus();
                return;
            }


            progbar.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progbar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    } else {

                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(getApplicationContext(), "Email already taken, try other", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSU:
                registerUser();
                break;

            case R.id.btnSI:
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}