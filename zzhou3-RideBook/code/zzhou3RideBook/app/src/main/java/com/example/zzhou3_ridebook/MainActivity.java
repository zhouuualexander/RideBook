package com.example.zzhou3_ridebook;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/**
 * Class MainActitvity is to manage the MainActivity in android app
 * I learned some code function from Youtuber CodingWithMitch and the url is below:
 * https://www.youtube.com/watch?v=4NDwINudmDk&list=PLgCYzUzKIBE8TUoCyjomGFqzTFcJ05OaC
 */
public class MainActivity extends AppCompatActivity implements AddRideFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    ListView List;
    private TextView total1;
    ArrayAdapter<edit_ride> RideAdapter;
    ArrayList<edit_ride> rideDataList;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView theTextView = findViewById(R.id.Welcome);
        theTextView.setText("Welcome to use RideBook");
        Log.d(TAG,"onCreate:Started.");
        List = findViewById(R.id.list_of_rides);
        String []rides = {};
        String []dates = {};
        String []times = {};
        float []distances ={} ;
        float []average_speeds = {};
        int []acirmps = {};
        String []comments = {};
        rideDataList = new ArrayList<>();
        for (int i = 0; i < rides.length; i++) {
            rideDataList.add((new edit_ride(rides[i], dates[i],times[i],distances[i],average_speeds[i],acirmps[i],comments[i])));
        }
        RideAdapter = new RideAdapter(this,rideDataList);
        List.setAdapter(RideAdapter);
        final FloatingActionButton add_rides_button = findViewById(R.id.add_rides_button);
        add_rides_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddRideFragment().show(getSupportFragmentManager(),"ADD_RIDES");
            }
        });
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AddRideFragment.newInstance((edit_ride) List.getItemAtPosition(i),i).show(getSupportFragmentManager(),"EDIT_RIDES");
            }
        });
        List.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                RideAdapter.remove((edit_ride) List.getItemAtPosition(i));
                RideAdapter.notifyDataSetChanged();
                float total_del = 0;
                for(int j = 0;j<rideDataList.size();j++){
                    edit_ride dis = rideDataList.get(j);
                    total_del = dis.getDistance()+total_del;
                }
                total1.setText("The total distance is: "+total_del);
                return false;
            }
        });
        ImageView bicycle = findViewById(R.id.firstImage);
        int imageResource = getResources().getIdentifier("@drawable/bicycle",null,this.getPackageName());
        bicycle.setImageResource(imageResource);
        bicycle.setContentDescription("This is my app's logo");
        total1 = findViewById(R.id.total);
        float total_default = 0;
        for(int j = 0;j<rideDataList.size();j++){
            edit_ride dis = rideDataList.get(j);
            total_default = dis.getDistance()+total_default;
        }
        total1.setText("The total distance is: "+total_default);
    }
    public void onOkPressed(edit_ride newRide, int position) {
        if(position == -1){
            RideAdapter.add(newRide);
            RideAdapter.notifyDataSetChanged();
        }
        else{
            rideDataList.set(position,newRide);
            RideAdapter.notifyDataSetChanged();
            }
        float total = 0;
        for(int i = 0;i<rideDataList.size();i++){
            edit_ride dis = rideDataList.get(i);
            total = dis.getDistance()+total;
        }
        total1.setText("The total distance is: "+total);
        Log.d(TAG, "onOkPressed: "+ total);
    }

}
