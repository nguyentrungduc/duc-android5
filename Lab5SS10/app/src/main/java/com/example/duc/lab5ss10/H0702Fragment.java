package com.example.duc.lab5ss10;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class H0702Fragment extends Fragment {



    public H0702Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_h0702, container, false);
        ButterKnife.bind(this,view);
      // ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Article");
        ((MainActivity)getActivity()).showShareMenu(true);
        ((MainActivity)getActivity()).showActionBar(true);
        ((MainActivity)getActivity()).showSendMenu(false);
    }

}
