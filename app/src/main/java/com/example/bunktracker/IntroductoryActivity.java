package com.example.bunktracker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IntroductoryActivity extends AppCompatActivity {

    TextView textView1, textView2;
    Button loginButton, regButton;
    FloatingActionButton googleLogin, fbLogin;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        loginButton = findViewById(R.id.btn_login);
        regButton = findViewById(R.id.btn_signup);
        mAuth = FirebaseAuth.getInstance();

        // Checking if a user is logged in

        //Person who created an account on StudyBuddy i.e. Firebase user
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        //Person who logged in using google account
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        // Clicked Login button of Introductory Activity
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
        // Clicked Sign Up button of Introductory Activity
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });
        //Google login integration
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
        googleLogin = findViewById(R.id.google_login);
        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = gsc.getSignInIntent();
                //getSignInIntent() ==> Google account choosing screen
                startActivityForResult(signInIntent, 1000);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
    }
}