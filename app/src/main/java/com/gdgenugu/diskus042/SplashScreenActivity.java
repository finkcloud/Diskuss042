package com.gdgenugu.diskus042;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 8000;
    TextView leadTv,logo;
    Animation translate_to_center;
    Animation fadeout;
    Animation fadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo = (TextView) findViewById(R.id.textViewHey);
        leadTv = (TextView) findViewById(R.id.tvintro);

       // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        translate_to_center = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
        logo.startAnimation(translate_to_center);

        fadeout = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        leadTv.startAnimation(fadeout);

        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        leadTv.startAnimation(fadein);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
