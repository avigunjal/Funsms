package com.funsms;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.funsms.Adapter.CategoryAdapter;
import com.funsms.Adapter.SmsListAdapter;
import com.funsms.Model.Data;
import com.funsms.Model.Smsdata;
import com.funsms.Networking.ApiClient;
import com.funsms.Networking.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AVI on 05-01-2018.
 */

public class CategorySmsList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter customAdapter;
    ProgressDialog progressDialog;
    static String category;
    static  String lang;
    private ApiInterface apiInterface;
    private ArrayList<Data> mysmsdata = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Intent intent = getIntent();
        category = intent.getStringExtra("category");
        lang = intent.getStringExtra("lang");

        getSms();
    }
    public void getSms(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Breath in.Breath out.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Smsdata> smsdataCall = apiInterface.SMSDATA_CALL(category,lang);
        smsdataCall.enqueue(new Callback<Smsdata>() {
            @Override
            public void onResponse(Call<Smsdata> call, Response<Smsdata> response) {
                if(response.isSuccessful())
                {
                    progressDialog.dismiss();
                    if(response.body().getResult()==200){
                        mysmsdata = response.body().getData();
                        recyclerView.setAdapter(new SmsListAdapter(getApplicationContext(),mysmsdata));
                        customAdapter = new CustomAdapter(getApplicationContext(),mysmsdata);
                    }
                    else {
                        Toast.makeText(CategorySmsList.this, "Sms will be available soon..", Toast.LENGTH_SHORT).show();
                        CategorySmsList.this.finish();
                    }
                }else {
                    Log.e("Response error:",response.errorBody().toString());
                }


            }

            @Override
            public void onFailure(Call<Smsdata> call, Throwable t) {
                Log.d("Error:",t.getMessage());
            }
        });

    }
}
