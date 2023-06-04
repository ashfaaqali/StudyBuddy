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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MonScheduleFragment extends Fragment {
    String day = "monday";

    FloatingActionButton AddButton;
    RecyclerView recyclerView;
    List<SubjectReportModel> subjectReportList;
    DatabaseReference databaseReference;
    ValueEventListener valueEventListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mon_schedule_fragment, null);

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        AddButton = (FloatingActionButton) view.findViewById(R.id.add_subjects);

        subjectReportList = new ArrayList<>();
        MonRecyclerViewAdapter monRecyclerViewAdapter = new MonRecyclerViewAdapter(getContext(), subjectReportList);
        recyclerView.setAdapter(monRecyclerViewAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("weekly schedule").child(day);
        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subjectReportList.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    SubjectReportModel subjectReportModel = itemSnapshot.getValue(SubjectReportModel.class);
                    subjectReportList.add(subjectReportModel);
                }
                monRecyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddSubjects.class);
                intent.putExtra("day", day);
                startActivity(intent);
            }
        });
        return view;
    }



}
