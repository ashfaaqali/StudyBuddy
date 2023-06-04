package com.example.bunktracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import org.w3c.dom.Text;

import java.util.Objects;

public class ThuScheduleFragment extends Fragment {

    FloatingActionButton AddButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thu_schedule_fragment, null);
        AddButton = (FloatingActionButton) view.findViewById(R.id.add_subjects);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                UploadData();
                startActivity(new Intent(getContext(), AddSubjects.class));
            }
        });
        return view;
    }



}
