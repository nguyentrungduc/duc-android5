package com.example.duc.pokemon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        changeFragment(new MenuFragment(),true);
    }

    public void changeFragment(Fragment fragment, boolean addtoBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().
                beginTransaction().replace(R.id.fl_container, fragment);
        if(addtoBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Subscribe
    public void onEvent(Fragment fragment){
        changeFragment(fragment,true);
    }

}
