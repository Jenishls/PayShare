package com.e.payshare.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.payshare.DashboardActivity;
import com.e.payshare.R;

import java.util.HashMap;
import java.util.Map;

import api.GroupAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import url.Url;

public class AddGroupActivity extends AppCompatActivity {
    private EditText etGroupName, etGroupDesc;
    private Button btnGroupSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etGroupName = findViewById(R.id.etGroupName);
        etGroupDesc = findViewById(R.id.etGroupDesc);
        btnGroupSave = findViewById(R.id.btnGroupSave);

        btnGroupSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUsingFieldMap();
            }
        });
    }

    private void saveUsingFieldMap() {
        String groupName = etGroupName.getText().toString();
        String groupDesc = etGroupDesc.getText().toString();
//
//        String name = etName.getText().toString();
//        String desc= etDesc.getText().toString();

        Map<String, String> map =  new HashMap<>() ;
        map.put("name", groupName);
        map.put("desc", groupDesc);

        GroupAPI groupAPI = Url.getInstance().create(GroupAPI.class);
        Call<Void> heroesCall = groupAPI.addGroup(map);

        heroesCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(AddGroupActivity.this, "Code : "+response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(AddGroupActivity.this, "Successfully Added", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddGroupActivity.this, DashboardActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddGroupActivity.this, "Code : "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
