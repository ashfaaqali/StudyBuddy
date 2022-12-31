package com.example.bunktracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Exit Button
        Button exitBtn = findViewById(R.id.exit);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
        // Intent for Add Subject Activity
        public void addSub (View view){
            Intent intent = new Intent(this, AddSubject.class);
            startActivity(intent);
        }
        // Intent for Record Bunk Activity
        public void recBunk (View view){
            Intent intent = new Intent(this, RecordBunk.class);
            startActivity(intent);
        }
    }