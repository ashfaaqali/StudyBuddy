package com.example.bunktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddSubject extends AppCompatActivity {
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
        EditText sub1edit = findViewById(R.id.sub1edit);
        EditText sub2edit = findViewById(R.id.sub2edit);
        EditText sub3edit = findViewById(R.id.sub3edit);
        EditText sub4edit = findViewById(R.id.sub4edit);
        EditText sub5edit = findViewById(R.id.sub5edit);
        EditText sub6edit = findViewById(R.id.sub6edit);

        SharedPreferences bt = getSharedPreferences("BunkTracker", MODE_PRIVATE);
        SharedPreferences.Editor spEd = bt.edit();

        //CHECKING IF THERE'S A VALUE ALREADY STORED IN SHARED PRE
        //IF THERE'S A VALUE THIS PIECE OF CODE WILL SET THAT VALUE TO THE EDIT TEXT
        //AND MAKE THAT EDIT TEXT UN-EDITABLE

        // SUBJECT 1
        if (bt.contains("Sub1")){
            String storedValue = bt.getString("Sub1", "");
            sub1edit.setText(storedValue);
            if (storedValue.length()>0) {sub1edit.setEnabled(false);}
        }
        // SUBJECT 2
        if (bt.contains("Sub2")){
            String storedValue = bt.getString("Sub2", "");
            sub2edit.setText(storedValue);
            if (storedValue.length()>0){sub2edit.setEnabled(false);}
        }
        // SUBJECT 3
        if (bt.contains("Sub3")){
            String storedValue = bt.getString("Sub3", "");
            sub3edit.setText(storedValue);
            if (storedValue.length()>0){sub3edit.setEnabled(false);}
        }
        // SUBJECT 4
        if (bt.contains("Sub4")){
            String storedValue = bt.getString("Sub4", "");
            sub4edit.setText(storedValue);
            if (storedValue.length()>0){sub4edit.setEnabled(false);}
        }
        //SUBJECT 5
        if (bt.contains("Sub5")){
            String storedValue = bt.getString("Sub5", "");
            sub5edit.setText(storedValue);
            if (storedValue.length()>0){sub5edit.setEnabled(false);}
        }
        //SUBJECT 6
        if (bt.contains("Sub6")){
            String storedValue = bt.getString("Sub6", "");
            sub6edit.setText(storedValue);
            if (storedValue.length()>0){sub6edit.setEnabled(false);}
        }

        // Add Subject Button
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sub1 = sub1edit.getText().toString();
                String sub2 = sub2edit.getText().toString();
                String sub3 = sub3edit.getText().toString();
                String sub4 = sub4edit.getText().toString();
                String sub5 = sub5edit.getText().toString();
                String sub6 = sub6edit.getText().toString();

                spEd.putString("Sub1", sub1);
                spEd.putString("Sub2", sub2);
                spEd.putString("Sub3", sub3);
                spEd.putString("Sub4", sub4);
                spEd.putString("Sub5", sub5);
                spEd.putString("Sub6", sub6);

                if(sub1.length()==0){
                    sub1edit.setError("Subject 1 is necessary");
                }
                else{
                    spEd.apply();
                    Toast.makeText(AddSubject.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddSubject.this, SubjectsAdded.class);
                    startActivity(intent);
                }

            }
        });

    }
}