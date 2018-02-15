package com.funsms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.funsms.Model.Data;
import com.funsms.Views.CardPagerAdapter;
import com.funsms.Views.ShadowTransformer;

import java.util.ArrayList;

/**
 * Created by AVI on 15-01-2018.
 */

public class DetailsActivity extends AppCompatActivity{
    private FragmentManager fragmentManager;
    private FragmentTransaction ft;
    private ArrayList<Data> datas;
    private int position;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        fragmentManager = getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();


        datas = (ArrayList<Data>)getIntent().getSerializableExtra("mysmsdata");
        position = getIntent().getIntExtra("position",1);

        for(int i=0;i<datas.size();i++)
        mCardAdapter.addCardItem(datas.get(i),position);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mysmslist",datas);
        bundle.putInt("position",position);

       /* DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);
        ft.replace(R.id.fragment,detailsFragment);
        ft.commit();
*/

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter,position);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setCurrentItem(position);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
