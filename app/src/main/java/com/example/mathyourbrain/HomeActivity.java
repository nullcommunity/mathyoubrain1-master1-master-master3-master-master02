package com.example.mathyourbrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    Button buttonPlay,buttonLevels,buttonFacts;

    static SharedPreferences sharedPreferences;

    int activeLevel = 1;

    boolean exit = false;

    Dialog dialog;
    Button HomeExitYes , HomeExitNo;

    static ImageView imageViewBox;

    boolean isGameComplete = false;

    boolean isPlayClicked = false, isLevelsClicked = false, isFactsClicked = false;

    public void startGame(View view) {

        if(isPlayClicked == false) {

            isPlayClicked = true;

            activeLevel = sharedPreferences.getInt("active level", 1);

            if (activeLevel == 1) {
                Intent intent = new Intent(getApplicationContext(), randomLevel.class);
                intent.putExtra("Button", "1");
                LevelsActivity.level = 1;
                startActivity(intent);
            }
            if (activeLevel == 2) {
                Intent intent = new Intent(getApplicationContext(), randomLevel.class);
                intent.putExtra("Button", "2");
                LevelsActivity.level = 2;
                startActivity(intent);
            }
            if (activeLevel == 3) {
                Intent intent = new Intent(getApplicationContext(), randomLevel.class);
                intent.putExtra("Button", "3");
                LevelsActivity.level = 3;
                startActivity(intent);
            }
            if (activeLevel == 4) {
                Intent intent = new Intent(getApplicationContext(), randomLevel.class);
                intent.putExtra("Button", "4");
                LevelsActivity.level = 4;
                startActivity(intent);
            }
            if (activeLevel == 5) {
                Intent intent = new Intent(getApplicationContext(), level5.class);
                intent.putExtra("Button", "5");
                LevelsActivity.level = 5;
                startActivity(intent);
            }
            if (activeLevel == 6) {
                Intent intent = new Intent(getApplicationContext(), Level6Activity.class);
                startActivity(intent);
            }
            if (activeLevel == 7) {
                Intent intent = new Intent(getApplicationContext(), Level7Activity.class);
                startActivity(intent);
            }
            if (activeLevel == 8) {
                Intent intent = new Intent(getApplicationContext(), Level8Activity.class);
                startActivity(intent);
            }
            if (activeLevel == 9) {
                Intent intent = new Intent(getApplicationContext(), Level9Activity.class);
                startActivity(intent);
            }
            if (activeLevel == 10) {
                Intent intent = new Intent(getApplicationContext(), Level10Activity.class);
                startActivity(intent);
            }

        }

    }

    public void goToLevels(View view) {

        if(isLevelsClicked == false) {

            isLevelsClicked = true;

            Intent intent = new Intent(getApplicationContext(), LevelsActivity.class);
            startActivity(intent);

        }

    }

    public void goToFacts(View view) {

        activeLevel = sharedPreferences.getInt("active level", 1);

        if (isFactsClicked == false && activeLevel >= 3) {

            isFactsClicked = true;

            Intent intent = new Intent(getApplicationContext(), FactsActivity.class);
            startActivity(intent);

        } else if (activeLevel < 3) {

            Toast.makeText(this, "Complete Level 2 to Unlock Facts", Toast.LENGTH_SHORT).show();

        }

    }

    public void sendNotification() {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.applogo)
                .setContentTitle("Are you daring enough to play this game, LOSER")
                .setContentText("If you are, open the app to play!");
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001,mBuilder.build());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonLevels = (Button) findViewById(R.id.buttonLevels);
        buttonFacts = (Button) findViewById(R.id.buttonFacts);

        imageViewBox = (ImageView) findViewById(R.id.imageView3);

        exit = false;

        isPlayClicked = false;
        isLevelsClicked = false;
        isFactsClicked = false;

        sharedPreferences = HomeActivity.this.getSharedPreferences("com.example.mathyourbrain", Context.MODE_PRIVATE);

        activeLevel = sharedPreferences.getInt("active level", 1);

        dialog = new Dialog(this);

        isGameComplete = sharedPreferences.getBoolean("is game complete", false);

        if(isGameComplete == true) {

            imageViewBox.setImageResource(R.drawable.congratsbox);

        } else {

            imageViewBox.setImageResource(R.drawable.warningbox);

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        isPlayClicked = false;
        isLevelsClicked = false;
        isFactsClicked = false;

        isGameComplete = sharedPreferences.getBoolean("is game complete", false);

        if(isGameComplete == true) {

            imageViewBox.setImageResource(R.drawable.congratsbox);

        } else {

            imageViewBox.setImageResource(R.drawable.warningbox);

        }

    }

    @Override
    public void onBackPressed() {

        dialog.setContentView(R.layout.home_exit);
        HomeExitYes  = (Button) dialog.findViewById(R.id.yes);
        HomeExitNo = (Button) dialog.findViewById(R.id.no);
        HomeExitYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               exit = true;
               onBackPressed();
            }
        });
        HomeExitNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit = false;
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        if(exit == true) {
            super.onBackPressed();
        }

    }
}
