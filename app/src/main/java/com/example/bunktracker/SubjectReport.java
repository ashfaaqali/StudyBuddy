package com.example.bunktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SubjectReport extends AppCompatActivity {

    private TextView subject1, subject2, subject3, subject4, subject5, subject6;
    private String sub1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_report);

        //Setting toolbar title
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Subject Report");

        //Back button on add subject activity
        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // METHOD CALLS
        retrieveData();
        clickLis();

    }

    // METHODS

    void retrieveData(){

        subject1 = findViewById(R.id.sub1);
        subject2 = findViewById(R.id.sub2);
        subject3 = findViewById(R.id.sub3);
        subject4 = findViewById(R.id.sub4);
        subject5 = findViewById(R.id.sub5);
        subject6 = findViewById(R.id.sub6);

        // RETRIEVING DATA FROM SHARED PRE
        SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
        sub1 = bt.getString("Sub1", "");
        if(sub1.length()>0){
            subject1.setText(sub1);
        }
        String sub2 = bt.getString("Sub2", "");
        if (sub2.length()>0){
            subject2.setText(sub2);
        }
        String sub3 = bt.getString("Sub3", "");
        if (sub3.length()>0){
            subject3.setText(sub3);
        }
        String sub4 = bt.getString("Sub4", "");
        if (sub4.length()>0){
            subject4.setText(sub4);
        }
        String sub5 = bt.getString("Sub5", "");
        if (sub5.length()>0){
            subject5.setText(sub5);
        }
        String sub6 = bt.getString("Sub6", "");
        if (sub6.length()>0){
            subject6.setText(sub6);
        }
    }

    void clickLis(){
        subject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubjectReport.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        subject3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubjectReport.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        subject4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubjectReport.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        subject4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubjectReport.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        subject5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubjectReport.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        subject6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubjectReport.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Report1(View view) {
        if (sub1.length()>0){
            Intent i = new Intent(SubjectReport.this, Report1.class);
            startActivity(i);
        } else{
            Toast.makeText(SubjectReport.this, "No Subject Found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Report2(View view) {
    }

    public void Report3(View view) {
    }

    public void Report4(View view) {
    }

    public void Report5(View view) {
    }

    public void Report6(View view) {
    }
}