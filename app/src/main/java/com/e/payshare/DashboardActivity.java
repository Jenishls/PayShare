package com.e.payshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adapter.GroupAdapter;
import model.Group;

public class DashboardActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.groupRecycler);

        List<Group> groupList = new ArrayList<>();
        groupList.add(new Group("Group 1"));
        groupList.add(new Group("Group 2"));
        groupList.add(new Group("Group 3"));
        groupList.add(new Group("Group 4"));
        groupList.add(new Group("Group 5"));

        GroupAdapter groupAdapter = new GroupAdapter(this,groupList);
        recyclerView.setAdapter(groupAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent  = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
