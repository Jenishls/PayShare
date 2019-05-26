package com.e.payshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.e.payshare.group.AddGroupActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.GroupAdapter;
import api.GroupAPI;
import model.Group;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class DashboardActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.groupRecycler);


        GroupAPI heroAPI = Url.getInstance().create(GroupAPI.class);

        Call<List<Group>> listCall = heroAPI.getAllGroup();

        listCall.enqueue(new Callback<List<Group>>() {
            @Override
            public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
                generateList(response.body());
            }

            @Override
            public void onFailure(Call<List<Group>> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Error : "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent  = new Intent(DashboardActivity.this, AddGroupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void generateList(List<Group> body) {
        List<Group> groupList = body;
        List<Group> showList = new ArrayList<>();

        for (Group group: groupList){
            showList.add(new Group(group.getId(), group.getName(), group.getDesc() ));
        }
        GroupAdapter groupAdapter = new GroupAdapter(this, showList);
        recyclerView.setAdapter(groupAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
