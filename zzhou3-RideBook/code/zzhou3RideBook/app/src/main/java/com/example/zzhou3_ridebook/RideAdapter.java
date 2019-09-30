package com.example.zzhou3_ridebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Class RideAdapter is a user-defined Arrayadapter to make the Arrayadapter personalized
 */
public class RideAdapter extends ArrayAdapter<edit_ride> {

    private static final String TAG = "RideAdapter";
    private ArrayList<edit_ride> rides;
    private Context context;

    public RideAdapter(Context context,ArrayList<edit_ride> rides) {
        super(context, 0, rides);
        this.rides = rides;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_of_rides,parent,false);
        }
        edit_ride ride = rides.get(position);

        TextView rideName = view.findViewById(R.id.textView);
        TextView dateName = view.findViewById(R.id.date);
        TextView timeName = view.findViewById(R.id.time);
        TextView distanceName = view.findViewById(R.id.distance);
        TextView average_speedName = view.findViewById(R.id.aver);
        TextView acirpmName = view.findViewById(R.id.average);
        TextView commentName = view.findViewById(R.id.comment);
        rideName.setText(ride.getRide());
        dateName.setText(ride.getDate());
        timeName.setText(ride.getTime());
        distanceName.setText(String.valueOf(ride.getDistance()));
        average_speedName.setText(String.valueOf(ride.getAverage_speed()));
        acirpmName.setText(String.valueOf(ride.getAcirpm()));
        commentName.setText(ride.getComment());
        return view;



    }
}
