package com.example.mathyourbrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    boolean onActivityPaused = false, onTimerFinished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        onActivityPaused = false;
        onTimerFinished = false;

        new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Nothing to be done here
            }

            @Override
            public void onFinish() {

                onTimerFinished = true;

                // From here HomeActivity will be called
                if(onActivityPaused == false && onTimerFinished ==  true) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }.start();

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("Paused", "User Tapped Home");
        onActivityPaused = true;

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Resumed", "User opened app");
        if(onActivityPaused == true && onTimerFinished ==  true) {

            onActivityPaused = false;

            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }

}
