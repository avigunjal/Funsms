package com.funsms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.funsms.Model.Data;

import java.util.ArrayList;

/**
 * Created by AVI on 25-12-2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context ctx;
    ArrayList<Data> datas;
    CustomAdapter(Context ctx, ArrayList<Data> datas){
        this.ctx = ctx;
        this.datas = datas;

    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v =inflater.inflate(R.layout.custom,null);

        TextView tv = (TextView)v.findViewById(R.id.text_view);
        tv.setText(datas.get(position).getTextsms());

        return v;
    }
}
