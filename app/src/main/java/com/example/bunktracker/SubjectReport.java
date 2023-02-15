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
    static String sub1, sub2, sub3, sub4, sub5, sub6;
    private TextView subject1, subject2, subject3, subject4, subject5, subject6;
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
    }
//================================================================================================================================================================================================================================
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
        sub2 = bt.getString("Sub2", "");
        if (sub2.length()>0){
            subject2.setText(sub2);
        }
        sub3 = bt.getString("Sub3", "");
        if (sub3.length()>0){
            subject3.setText(sub3);
        }
        sub4 = bt.getString("Sub4", "");
        if (sub4.length()>0){
            subject4.setText(sub4);
        }
        sub5 = bt.getString("Sub5", "");
        if (sub5.length()>0){
            subject5.setText(sub5);
        }
        sub6 = bt.getString("Sub6", "");
        if (sub6.length()>0){
            subject6.setText(sub6);
        }
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
        if (sub2.length()>0){
            Intent i = new Intent(SubjectReport.this, Report2.class);
            startActivity(i);
        } else{
            Toast.makeText(SubjectReport.this, "No Subject Found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Report3(View view) {
        if (sub3.length()>0){
            Intent i = new Intent(SubjectReport.this, Report3.class);
            startActivity(i);
        } else{
            Toast.makeText(SubjectReport.this, "No Subject Found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Report4(View view) {
        if (sub4.length()>0){
            Intent i = new Intent(SubjectReport.this, Report4.class);
            startActivity(i);
        } else{
            Toast.makeText(SubjectReport.this, "No Subject Found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Report5(View view) {
        if (sub5.length()>0){
            Intent i = new Intent(SubjectReport.this, Report5.class);
            startActivity(i);
        } else{
            Toast.makeText(SubjectReport.this, "No Subject Found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Report6(View view) {
        if (sub6.length()>0){
            Intent i = new Intent(SubjectReport.this, Report6.class);
            startActivity(i);
        } else{
            Toast.makeText(SubjectReport.this, "No Subject Found!", Toast.LENGTH_SHORT).show();
        }
    }
}