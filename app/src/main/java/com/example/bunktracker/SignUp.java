package com.example.bunktracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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

public class SignUp extends AppCompatActivity {
    TextView logInIntent;
    EditText NameEditText, EmailEditText, PassEditText;
    Button SignUpButton;
    ProgressBar progressBar;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        NameEditText = (EditText) findViewById(R.id.name);
        EmailEditText = (EditText) findViewById(R.id.email);
        PassEditText = (EditText) findViewById(R.id.password);
        SignUpButton = (Button) findViewById(R.id.btn_signup);
        logInIntent = (TextView) findViewById(R.id.signup_to_login_intent);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = NameEditText.getText().toString();
                String email = EmailEditText.getText().toString();
                String pass = PassEditText.getText().toString();
                boolean validation = RunValidations(name, email, pass);

                if (validation){
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    // Sign in success
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Account Created",
                                                Toast.LENGTH_SHORT).show();
                                        finish();
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        finish();

                                    } // If sign in fails, displaying a message to the user.
                                    else Toast.makeText(getApplicationContext(), "Some Error Occurred",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                }

            }
        });

        logInIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
    }

    private boolean RunValidations(String name, String email, String pass) {
        if (name.isEmpty()){
            NameEditText.requestFocus();
            NameEditText.setError("Field Cannot Be Empty");
            return false;
        }
        else if (email.isEmpty()) {
            EmailEditText.requestFocus();
            EmailEditText.setError("Field Cannot Be Empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EmailEditText.requestFocus();
            EmailEditText.setError("Enter a valid email");
            return false;
        }
        else if (pass.length()<=5) {
            PassEditText.requestFocus();
            PassEditText.setError("Password should have least 6 characters");
            return false;
        }
        else {
            return true;
        }
    }





}