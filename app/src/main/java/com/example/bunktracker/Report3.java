package com.example.bunktracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.AlphabeticIndex;
import android.icu.text.Collator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Report3 extends AppCompatActivity {
    String sub3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        // RETRIEVING DATA FROM SHARED PRE TO SET IT AS THE TOOLBAR TITLE OF THIS ACTIVITY
        SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
        String sub3 = bt.getString("Sub3", "");

        //SETTING THE TOOLBAR TITLE
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(sub3);

        //BACK BUTTON ON TOOLBAR
        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TotalClass();

        Present();

        BunkedClasses();

        Cancelled();

        Percentage();

    }
//---------------------------------------------------------------------------------------------------------------------------------------

//  METHODS

    protected void TotalClass(){
        TextView totalClassTV = findViewById(R.id.totalClassHeld);
        String total = String.valueOf(RecordBunk.presentCount3+RecordBunk.bunkCount3+RecordBunk.cancellationCount3);
        totalClassTV.setText(total);
    }
    protected void Present(){
        TextView present = findViewById(R.id.present);
        String presentCount = String.valueOf(RecordBunk.presentCount3);
        present.setText(presentCount);
    }
    protected void BunkedClasses(){
        TextView bunkedClassTV = findViewById(R.id.bunkedClassTextView);
        String bunkedClass = String.valueOf(RecordBunk.bunkCount3);
        bunkedClassTV.setText(bunkedClass);
    }
    protected void Cancelled(){
        TextView Cancelled = findViewById(R.id.cancelled);
        String cancelCount = String.valueOf(RecordBunk.cancellationCount3);
        Cancelled.setText(cancelCount);
    }
    protected void Percentage(){
        TextView currentPercentageTV = findViewById(R.id.currentPer);
        float total = RecordBunk.presentCount3+RecordBunk.bunkCount3+RecordBunk.cancellationCount3;
        float currentPercentage = ((RecordBunk.presentCount3+RecordBunk.cancellationCount3)/total)*100;
        String s = Float.toString(currentPercentage);
        if (RecordBunk.presentCount3==0 && RecordBunk.presentCount3+RecordBunk.bunkCount3+RecordBunk.cancellationCount3==0 && RecordBunk.cancellationCount3==0){
            currentPercentageTV.setText("0%");
        } else {
            currentPercentageTV.setText(String.format("%.1f", currentPercentage)+" %");
        }
    }

    public void DeleteButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(Report3.this);
        builder.setCancelable(true);
        builder.setMessage("Are you sure you want to delete "+RecordBunk.sub3+"?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
                bt.edit().remove("Sub3").apply();
                RecordBunk.presentCount3=0;
                RecordBunk.bunkCount3=0;
                RecordBunk.cancellationCount3=0;
                finish();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();;
    }
}