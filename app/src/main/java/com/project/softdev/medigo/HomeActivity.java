package com.project.softdev.medigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    Button btnlogout, btncam, btnpic, btnnonprescript, btnprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btnlogout).setOnClickListener(this);
        findViewById(R.id.btncam).setOnClickListener(this);
        findViewById(R.id.btnpic).setOnClickListener(this);
        findViewById(R.id.btnnonprescript).setOnClickListener(this);
        findViewById(R.id.btnprofile).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btncam:
                startActivity(new Intent());
                break;

            case R.id.btnpic:
                startActivity(new Intent());
                break;

            case R.id.btnnonprescript:
                startActivity(new Intent());
                break;

            case R.id.btnprofile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;

            case R.id.btnlogout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;

        }
    }
}