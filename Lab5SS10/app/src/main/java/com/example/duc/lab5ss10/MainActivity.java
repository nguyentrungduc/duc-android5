package com.example.duc.lab5ss10;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.duc.lab5ss10.R.style.AppTheme;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private boolean menuSendVisible;
    private boolean menuShareVisible;
    public boolean changeTogglee;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    //    setTitle("Lab5");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//        if(changeTogglee) {
//            toggle.setDrawerIndicatorEnabled(false);
//            toggle.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24px);
//            toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (drawer.isDrawerOpen(GravityCompat.START)) {
//                        drawer.closeDrawer(GravityCompat.START);
//                    } else drawer.openDrawer(GravityCompat.START);
//                }
//            });
//        }
        changeTg(changeTogglee);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        showActionBar(true);
        setTitle("Lab 5");
        showShareMenu(false);
        showSendMenu(false);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean r = super.onPrepareOptionsMenu(menu);
        MenuItem sendMenuItem = menu.findItem(R.id.action_send);
        MenuItem shareMenuItem = menu.findItem(R.id.action_share);
        sendMenuItem.setVisible(menuSendVisible);
        shareMenuItem.setVisible(menuShareVisible);
        return r;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_send){
            changeFragment(new H0805Fragment(),true);
        }

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();

        if(id == R.id.nav_article){
            changeFragment(new H0702Fragment(),true);
        }
        if(id == R.id.nav_pay){
            changeFragment(new H0802Fragment(),true);
        }
        if(id == R.id.nav_settings){
            changeFragment(new H0901Fragment(),true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(Fragment fragment, boolean addtoBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fl_home, fragment);
        if(addtoBackStack){
            fragmentTransaction.addToBackStack("hihi");
        }
        fragmentTransaction.commit();
    }

    public void showActionBar(boolean visible){
        ActionBar actionBar = getSupportActionBar();
        if(visible) {
            actionBar.show();
        }
        else
            actionBar.hide();
    }

    public void showSendMenu(boolean visible){
        this.menuSendVisible = visible;
        this.invalidateOptionsMenu();
    }

    public void showShareMenu(boolean visible){
        this.menuShareVisible = visible;
        this.invalidateOptionsMenu();
    }

    public void changeTg(boolean changeT){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        if(changeT){
            toggle.setDrawerIndicatorEnabled(false);
            toggle.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24px);
            toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawer(GravityCompat.START);
                    }
                    else drawer.openDrawer(GravityCompat.START);
                }
            });
        }
    }


}
