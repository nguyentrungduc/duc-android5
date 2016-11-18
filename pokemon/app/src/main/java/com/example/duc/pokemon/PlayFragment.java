package com.example.duc.pokemon;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {

    @BindView(R.id.tv_Score)
    TextView tvScore;
    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI(){
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/StencilStd.ttf");
        tvScore.setTypeface(tf);
    }

}
