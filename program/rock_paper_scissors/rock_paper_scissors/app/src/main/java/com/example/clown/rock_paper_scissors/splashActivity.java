package com.example.clown.rock_paper_scissors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;


public class splashActivity extends Activity{
    private final  int SPLASH_DISPLAY_LENGHT = 3000;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashActivity.this,MainActivity.class);
                startActivity(intent);
                splashActivity.this.finish();
            }
        },SPLASH_DISPLAY_LENGHT);

    }
}
