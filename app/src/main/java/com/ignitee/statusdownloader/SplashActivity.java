package com.ignitee.statusdownloader;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView imageIcon;


    // Animation
            Animation animMoveToTop;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        imageIcon = (ImageView) findViewById(R.id.icon);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // load the animation
        animMoveToTop = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        // set animation listener
        animMoveToTop.setAnimationListener(this);

        // button click event

        imageIcon.setVisibility(View.VISIBLE);

        // start the animation

        imageIcon.startAnimation(animMoveToTop);
        try {
            int SPLASH_TIME_OUT = 2000;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);


                    finish();
                }
            }, SPLASH_TIME_OUT);

        } catch (Exception e) {
            Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation
        // check for move animation
        if (animation == animMoveToTop) {
            //  Toast.makeText(getApplicationContext(), "Animation Stopped", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub
    }
}
