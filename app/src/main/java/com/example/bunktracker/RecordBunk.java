package com.example.bunktracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecordBunk extends AppCompatActivity {
    static int presentCount1, presentCount2, presentCount3, presentCount4, presentCount5, presentCount6;
    static int bunkCount1, bunkCount2, bunkCount3, bunkCount4, bunkCount5, bunkCount6;
    static int cancellationCount1, cancellationCount2, cancellationCount3, cancellationCount4, cancellationCount5, cancellationCount6;
    static String sub1, sub2, sub3, sub4, sub5, sub6;
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
        getSubNames();
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //METHODS
    // RETRIEVING DATA FROM SHARED PRE AND SETTING THEM TO THE TEXTVIEW
    void getSubNames(){
        SharedPreferences bt = getApplicationContext().getSharedPreferences("BunkTracker", Context.MODE_PRIVATE);
        TextView subject1 = findViewById(R.id.sub1);
        sub1 = bt.getString("Sub1", "");
        if(sub1.length()>0){
            subject1.setText(sub1);}

        TextView subject2 = findViewById(R.id.sub2);
        sub2 = bt.getString("Sub2", "");
        if (sub2.length()>0){
            subject2.setText(sub2);}

        TextView subject3 = findViewById(R.id.sub3);
        sub3 = bt.getString("Sub3", "");
        if (sub3.length()>0){
            subject3.setText(sub3);}

        TextView subject4 = findViewById(R.id.sub4);
        sub4 = bt.getString("Sub4", "");
        if (sub4.length()>0){
            subject4.setText(sub4);}

        TextView subject5 = findViewById(R.id.sub5);
        sub5 = bt.getString("Sub5", "");
        if (sub5.length()>0){
            subject5.setText(sub5);}

        TextView subject6 = findViewById(R.id.sub6);
        sub6 = bt.getString("Sub6", "");
        if (sub6.length()>0){
            subject6.setText(sub6);}
    }
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //CLICK LISTENERS ON BUTTONS OF SUBJECT 1
    public void present1(View view){
        if (sub1.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to attend "+sub1+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            presentCount1++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}}
    public void bunked1(View view){
        if (sub1.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to bunk "+sub1+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            bunkCount1++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void cancellation1(View view){
        if (sub1.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure "+sub1+" class has cancelled?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            cancellationCount1++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    //CLICK LISTENERS ON BUTTONS OF SUBJECT 2
    public void present2(View view){
        if (sub2.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to attend "+sub2+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            presentCount1++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}}
    public void bunked2(View view){
        if (sub2.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to bunk "+sub2+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            bunkCount2++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void cancellation2(View view){
        if (sub2.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure "+sub2+" class has cancelled?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            cancellationCount2++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    //CLICK LISTENERS ON BUTTONS OF SUBJECT 3
    public void present3(View view){
        if (sub3.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to attend "+sub3+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            presentCount3++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void bunked3(View view){
        if (sub3.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to bunk "+sub3+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            bunkCount3++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void cancellation3(View view){
        if (sub3.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure "+sub3+" class has cancelled?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            cancellationCount3++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    //CLICK LISTENERS ON BUTTONS OF SUBJECT 4
    public void present4(View view){
        if (sub4.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to attend "+sub4+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            presentCount4++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void bunked4(View view){
        if (sub4.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to bunk "+sub4+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            bunkCount4++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void cancellation4(View view){
        if (sub4.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure "+sub4+" class has cancelled?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            cancellationCount4++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    //CLICK LISTENERS ON BUTTONS OF SUBJECT 5
    public void present5(View view){
        if (sub5.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to attend "+sub5+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            presentCount5++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void bunked5(View view){
        if (sub5.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to bunk "+sub5+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            bunkCount5++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void cancellation5(View view){
        if (sub5.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure "+sub5+" class has cancelled?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            cancellationCount5++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    //CLICK LISTENERS ON BUTTONS OF SUBJECT 6
    public void present6(View view){
        if (sub6.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to attend "+sub6+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            presentCount6++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void bunked6(View view){
        if (sub6.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure you want to bunk "+sub6+" class?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            bunkCount6++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
    public void cancellation6(View view){
        if (sub6.length()>0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
            builder.setCancelable(true);
            builder.setMessage("Are you sure "+sub6+" class has cancelled?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //CODE FOR POSITIVE RESPONSE
                            cancellationCount6++;
                            Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //CODE FOR NEGATIVE RESPONSE
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();}
        else {Toast.makeText(RecordBunk.this, "Please add subject first!", Toast.LENGTH_SHORT).show();}
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //ALERT DIALOGUE FOR ATTENDANCE, BUNK CONFIRMATION AND CANCELLATION
    public void presentAttendance(String subject){

    }

    public void bunkConfirmation(String subject) {

        AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
        builder.setCancelable(true);
        builder.setMessage("Are you sure you want to bunk "+subject+" class?");
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //CODE FOR POSITIVE RESPONSE
                        Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //CODE FOR NEGATIVE RESPONSE
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void cancellation(String subject){
        AlertDialog.Builder builder = new AlertDialog.Builder(RecordBunk.this);
        builder.setCancelable(true);
        builder.setMessage("Are you sure "+subject+" class is cancelled?");
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //CODE FOR POSITIVE RESPONSE
                        Toast.makeText(RecordBunk.this, "Bunk recorded. Happy bunking!", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //CODE FOR NEGATIVE RESPONSE
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}