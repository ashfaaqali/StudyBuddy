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

public class Report2 extends AppCompatActivity {
    String sub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);

        // RETRIEVING DATA FROM SHARED PRE TO SET IT AS THE TOOLBAR TITLE OF THIS ACTIVITY
        SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
        String sub2 = bt.getString("Sub2", "");

        //SETTING THE TOOLBAR TITLE
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(sub2);

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
        String total = String.valueOf(RecordBunk.presentCount2+RecordBunk.bunkCount2+RecordBunk.cancellationCount2);
        totalClassTV.setText(total);
    }
    protected void Present(){
        TextView present = findViewById(R.id.present);
        String presentCount = String.valueOf(RecordBunk.presentCount2);
        present.setText(presentCount);
    }
    protected void BunkedClasses(){
        TextView bunkedClassTV = findViewById(R.id.bunkedClassTextView);
        String bunkedClass = String.valueOf(RecordBunk.bunkCount2);
        bunkedClassTV.setText(bunkedClass);
    }
    protected void Cancelled(){
        TextView Cancelled = findViewById(R.id.cancelled);
        String cancelCount = String.valueOf(RecordBunk.cancellationCount2);
        Cancelled.setText(cancelCount);
    }
    protected void Percentage(){
        TextView currentPercentageTV = findViewById(R.id.currentPer);
        float total = RecordBunk.presentCount2+RecordBunk.bunkCount2+RecordBunk.cancellationCount2;
        float currentPercentage = ((RecordBunk.presentCount2+RecordBunk.cancellationCount2)/total)*100;
        String s = Float.toString(currentPercentage);
        if (RecordBunk.presentCount2==0 && RecordBunk.presentCount2+RecordBunk.bunkCount2+RecordBunk.cancellationCount2==0 && RecordBunk.cancellationCount2==0){
            currentPercentageTV.setText("0%");
        } else {
            currentPercentageTV.setText(String.format("%.1f", currentPercentage)+" %");
        }
    }

    public void DeleteButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(Report2.this);
        builder.setCancelable(true);
        builder.setMessage("Are you sure you want to delete "+sub2+"?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
                bt.edit().remove("Sub2").apply();
                RecordBunk.presentCount2=0;
                RecordBunk.bunkCount2=0;
                RecordBunk.cancellationCount2=0;
                Toast.makeText(Report2.this, sub2+" deleted!", Toast.LENGTH_SHORT).show();
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