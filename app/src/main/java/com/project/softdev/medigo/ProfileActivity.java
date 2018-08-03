package com.project.softdev.medigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
          /*  case R.id.gohome:
                finish();
                startActivity(new Intent(this, HomeActivity.class));
                break;


            case R.id.ic_logout:
                mAuth.signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
                */

        }

    }
}