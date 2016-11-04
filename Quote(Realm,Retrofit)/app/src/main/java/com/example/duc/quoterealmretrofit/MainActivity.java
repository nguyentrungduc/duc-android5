package com.example.duc.quoterealmretrofit;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.duc.quoterealmretrofit.fragments.LoginFragment;
import com.example.duc.quoterealmretrofit.fragments.QuoteFragment;
import com.example.duc.quoterealmretrofit.managers.Preferences;
import com.example.duc.quoterealmretrofit.models.FragmentEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        if(Preferences.getInstance().getUserName() == null)
            changeFragment(new LoginFragment(), false, null);
        else
            changeFragment(new QuoteFragment(), false, null);

    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent){
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddtoBackStack(), null);
    }

    public void changeFragment(Fragment fragment, boolean addToBackstack, String tag){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, fragment);
        if(addToBackstack){
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }


}
