package com.project.softdev.medigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    Button btncam, btnpic, nonprescription, btnprofile;
    ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btncam).setOnClickListener(this);
        findViewById(R.id.btnpic).setOnClickListener(this);
        findViewById(R.id.nonprescription).setOnClickListener(this);
        findViewById(R.id.btnprofile).setOnClickListener(this);

        progressBar2 = findViewById(R.id.progressBar2);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btncam:
                startActivity(new Intent(this, OCRActivity.class));
                // ha[[ylife@gmail.comprogressBar2.setVisibility(View.VISIBLE);
                break;

            case R.id.btnpic:
                startActivity(new Intent());
                break;

            case R.id.nonprescription:
                startActivity(new Intent());
                break;

            case R.id.btnprofile:
                startActivity(new Intent(this, ProfileActivity.class));
                //progressBar2.setVisibility(View.VISIBLE);
                break;

            /*case R.id.ic_logout:
                mAuth.signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;*/

        }
    }
}