package com.example.duc.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private View vItem;
    private Button btn;
    private int height;
    private int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
         height = displaymetrics.heightPixels;
         width = displaymetrics.widthPixels;

        vItem = findViewById(R.id.v_item);
        btn = (Button) findViewById(R.id.btn);
        addListener();


//        getSupportFragmentManager()
//                .beginTransaction().setCustomAnimations(R.anim.enter,R.anim.out)
//                .replace(R.id.fl_container,new InFragment())
//                .commit();
    }

    private void addListener(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mix();


            }
        });

    }

    private void mix(){
        Animation scale = AnimationUtils.loadAnimation(this,R.anim.scale);
        int[] coords = {0,0};
        vItem.getLocationOnScreen(coords);
        int y = coords[1];

        //to top of screen
        TranslateAnimation toTop = new TranslateAnimation(0, 0, 0, -y + vItem.getHeight()/2);
        AnimationSet mix = new AnimationSet(true);
        mix.addAnimation(scale);
        mix.addAnimation(toTop);
        mix.setFillAfter(true);
        mix.setDuration(1000);

        vItem.startAnimation(mix);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.actionbar_menu, menu);
        menu.findItem(R.id.mni_animate).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG," onMenuItemClick");
                //translate();
               // tranlatebyxml();
                //rotate();
               // rotatebyxml();
                //scaleView();
                //alpha();
                //alphabyxlm();
               // sclalebyxml();
                //mixbyxml();
               // mixbyxml();
               // tralatetotop();
                getSupportFragmentManager()
                        .beginTransaction().setCustomAnimations(R.anim.enter,R.anim.out)
                        .replace(R.id.fl_container,new OutFragment())
                        .commit();
                return false;
            }
        });
        return true;
    }

    void mixbyxml(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.mixanimation);
        vItem.startAnimation(animation);
    }

    void translate(){
        // 1 create animation
        TranslateAnimation traslateAnimation = new TranslateAnimation(
                0, 0,
                0, -0.5f + vItem.getHeight() // Y

        );

        traslateAnimation.setDuration(300);

        traslateAnimation.setFillAfter(true);

        traslateAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(traslateAnimation);

        //2 animate
    }

    public void sclalebyxml(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        vItem.startAnimation(animation);
    }

    public void scaleView() {
        Animation anim = new ScaleAnimation(
                1, 5, // Start and end values for the X axis scaling
                1, 5, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(500);
        vItem.startAnimation(anim);
    }

    public void alpha(){
        Animation alpha= new AlphaAnimation(1, 0);
        alpha.setDuration(300);
        alpha.setFillAfter(true);
        vItem.startAnimation(alpha);

    }

    public void alphabyxlm(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        vItem.startAnimation(animation);
    }

    void tranlatebyxml(){
        //1 load animatio nfrom xml
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.move_to_right);
        vItem.startAnimation(animation);

    }


    void rotatebyxml(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        vItem.startAnimation(animation);
    }

    void rotate(){
        //1 create animation
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(rotateAnimation);
        //2 animate
    }



    void tralatetotop(){
        int[] coords = {0,0};
        vItem.getLocationOnScreen(coords);
        int y = coords[1];

//to top of screen
        TranslateAnimation toTop = new TranslateAnimation(0, 0, 0, -y + vItem.getHeight()/2);
        toTop.setDuration(700);
        toTop.setFillAfter(true);
        vItem.startAnimation(toTop);


    }
}
