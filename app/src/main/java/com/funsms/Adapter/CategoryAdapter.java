package com.funsms.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.funsms.CategorySmsList;
import com.funsms.MainActivity;
import com.funsms.Model.CategoryData;
import com.funsms.R;

import java.util.ArrayList;

/**
 * Created by AVI on 03-01-2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {
    private ArrayList<CategoryData> category_data;
    private MainActivity mainActivity;
    public CategoryAdapter(MainActivity mainActivity,ArrayList<CategoryData> mylist){
        this.category_data = mylist;
        this.mainActivity = mainActivity;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recycler,parent,false);

        return new MyHolder(view,mainActivity);
    }


    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
       holder.textView.setText(category_data.get(position).getCategory_name());
        holder.imageView.setImageResource(category_data.get(position).getCategory_img());
    }

    @Override
    public int getItemCount() {
        return category_data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;
        ImageView imageView;
        Context ctx;
        public boolean isNetworkAvailable() {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        public MyHolder(View itemView, final Context ctx) {
            super(itemView);
            this.ctx = ctx;
            textView = (TextView)itemView.findViewById(R.id.text_view);
            imageView = (ImageView) itemView.findViewById(R.id.img_view);
            cardView = (CardView)itemView.findViewById(R.id.card_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(isNetworkAvailable()==false){
                    Toast.makeText(ctx, "Oops No Internet Connection...", Toast.LENGTH_SHORT).show();
                    }else {
                    Intent intent = new Intent(ctx, CategorySmsList.class);
                    intent.putExtra("category", category_data.get(position).getCategory());
                    intent.putExtra("lang", "english");
                    ctx.startActivity(intent);
                    }

                }
            });
        }

    }

}
