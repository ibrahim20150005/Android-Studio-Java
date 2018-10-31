package com.example.hima.historicalplace;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter {

    final static String FILE_NAME = "file.text";
    public ArrayList<Places> placesArrayList;
    public Context contextAdapter;

    public  RecycleViewAdapter (Context context,ArrayList<Places> places)
    {
        this.contextAdapter= context;
        this.placesArrayList= places;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name,rate;
        Button btRate;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textview2);
            rate = itemView.findViewById(R.id.Rate);
            btRate = itemView.findViewById(R.id.btRate);
        }

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contextAdapter).inflate(R.layout.row_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).image.setBackgroundResource(placesArrayList.get(position).getImage());
        ((ViewHolder)holder).name.setText(placesArrayList.get(position).getName());
        ((ViewHolder)holder).rate.setText(""+placesArrayList.get(position).getRate());
        ((ViewHolder)holder).btRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placesArrayList.get(position).setRate(placesArrayList.get(position).getRate()+1);
                ((ViewHolder) holder).rate.setText(""+placesArrayList.get(position).getRate());
                SharedPreferences preferences = contextAdapter.getSharedPreferences(FILE_NAME,0);
                preferences.edit().putInt(""+position,placesArrayList.get(position).getRate()).apply();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(contextAdapter, Details.class);
                ((ViewHolder)holder).image.setDrawingCacheEnabled(true);
                Bitmap b=((ViewHolder)holder).image.getDrawingCache();
                intent.putExtra("image", b);
                intent.putExtra("country", placesArrayList.get(position).getCountry());
                intent.putExtra("description", placesArrayList.get(position).getDescription());
                contextAdapter.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return placesArrayList.size();
    }
}
