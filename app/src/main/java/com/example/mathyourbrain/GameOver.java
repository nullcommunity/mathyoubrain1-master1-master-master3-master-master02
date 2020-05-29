package com.example.mathyourbrain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameOver extends AppCompatActivity {

    ImageView result;

    Intent intent;

    Button buttonHome, buttonNextLevel, buttonPlayAgain;

    ConstraintLayout constraintLayout;

    public void back(View view) {
        Intent goToHome = new Intent(GameOver.this, HomeActivity.class);
        finish();
        if(LevelsActivity.levelsActivity != null) {
            LevelsActivity.levelsActivity.finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void nextLevel(View view) {

        int nextLvl = intent.getIntExtra("Next Level", 1);

        Intent goToNextLevel;

        if(nextLvl == 0) {

            buttonNextLevel.setVisibility(View.INVISIBLE);

        }

        if(nextLvl == 2) {

            goToNextLevel = new Intent(getApplicationContext(), randomLevel.class);
            goToNextLevel.putExtra("Button", "2");
            LevelsActivity.level = 2;
            startActivity(goToNextLevel);
            finish();

        }

        if(nextLvl == 3) {

            goToNextLevel = new Intent(getApplicationContext(), randomLevel.class);
            goToNextLevel.putExtra("Button", "3");
            LevelsActivity.level = 3;
            startActivity(goToNextLevel);
            finish();

        }

        if(nextLvl == 4) {

            goToNextLevel = new Intent(getApplicationContext(), randomLevel.class);
            goToNextLevel.putExtra("Button", "4");
            LevelsActivity.level = 4;
            startActivity(goToNextLevel);
            finish();

        }

        if(nextLvl == 5) {

            goToNextLevel = new Intent(getApplicationContext(), level5.class);
            startActivity(goToNextLevel);
            finish();

        }

        if(nextLvl == 6) {

            goToNextLevel = new Intent(getApplicationContext(), Level6Activity.class);
            startActivity(goToNextLevel);
            finish();

        }

        if(nextLvl == 7) {

            goToNextLevel = new Intent(getApplicationContext(), Level7Activity.class);
            startActivity(goToNextLevel);
            finish();

        }

        if(nextLvl == 8) {

            goToNextLevel = new Intent(getApplicationContext(), Level8Activity.class);
            startActivity(goToNextLevel);
            finish();

        }

        if(nextLvl == 9) {

            goToNextLevel = new Intent(getApplicationContext(), Level9Activity.class);
            startActivity(goToNextLevel);
            finish();

        }

        if(nextLvl == 10) {

            goToNextLevel = new Intent(getApplicationContext(), Level10Activity.class);
            startActivity(goToNextLevel);
            finish();

        }

    }

    public void playAgain(View view) {

        Intent goToCurrentLevel;

        int currentLevel = intent.getIntExtra("Current Level", 1);

        if(currentLevel == 1) {

            goToCurrentLevel = new Intent(getApplicationContext(), randomLevel.class);
            goToCurrentLevel.putExtra("Button", "1");
            LevelsActivity.level = 1;
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 2) {

            goToCurrentLevel = new Intent(getApplicationContext(), randomLevel.class);
            goToCurrentLevel.putExtra("Button", "2");
            LevelsActivity.level = 2;
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 3) {

            goToCurrentLevel = new Intent(getApplicationContext(), randomLevel.class);
            goToCurrentLevel.putExtra("Button", "3");
            LevelsActivity.level = 3;
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 4) {

            goToCurrentLevel = new Intent(getApplicationContext(), randomLevel.class);
            goToCurrentLevel.putExtra("Button", "4");
            LevelsActivity.level = 4;
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 5) {

            goToCurrentLevel = new Intent(getApplicationContext(), level5.class);
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 6) {

            goToCurrentLevel = new Intent(getApplicationContext(), Level6Activity.class);
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 7) {

            goToCurrentLevel = new Intent(getApplicationContext(), Level7Activity.class);
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 8) {

            goToCurrentLevel = new Intent(getApplicationContext(), Level8Activity.class);
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 9) {

            goToCurrentLevel = new Intent(getApplicationContext(), Level9Activity.class);
            startActivity(goToCurrentLevel);
            finish();

        }

        if(currentLevel == 10) {

            goToCurrentLevel = new Intent(getApplicationContext(), Level10Activity.class);
            startActivity(goToCurrentLevel);
            finish();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        buttonHome = (Button) findViewById(R.id.buttonHome);
        buttonNextLevel = (Button) findViewById(R.id.buttonNextLevel);
        buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        intent = getIntent();

        int nextLvl = intent.getIntExtra("Next Level", 1);

        if(nextLvl == 0) {

            buttonNextLevel.setVisibility(View.INVISIBLE);

        }

        Boolean userWon = intent.getBooleanExtra("User Won" , false);
        result = (ImageView) findViewById(R.id.result);
        if(userWon==true)
        {
            result.setImageDrawable(getResources().getDrawable(R.drawable.youwin));
            buttonNextLevel.setAlpha(1f);
            buttonNextLevel.setClickable(true);
        }
        else
        {
            result.setImageDrawable(getResources().getDrawable(R.drawable.youlose));
            buttonNextLevel.setClickable(false);
            buttonNextLevel.setAlpha(0.5f);
            Log.i("Game Over", "else entered");
        }

        boolean timeUp = intent.getBooleanExtra("Time Up", false);

        if(timeUp == true) {

            result.setImageDrawable(getResources().getDrawable(R.drawable.youareslow));
            buttonNextLevel.setClickable(false);
            buttonNextLevel.setAlpha(0.5f);

        }

    }
}
