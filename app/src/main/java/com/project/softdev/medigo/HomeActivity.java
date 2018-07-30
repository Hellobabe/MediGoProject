package com.project.softdev.medigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    Button btncam, btnpic, btnnonprescript, btnprofile;
    ImageView ic_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.ic_logout).setOnClickListener(this);
        findViewById(R.id.btncam).setOnClickListener(this);
        findViewById(R.id.btnpic).setOnClickListener(this);
        findViewById(R.id.btnnonprescript).setOnClickListener(this);
        findViewById(R.id.btnprofile).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btncam:
                finish();
                startActivity(new Intent(this, OCRActivity.class));
                break;

            case R.id.btnpic:
                startActivity(new Intent());
                break;

            case R.id.btnnonprescript:
                startActivity(new Intent());
                break;

            case R.id.btnprofile:
                finish();
                startActivity(new Intent(this, ProfileActivity.class));
                break;

            case R.id.ic_logout:
                mAuth.signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;

        }
    }
}
