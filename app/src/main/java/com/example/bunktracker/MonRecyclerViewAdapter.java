package com.example.bunktracker;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonRecyclerViewAdapter extends RecyclerView.Adapter<MonRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private final List<SubjectReportModel> list;

    public MonRecyclerViewAdapter(Context context, List<SubjectReportModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MonRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stored_subject_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.SubjectName1.setText(list.get(position).getSubName1().toString());
        holder.SubjectName2.setText(list.get(position).getSubName2().toString());
        holder.SubjectName3.setText(list.get(position).getSubName3().toString());
        holder.SubjectName4.setText(list.get(position).getSubName4().toString());
        holder.SubjectName5.setText(list.get(position).getSubName5().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView SubjectName1, SubjectName2, SubjectName3, SubjectName4, SubjectName5;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            SubjectName1 = itemView.findViewById(R.id.s_name1);
            SubjectName2 = itemView.findViewById(R.id.s_name2);
            SubjectName3 = itemView.findViewById(R.id.s_name3);
            SubjectName4 = itemView.findViewById(R.id.s_name4);
            SubjectName5 = itemView.findViewById(R.id.s_name5);
        }
    }
}
