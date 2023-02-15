package com.example.bunktracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime = 0;    // used by onBackPressed()
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

    @Override
    public void onBackPressed() {        // to prevent irritating accidental logouts
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {    // 2 secs
            backPressedTime = t;
            Toast.makeText(this, "Press back again to exit",
                    Toast.LENGTH_SHORT).show();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();       // bye
        }
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
        // Intent for Subject Report Activity
        public void subReport (View view){
            Intent intent = new Intent(this, SubjectReport.class);
            startActivity(intent);
        }

    public void about(View view) {
        Intent intent = new Intent(getApplicationContext(),about.class);
        startActivity(intent);
    }
}