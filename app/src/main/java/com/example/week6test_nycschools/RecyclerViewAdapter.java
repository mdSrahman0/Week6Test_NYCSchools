package com.example.week6test_nycschools;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week6test_nycschools.model.SATResponse;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<SATResponse> schoolList;

    public RecyclerViewAdapter(List<SATResponse> schools){
        this.schoolList = schools;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        final SATResponse SATitem = schoolList.get(position);
        final String name = SATitem.getSchoolName();
        viewHolder.tvSchoolName.setText(name);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), SATInfoActivity.class);
                    intent.putExtra("dbn", SATitem);
                    v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSchoolName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSchoolName = itemView.findViewById(R.id.tvSchoolName);
        }
    }
}
