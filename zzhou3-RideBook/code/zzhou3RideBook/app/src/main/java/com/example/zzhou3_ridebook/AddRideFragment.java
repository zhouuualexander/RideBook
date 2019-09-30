package com.example.zzhou3_ridebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Class AddRideFragment is to make a fragment.
 * Credits: Some code is learned from CMPUT301 lab3 and I talked with student JIAHUI WANG in lab3
 */
public class AddRideFragment extends DialogFragment {
    private EditText rideName;
    private EditText dateName;
    private EditText timeName;
    private EditText distanceName;
    private EditText average_speedName;
    private EditText acirpmName;
    private EditText commentName;

    private OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener {
        void onOkPressed(edit_ride newride,int position);
    }


    public static AddRideFragment newInstance(edit_ride ride, int position) {
        Bundle args = new Bundle();
        args.putSerializable("ride",ride);
        args.putInt("position",position);

        AddRideFragment fragment = new AddRideFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_new_rides, null);
        rideName = view.findViewById(R.id.ride_editText);
        dateName = view.findViewById(R.id.date_editText);
        timeName = view.findViewById(R.id.time_editText);
        distanceName = view.findViewById(R.id.distance_editText);
        average_speedName = view.findViewById(R.id.average_speed_editText);
        acirpmName = view.findViewById(R.id.acirpm_editText);
        commentName = view.findViewById(R.id.comment_editText);

        int position = -1;
        if(getArguments()!=null){
            edit_ride editRide = (edit_ride) getArguments().getSerializable("ride");
            rideName.setText(editRide.getRide());
            dateName.setText(editRide.getDate());
            timeName.setText(editRide.getTime());
            distanceName.setText(String.valueOf(editRide.getDistance()));
            average_speedName.setText(String.valueOf(editRide.getAverage_speed()));
            acirpmName.setText(String.valueOf(editRide.getAcirpm()));
            commentName.setText(editRide.getComment());

            position = getArguments().getInt("position");
        }



        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final int finalPosition = position;
        return builder
                .setView(view)
                .setTitle("Add a new Ride")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String ride = rideName.getText().toString();
                        String date = dateName.getText().toString();
                        String time = timeName.getText().toString();
                        float distance = Float.parseFloat(distanceName.getText().toString());
                        float average_speed = Float.parseFloat(average_speedName.getText().toString());
                        int acirpm = Integer.parseInt(acirpmName.getText().toString());
                        String comment = commentName.getText().toString();

                        listener.onOkPressed(new edit_ride(ride,date,time,distance,average_speed,acirpm,comment), finalPosition);
                    }}).create();
    }
}
