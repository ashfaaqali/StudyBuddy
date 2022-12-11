package com.example.bunktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AddSubject extends AppCompatActivity {
    private EditText sub1edit;
    private EditText sub2edit;
    private EditText sub3edit;
    private EditText sub4edit;
    private EditText sub5edit;
    private EditText sub6edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        //Setting toolbar title
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.toolbartitle);

        //Back button on add subject activity
        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //Subject names/Edit Text views
        sub1edit = findViewById(R.id.sub1edit);
        sub2edit = findViewById(R.id.sub2edit);
        sub3edit = findViewById(R.id.sub3edit);
        sub4edit = findViewById(R.id.sub4edit);
        sub5edit = findViewById(R.id.sub5edit);
        sub6edit = findViewById(R.id.sub6edit);

        // Add Subject Button
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub1 = sub1edit.getText().toString();
                if(sub1.length()==0){
                    sub1edit.setError("Enter at least 1 subject");
                }
                else{
                    String sub2 = sub2edit.getText().toString();
                    String sub3 = sub3edit.getText().toString();
                    String sub4 = sub4edit.getText().toString();
                    String sub5 = sub5edit.getText().toString();
                    String sub6 = sub6edit.getText().toString();

                    SharedPreferences bt = getSharedPreferences("BunkTracker", MODE_PRIVATE);
                    SharedPreferences.Editor spEd = bt.edit();

                    spEd.putString("Sub", sub1);
                    spEd.putString("Sub", sub2);
                    spEd.putString("Sub", sub3);
                    spEd.putString("Sub", sub4);
                    spEd.putString("Sub", sub6);
                    spEd.putString("Sub", sub5);
                    spEd.apply();
                    Intent intent = new Intent(AddSubject.this, SubjectsAdded.class);
                    startActivity(intent);
                }

            }
        });

    }
}