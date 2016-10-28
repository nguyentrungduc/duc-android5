package com.example.duc.dailyquote;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.dailyquote.constants.Constants;
import com.example.duc.dailyquote.fragments.LoginFragment;
import com.example.duc.dailyquote.fragments.QuoteFragment;
import com.example.duc.dailyquote.jsonmodels.QuoteJSONModels;
import com.example.duc.dailyquote.manages.Preferences;
import com.example.duc.dailyquote.models.FragmentEvent;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.duc.dailyquote.constants.Constants.QUOTE_API;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        changeFragment(new LoginFragment(),false);

        SharedPreferences sharedPreferences =
                this.getSharedPreferences("QUOTE", Context.MODE_PRIVATE);
        Log.d(TAG, String.format("user name",
                sharedPreferences.getString("username",null)));
        EventBus.getDefault().register(this);
        if(Preferences.getPreferences().getUsername()==null){
            changeFragment(new LoginFragment(),false);
        }
        else changeFragment(new QuoteFragment(),false);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("user name","hey");
        editor.commit();
        Log.d(TAG,"Done");

    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent){
        changeFragment(fragmentEvent.getFragment(),fragmentEvent.isAddtoBackStack());
    }


    public void changeFragment(Fragment fragment, boolean addtoBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().
                beginTransaction().replace(R.id.fl_container, fragment);
        if(addtoBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

}
