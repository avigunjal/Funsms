package com.funsms;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.funsms.Adapter.CategoryAdapter;
import com.funsms.Model.CategoryData;
import com.funsms.Model.Data;
import com.funsms.Model.Smsdata;
import com.funsms.Networking.ApiClient;
import com.funsms.Networking.ApiInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private String category_list[];
    private String category[];
    private int category_images[];
    private ArrayList<CategoryData> mylist;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

        if(isNetworkAvailable()==false){
            Toast.makeText(this, "Oops No Internet Connection...", Toast.LENGTH_SHORT).show();
        }
        category_list = getResources().getStringArray(R.array.category_list);
        category = getResources().getStringArray(R.array.category);
        category_images = new int[]{R.drawable.annivarsary,
        R.drawable.attitude,
        R.drawable.bewafa,
        R.drawable.birthday,
        R.drawable.chritsmas,
        R.drawable.cid,
        R.drawable.dasara,
        R.drawable.diwali,
        R.drawable.double_meaning,
        R.drawable.eid,
        R.drawable.exam,
        R.drawable.flirting,
        R.drawable.friendshipday,
        R.drawable.goodmorning,
        R.drawable.goodnight,
        R.drawable.group_admin,
        R.drawable.independanceday,
        R.drawable.jokes,
        R.drawable.love,
        R.drawable.love_story,
        R.drawable.newyear,
        R.drawable.nonveg,
        R.drawable.jokes,
        R.drawable.prapose,
        R.drawable.quotes,
        R.drawable.rajanikant,
        R.drawable.romantic,
        R.drawable.sardar,
        R.drawable.sardar,
        R.drawable.shayari,
        R.drawable.sorrysms,
        R.drawable.study_motivation,
        R.drawable.teachersday,
        R.drawable.valentineday,
        R.drawable.whatsapp_status,
        R.drawable.womanday};
        mylist = new ArrayList();
        for(int i = 0; i<category_list.length; i++){
            mylist.add(new CategoryData(category_list[i],category_images[i],category[i]));
        }
        recyclerView.setAdapter(new CategoryAdapter(this,mylist));
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


   /*
  */
}
