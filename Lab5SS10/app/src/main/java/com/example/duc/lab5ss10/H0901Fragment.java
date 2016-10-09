package com.example.duc.lab5ss10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class H0901Fragment extends Fragment {


    public H0901Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return inflater.inflate(R.layout.fragment_h0901, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Settings");
        ((MainActivity)getActivity()).showActionBar(true);
        ((MainActivity)getActivity()).showShareMenu(false);
        ((MainActivity)getActivity()).showSendMenu(false);
    }
}
