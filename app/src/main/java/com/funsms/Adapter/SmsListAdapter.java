package com.funsms.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.funsms.DetailsActivity;
import com.funsms.Model.Data;
import com.funsms.R;

import java.util.ArrayList;

/**
 * Created by AVI on 05-01-2018.
 */

public class SmsListAdapter extends RecyclerView.Adapter<SmsListAdapter.MyHolder> {
  private ArrayList<Data> mysmsdata;
    private Context ctx;

    public SmsListAdapter(Context ctx, ArrayList<Data> mysmslist) {
        this.mysmsdata = mysmslist;
        this.ctx = ctx;
    }

    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sms_list, parent, false);

        return new SmsListAdapter.MyHolder(view, ctx);
    }


    @Override
    public void onBindViewHolder(SmsListAdapter.MyHolder holder, int position) {
        holder.textView.setText(mysmsdata.get(position).getTextsms());
    }

    @Override
    public int getItemCount() {
        return mysmsdata.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Context ctx;
        Fragment fragment;
        public MyHolder(final View itemView, final Context ctx) {
            super(itemView);
            this.ctx = ctx;
            textView = (TextView) itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent= new Intent(ctx, DetailsActivity.class);
                    intent.putExtra("mysmsdata",mysmsdata);
                    intent.putExtra("position",position);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(intent);

                }
            });
        }

    }

}