package com.example.directioner.terratechnica;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;

/**
 * Created by Directioner on 2/20/2017.
 */

public class SplashScreen extends AppCompatActivity {

//    private Double aspectX, aspectY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        final WebView webView = (WebView) findViewById(R.id.splash_holder);

        webView.loadUrl("file:///android_asset/splash.gif");
        webView.setInitialScale(getScale());

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


//        webView.setScaleX(aspectX.intValue());
//        webView.setScaleY(aspectY.intValue());

        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.hide();
        }


//        Intent intent = new Intent(SplashScreen.this, MainActivity.class);

    }

    private int getScale(){
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        Double val = new Double(width)/new Double(325);
        val = val * 99d;
//        aspectY = val;
//        int height = display.getHeight();
//        val = new Double(height)/new Double(576);
//        val = val * 100d;
//        aspectX = val;

        return val.intValue();
    }
}