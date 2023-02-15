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

public class Report5 extends AppCompatActivity {
    String sub5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        // RETRIEVING DATA FROM SHARED PRE TO SET IT AS THE TOOLBAR TITLE OF THIS ACTIVITY
        SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
        String sub5 = bt.getString("Sub5", "");

        //SETTING THE TOOLBAR TITLE
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(sub5);

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
        String total = String.valueOf(RecordBunk.presentCount5+RecordBunk.bunkCount5+RecordBunk.cancellationCount5);
        totalClassTV.setText(total);
    }
    protected void Present(){
        TextView present = findViewById(R.id.present);
        String presentCount = String.valueOf(RecordBunk.presentCount5);
        present.setText(presentCount);
    }
    protected void BunkedClasses(){
        TextView bunkedClassTV = findViewById(R.id.bunkedClassTextView);
        String bunkedClass = String.valueOf(RecordBunk.bunkCount5);
        bunkedClassTV.setText(bunkedClass);
    }
    protected void Cancelled(){
        TextView Cancelled = findViewById(R.id.cancelled);
        String cancelCount = String.valueOf(RecordBunk.cancellationCount5);
        Cancelled.setText(cancelCount);
    }
    protected void Percentage(){
        TextView currentPercentageTV = findViewById(R.id.currentPer);
        float total = RecordBunk.presentCount5+RecordBunk.bunkCount5+RecordBunk.cancellationCount5;
        float currentPercentage = ((RecordBunk.presentCount5+RecordBunk.cancellationCount5)/total)*100;
        String s = Float.toString(currentPercentage);
        if (RecordBunk.presentCount5==0 && RecordBunk.presentCount5+RecordBunk.bunkCount5+RecordBunk.cancellationCount5==0 && RecordBunk.cancellationCount5==0){
            currentPercentageTV.setText("0%");
        } else {
            currentPercentageTV.setText(String.format("%.1f", currentPercentage)+" %");
        }
    }

    public void DeleteButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(Report5.this);
        builder.setCancelable(true);
        builder.setMessage("Are you sure you want to delete "+RecordBunk.sub5+"?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
                bt.edit().remove("Sub5").apply();
                RecordBunk.presentCount5=0;
                RecordBunk.bunkCount5=0;
                RecordBunk.cancellationCount5=0;
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