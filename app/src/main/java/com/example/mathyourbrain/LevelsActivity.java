package com.example.mathyourbrain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*
   Level 1 se 4 tak mein upar  kaa naam likh dena
   TextView maine laga diya hai
 */
public class LevelsActivity extends AppCompatActivity {
    Intent intent;
    static int level = 0;
    static Activity levelsActivity;
    Button buttonlvl1,buttonlvl2,buttonlvl3,buttonlvl4,buttonlvl5,buttonlvl6,buttonlvl7,buttonlvl8,buttonlvl9,buttonlvl10;

    boolean isButtonClicked = false;

    public void checkLevelState() {

        if(HomeActivity.sharedPreferences.getBoolean("level 2 state", false) == false) {
            buttonlvl2.setAlpha(0.5f);
            buttonlvl2.setEnabled(false);
        } else {
            buttonlvl2.setAlpha(1f);
            buttonlvl2.setEnabled(true);
        }
        if(HomeActivity.sharedPreferences.getBoolean("level 3 state", false) == false) {
            buttonlvl3.setAlpha(0.5f);
            buttonlvl3.setEnabled(false);
        } else {
            buttonlvl3.setAlpha(1f);
            buttonlvl3.setEnabled(true);
        }
        if(HomeActivity.sharedPreferences.getBoolean("level 4 state", false) == false) {
            buttonlvl4.setAlpha(0.5f);
            buttonlvl4.setEnabled(false);
        } else {
            buttonlvl4.setAlpha(1f);
            buttonlvl4.setEnabled(true);
        }
        if(HomeActivity.sharedPreferences.getBoolean("level 5 state", false) == false) {
            buttonlvl5.setAlpha(0.5f);
            buttonlvl5.setEnabled(false);
        } else {
            buttonlvl5.setAlpha(1f);
            buttonlvl5.setEnabled(true);
        }
        if(HomeActivity.sharedPreferences.getBoolean("level 6 state", false) == false) {
            buttonlvl6.setAlpha(0.5f);
            buttonlvl6.setEnabled(false);
        } else {
            buttonlvl6.setAlpha(1f);
            buttonlvl6.setEnabled(true);
        }
        if(HomeActivity.sharedPreferences.getBoolean("level 7 state", false) == false) {
            buttonlvl7.setAlpha(0.5f);
            buttonlvl7.setEnabled(false);
        } else {
            buttonlvl7.setAlpha(1f);
            buttonlvl7.setEnabled(true);
        }
        if(HomeActivity.sharedPreferences.getBoolean("level 8 state", false) == false) {
            buttonlvl8.setAlpha(0.5f);
            buttonlvl8.setEnabled(false);
        } else {
            buttonlvl8.setAlpha(1f);
            buttonlvl8.setEnabled(true);
        }
        if(HomeActivity.sharedPreferences.getBoolean("level 9 state", false) == false) {
            buttonlvl9.setAlpha(0.5f);
            buttonlvl9.setEnabled(false);
        } else {
            buttonlvl9.setAlpha(1f);
            buttonlvl9.setEnabled(true);
        }
        if(HomeActivity.sharedPreferences.getBoolean("level 10 state", false) == false) {
            buttonlvl10.setAlpha(0.5f);
            buttonlvl10.setEnabled(false);
        } else {
            buttonlvl10.setAlpha(1f);
            buttonlvl10.setEnabled(true);
        }

    }

    public void enter(View view) {

        if (isButtonClicked == false) {

            isButtonClicked = true;

            String levelTapped = ((Button) view).getTag().toString();
            System.out.println("Level Tapped : " + levelTapped);
            if (levelTapped.equals("1") || levelTapped.equals("2") || levelTapped.equals("3") || levelTapped.equals("4")) {
                intent = new Intent(LevelsActivity.this, randomLevel.class);
            }
            if (levelTapped.equals("5")) {
                intent = new Intent(LevelsActivity.this, level5.class);
            }
            if (levelTapped.equals("6")) {
                intent = new Intent(LevelsActivity.this, Level6Activity.class);
            }
            if (levelTapped.equals("7")) {
                intent = new Intent(LevelsActivity.this, Level7Activity.class);
            }
            if (levelTapped.equals("8")) {
                intent = new Intent(LevelsActivity.this, Level8Activity.class);
            }
            if (levelTapped.equals("9")) {
                intent = new Intent(LevelsActivity.this, Level9Activity.class);
            }
            if (levelTapped.equals("10")) {
                intent = new Intent(LevelsActivity.this, Level10Activity.class);
            }
            intent.putExtra("Button", ((Button) view).getTag().toString());
            level = Integer.parseInt(((Button) view).getTag().toString());
            startActivity(intent);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        levelsActivity = LevelsActivity.this;

        buttonlvl1 = (Button) findViewById(R.id.buttonlvl1);
        buttonlvl2 = (Button) findViewById(R.id.buttonlvl2);
        buttonlvl3 = (Button) findViewById(R.id.buttonlvl3);
        buttonlvl4 = (Button) findViewById(R.id.buttonlvl4);
        buttonlvl5 = (Button) findViewById(R.id.buttonlvl5);
        buttonlvl6 = (Button) findViewById(R.id.buttonlvl6);
        buttonlvl7 = (Button) findViewById(R.id.buttonlvl7);
        buttonlvl8 = (Button) findViewById(R.id.buttonlvl8);
        buttonlvl9 = (Button) findViewById(R.id.buttonlvl9);
        buttonlvl10 = (Button) findViewById(R.id.buttonlvl10);

        isButtonClicked = false;

        checkLevelState();

    }

    @Override
    protected void onResume() {
        super.onResume();

        isButtonClicked = false;

        checkLevelState();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();

    }
}
