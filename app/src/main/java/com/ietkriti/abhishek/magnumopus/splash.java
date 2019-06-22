package com.ietkriti.abhishek.magnumopus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by abhishek on 15-08-2016.
 */
public class splash extends Activity {

    Animation fadein, move;
    ImageView i1, i2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        i1 = (ImageView) findViewById(R.id.imageView20);
        i2 = (ImageView) findViewById(R.id.imageView21);
        fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        i1.startAnimation(move);
        i2.startAnimation(fadein);
        int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(splash.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}
