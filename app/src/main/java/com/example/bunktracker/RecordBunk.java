package com.example.bunktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecordBunk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_bunk);

        //Setting toolbar title
        TextView toolbartitle = findViewById(R.id.toolbar_title);
        toolbartitle.setText("Record Bunk");

        //Back button on add subject activity
        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView subject1, subject2, subject3, subject4, subject5, subject6;
        subject1 = findViewById(R.id.sub1);
        subject2 = findViewById(R.id.sub2);
        subject3 = findViewById(R.id.sub3);
        subject4 = findViewById(R.id.sub4);
        subject5 = findViewById(R.id.sub5);
        subject6 = findViewById(R.id.sub6);

        // RETRIEVING DATA FROM SHARED PRE
        SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
        String sub1 = bt.getString("Sub1", "");
        subject1.setText(sub1);

        String sub2 = bt.getString("Sub2", "");
        subject2.setText(sub2);

        String sub3 = bt.getString("Sub3", "");
        subject3.setText(sub3);

        String sub4 = bt.getString("Sub4", "");
        subject4.setText(sub4);

        String sub5 = bt.getString("Sub5", "");
        subject5.setText(sub5);

        String sub6 = bt.getString("Sub6", "");
        subject6.setText(sub6);

        subject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RecordBunk.this, "success!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}