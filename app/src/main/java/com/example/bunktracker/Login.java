package com.example.bunktracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    TextView signUpIntent;
    EditText EmailEditText, PassEditText;
    Button loginButton;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EmailEditText = (EditText) findViewById(R.id.email);
        PassEditText = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        signUpIntent = (TextView) findViewById(R.id.login_to_signup_intent);
        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = EmailEditText.getText().toString();
                String pass = PassEditText.getText().toString();
                boolean validation = RunValidations(email, pass);
                if (validation){
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(getApplicationContext(), "Login Successful!",
                                                Toast.LENGTH_SHORT).show();
                                        finish();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(getApplicationContext(), "some error occurred",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        signUpIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), SignUp.class));
                finish();
            }
        });

    }
    private boolean RunValidations(String email, String pass) {

        if (email.isEmpty()) {
            EmailEditText.requestFocus();
            EmailEditText.setError("Field Cannot Be Empty");
            return false;
        }
        else if (pass.length()<=5) {
            EmailEditText.requestFocus();
            EmailEditText.setError("Password should have least 6 characters");
            return false;
        }
        else {
            return true;
        }
    }
}