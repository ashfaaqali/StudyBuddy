package com.example.bunktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AddSubject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView title = findViewById(R.id.toolbar_title);
        title.setText("Add Subject");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
    }
}