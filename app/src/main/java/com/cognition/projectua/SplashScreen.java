package com.cognition.projectua;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Methods();
    }


    void Methods()
    {

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                mainPage();

            }

        }, 2000);
    }

    void mainPage()
    {
        Intent i= new Intent(SplashScreen.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
