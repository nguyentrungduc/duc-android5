package com.example.duc.lab4turn1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.toString();

    @BindView(R.id.lv_menu)
    ListView lvMenu;
    private static final String[] menulist = new String[]{
            "0702","0802","0805","0901","0902"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        addListener();
    }

    private void setupUI(){
        //1
        ArrayAdapter<String> studentListAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menulist);
        //2
        lvMenu.setAdapter(studentListAdapter);
    }

    private void addListener(){
       lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position){
                   case 0: {
                       H0702Fragment fragment = new H0702Fragment();
                       FragmentManager fragmentManager = getSupportFragmentManager();
                       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                       fragmentTransaction.replace(R.id.activity_main, fragment);
                       fragmentTransaction.addToBackStack(null);
                       fragmentTransaction.commit();
                       break;

                   }
                   case 1:{
                       H0802Fragment fragment = new H0802Fragment();
                       FragmentManager fragmentManager = getSupportFragmentManager();
                       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                       fragmentTransaction.replace(R.id.activity_main, fragment);
                       fragmentTransaction.addToBackStack(null);
                       fragmentTransaction.commit();
                       break;
                   }
                   case 2:{
                       H0805Fragment fragment = new H0805Fragment();
                       FragmentManager fragmentManager = getSupportFragmentManager();
                       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                       fragmentTransaction.replace(R.id.activity_main, fragment);
                       fragmentTransaction.addToBackStack(null);
                       fragmentTransaction.commit();
                       break;
                   }
                   case 3:{
                       H0901Fragment fragment = new H0901Fragment();
                       FragmentManager fragmentManager = getSupportFragmentManager();
                       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                       fragmentTransaction.replace(R.id.activity_main, fragment);
                       fragmentTransaction.addToBackStack(null);
                       fragmentTransaction.commit();
                       break;
                   }
                   case 4:{
                       H0902Fragment fragment = new H0902Fragment();
                       FragmentManager fragmentManager = getSupportFragmentManager();
                       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                       fragmentTransaction.replace(R.id.activity_main, fragment);
                       fragmentTransaction.addToBackStack(null);
                       fragmentTransaction.commit();
                       break;

                   }
               }

           }
       });
    }


}
