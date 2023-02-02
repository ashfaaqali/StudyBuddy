package com.example.bunktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.AlphabeticIndex;
import android.icu.text.Collator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Report1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        // RETRIEVING DATA FROM SHARED PRE TO SET IT AS THE TOOLBAR TITLE OF THIS ACTIVITY
        SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
        String sub1 = bt.getString("Sub1", "");

        //SETTING THE TOOLBAR TITLE
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(sub1);

        //BACK BUTTON ON TOOLBAR
        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView totalClassTV = findViewById(R.id.totalClassHeld);
        String totalClassHeld = String.valueOf(RecordBunk.presentCount1+RecordBunk.bunkCount1+RecordBunk.cancellationCount1);
        totalClassTV.setText(totalClassHeld);

        TextView bunkedClassTV = findViewById(R.id.bunkedClassTextView);
        String bunkedClass = String.valueOf(RecordBunk.bunkCount1);
        bunkedClassTV.setText(bunkedClass);

        TextView currentPercentageTV = findViewById(R.id.currentPer);
        float total = RecordBunk.presentCount1+RecordBunk.cancellationCount1;
        float currentPercentage = (RecordBunk.presentCount1/(total*100));
        currentPercentageTV.setText(Float.toString(Float.parseFloat(currentPercentage+"%")));
    }
}