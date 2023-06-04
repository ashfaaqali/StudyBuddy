package com.example.bunktracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddSubjects extends AppCompatActivity {
    EditText SubjectName1, SubjectName2, SubjectName3, SubjectName4, SubjectName5;
    EditText RequiredAttendance1, RequiredAttendance2, RequiredAttendance3, RequiredAttendance4, RequiredAttendance5;
    Button Save;

    FirebaseDatabase database;
    DatabaseReference reference;

    String day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subjects);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        day = (String) bundle.get("day");

        Save = (Button) findViewById(R.id.add_subjects);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadData();
            }
        });
    }
    private void UploadData() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_bar);
        AlertDialog dialog = builder.create();
        dialog.show();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("weekly schedule");

        SubjectName1 = findViewById(R.id.subject_name1);
        SubjectName2 = (EditText) findViewById(R.id.subject_name2);
        SubjectName3 = (EditText) findViewById(R.id.subject_name3);
        SubjectName4 = (EditText) findViewById(R.id.subject_name4);
        SubjectName5 = (EditText) findViewById(R.id.subject_name5);

        RequiredAttendance1 = (EditText) findViewById(R.id.required_attendance1);
        RequiredAttendance2 = (EditText) findViewById(R.id.required_attendance2);
        RequiredAttendance3 = (EditText)findViewById(R.id.required_attendance3);
        RequiredAttendance4 = (EditText)findViewById(R.id.required_attendance4);
        RequiredAttendance5 = (EditText)findViewById(R.id.required_attendance5);

        String subName1 =  SubjectName1.getText().toString();
        String subName2 =  SubjectName2.getText().toString();
        String subName3 =  SubjectName3.getText().toString();
        String subName4 =  SubjectName4.getText().toString();
        String subName5 =  SubjectName5.getText().toString();

        String reqAttendancePercentage1 =  RequiredAttendance1.getText().toString();
        String reqAttendancePercentage2 =  RequiredAttendance2.getText().toString();
        String reqAttendancePercentage3 =  RequiredAttendance3.getText().toString();
        String reqAttendancePercentage4 =  RequiredAttendance4.getText().toString();
        String reqAttendancePercentage5 =  RequiredAttendance5.getText().toString();

        SubjectReportModel subjectReportModel = new SubjectReportModel(subName1, subName2, subName3, subName4, subName5, reqAttendancePercentage1, reqAttendancePercentage2, reqAttendancePercentage3, reqAttendancePercentage4, reqAttendancePercentage5);

        reference.child(day).setValue(subjectReportModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}