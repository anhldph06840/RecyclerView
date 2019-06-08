package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    private List<Students> studentsList;
    private MyOnItemClickListener myOnItemClickListener;

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }

    public  StudentAdapter(List<Students> studentsList)
    {

        this.studentsList = studentsList;
    }
    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentHolder studentHolder, final int i) {
        studentHolder.tvInfor.setText(studentsList.get(i).name+ " | " + studentsList.get(i).phone  );
        studentHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnItemClickListener.OnClick(studentsList.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public static class StudentHolder extends RecyclerView.ViewHolder{
        public TextView tvInfor;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            tvInfor = itemView.findViewById(R.id.tvInfo);
        }
    }
}
