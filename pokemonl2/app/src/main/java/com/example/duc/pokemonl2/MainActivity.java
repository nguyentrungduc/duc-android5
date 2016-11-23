package com.example.duc.pokemonl2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        DbHelper.init(this);
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
