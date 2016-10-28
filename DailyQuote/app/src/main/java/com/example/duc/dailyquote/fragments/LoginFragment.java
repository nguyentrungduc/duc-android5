package com.example.duc.dailyquote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.duc.dailyquote.R;
import com.example.duc.dailyquote.manages.Preferences;
import com.example.duc.dailyquote.models.FragmentEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.btn_save)
    Button btsave;
    @BindView(R.id.et_username)
    EditText etUsername;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @OnClick(R.id.btn_save)
    public  void onClick(){
        //get string from et user name
        String username = etUsername.getText().toString();
        // save data to shareprerfenre
        Preferences.getPreferences().putUsername(username);
        //chuyen quote sang fragment
        EventBus.getDefault().post(new FragmentEvent(
                new QuoteFragment(),false
        ));

    }

}
