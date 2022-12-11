package com.example.bunktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        SharedPreferences bt = getSharedPreferences("Bunk Tracker", MODE_PRIVATE);
        String str = bt.getString("Sub", "");
        TextView b = findViewById(R.id.abc);
        b.setText(str);


    }
}