package com.example.hima.earthquake;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hima.earthquake.DataFeature.Properties;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.security.AccessController.getContext;

public class AdapterForRecycleView extends RecyclerView.Adapter<AdapterForRecycleView.ViewHolder> {


    Context contextAdapter;
    ArrayList<Properties> propertiesArrayList;

    public  AdapterForRecycleView(Context context,ArrayList<Properties> properties)
    {
        this.contextAdapter=context;
        this.propertiesArrayList=properties;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contextAdapter).inflate(R.layout.row_in_list,parent,false);
        return new ViewHolder(v);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Properties propertiess = propertiesArrayList.get(position);
        String string = propertiess.getLocation();
        String[] parts = string.split("of");
        holder.location_offset.setText(parts[0]+" of");
        if (parts.length==2)
        {
            holder.primary_location.setText(parts[1]);
        }
        holder.date.setText(formatDate(propertiess.getTimeInMilliseconds()));
        holder.time.setText(formatTime(propertiess.getTimeInMilliseconds()));
        holder.magnitude.setText(formatMagnitude(propertiess.getMagnitude()));
        holder.magnitude.setBackgroundColor(getMagnitudeColor(propertiess.getMagnitude()));
    }

    @Override
    public int getItemCount() {
        return propertiesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView magnitude,location_offset,primary_location,date,time;
        public ViewHolder(View itemView) {
            super(itemView);
            magnitude = itemView.findViewById(R.id.magnitude);
            location_offset = itemView.findViewById(R.id.location_offset);
            primary_location = itemView.findViewById(R.id.primary_location);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }
    private String formatTime(Long dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatDate(Long dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd LLL, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.M)
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.colorPrimaryDark;
        }
        return contextAdapter.getColor(magnitudeColorResourceId);
    }
}
