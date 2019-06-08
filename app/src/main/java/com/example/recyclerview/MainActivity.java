package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvList;
    private List<Students> studentsList;
    private  StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvList = (RecyclerView) findViewById(R.id.rvList);
        studentsList = new ArrayList<Students>();
        for (int i =0; i<10; i++){
            Students students = new Students();
            students.phone = "0312213123";
            students.name = "Anh";
            studentsList.add(students);
        }
        rvList.setHasFixedSize(true);
        studentAdapter = new StudentAdapter(studentsList);
        studentAdapter.setMyOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void OnClick(Students students) {
                Toast.makeText(MainActivity.this, students.name,Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(studentAdapter);
    }
}
