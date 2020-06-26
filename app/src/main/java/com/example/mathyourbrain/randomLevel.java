package com.example.mathyourbrain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class randomLevel extends AppCompatActivity {
    static Button firstOption, secondOption, thirdOption, fourthOption, go, restart;
    static TextView timerText, QuestionText, textViewLevel;
    static int totalTimesPlayed = 1;
    static Boolean play = true;
    static String levelOfQuestion; // setting up the level of question to be asked.;
    AnimatorSet front_anim;
    AnimatorSet back_anim;
    ImageView flipbtn;
    Boolean isFront = true;
    TextView userScore;
    static int won = 0;
    static Boolean userWon;
    int total;
    static Intent intent;
    CountDownTimer timer;
    ImageView imageViewResult;

    static boolean onActivityPaused = false;

    static boolean onTimerFinished = false;

    boolean exit = false;

    Dialog dialog;
    Button levelExitYes, levelExitNo;

    public void play(View view) {
        if (play) {

            if (!math.answer.toString().isEmpty()) {
                if (((Button) view).getText().toString().equals(math.answer.toString())) {

                    imageViewResult.setImageResource(R.drawable.correctanswer);

                    won++;
                    userScore.setText(won + "/" + total);
                } else {

                    imageViewResult.setImageResource(R.drawable.wronganswer);

                }
            }
            math.askQuestionandGiveOptions();

            totalTimesPlayed++;
            System.out.println("totalTimesPlayed : " + totalTimesPlayed);
            if (totalTimesPlayed > total) {
                play = false;
                if (won == total) {
                    userWon = true;
                    if ((LevelsActivity.level + 1) == 2) {
                        if (HomeActivity.sharedPreferences.getInt("active level", 1) < (LevelsActivity.level + 1))
                            HomeActivity.sharedPreferences.edit().putInt("active level", 2).apply();
                        HomeActivity.sharedPreferences.edit().putBoolean("level 2 state", true).apply();
                    }
                    if ((LevelsActivity.level + 1) == 3) {
                        if (HomeActivity.sharedPreferences.getInt("active level", 1) < (LevelsActivity.level + 1))
                            HomeActivity.sharedPreferences.edit().putInt("active level", 3).apply();
                        HomeActivity.sharedPreferences.edit().putBoolean("level 3 state", true).apply();
                    }
                    if ((LevelsActivity.level + 1) == 4) {
                        if (HomeActivity.sharedPreferences.getInt("active level", 1) < (LevelsActivity.level + 1))
                            HomeActivity.sharedPreferences.edit().putInt("active level", 4).apply();
                        HomeActivity.sharedPreferences.edit().putBoolean("level 4 state", true).apply();
                    }
                    if ((LevelsActivity.level + 1) == 5) {
                        if (HomeActivity.sharedPreferences.getInt("active level", 1) < (LevelsActivity.level + 1))
                            HomeActivity.sharedPreferences.edit().putInt("active level", 5).apply();
                        HomeActivity.sharedPreferences.edit().putBoolean("level 5 state", true).apply();
                    }
                } else {
                    userWon = false;
                }
                Intent gameOver = new Intent(randomLevel.this, GameOver.class);
                gameOver.putExtra("User Won", userWon);
                gameOver.putExtra("Current Level", LevelsActivity.level);
                gameOver.putExtra("Next Level", LevelsActivity.level + 1);
                timer.cancel();
                finish();

                startActivity(gameOver);
            }
        }
    }

    @Override
    public void onBackPressed() {

        dialog.setContentView(R.layout.level_exit);
        levelExitYes = (Button) dialog.findViewById(R.id.yes);
        levelExitNo = (Button) dialog.findViewById(R.id.no);

        levelExitYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit = true;
                timer.cancel();
                onBackPressed();
            }
        });
        levelExitNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit = false;
                dialog.dismiss();
            }
        });

        if (exit == true)
            super.onBackPressed();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Paused", "User tapped home");

        onActivityPaused = true;

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Resumed", "User opened app");

        if (onActivityPaused == true && onTimerFinished == true) {

            onActivityPaused = false;

            Intent intent = new Intent(randomLevel.this, GameOver.class);
            intent.putExtra("Current Level", LevelsActivity.level);
            intent.putExtra("Next Level", LevelsActivity.level + 1);
            intent.putExtra("Time Up", true);
            finish();
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomlevel);
        intent = new Intent(getApplicationContext(), GameOver.class);
        play = true;
        totalTimesPlayed = 1;
        won = 0;
        Intent intent = getIntent();
        firstOption = (Button) findViewById(R.id.firstOption);
        secondOption = (Button) findViewById(R.id.secondOption);
        thirdOption = (Button) findViewById(R.id.thirdOption);
        fourthOption = (Button) findViewById(R.id.fourthOption);
        timerText = (TextView) findViewById(R.id.timerText);
        QuestionText = (TextView) findViewById(R.id.QuestionText);
        userScore = (TextView) findViewById(R.id.userScore);
        textViewLevel = (TextView) findViewById(R.id.textViewLevel);
        imageViewResult = (ImageView) findViewById(R.id.imageViewResult);

        onActivityPaused = false;

        onTimerFinished = false;

        exit = false;

        Log.i("Button tapped:", intent.getStringExtra("Button"));
        if (timerText.getText().toString().equalsIgnoreCase("0s")) {
            Intent gameOver = new Intent(randomLevel.this, GameOver.class);
            gameOver.putExtra("User Won", userWon);
            finish();
            startActivity(gameOver);
        }
        if (intent.getStringExtra("Button").equals("1")) {
            Log.i("Button tapped:", intent.getStringExtra("Button"));
            levelOfQuestion = "very easy";
            total = 10; //here you can make change for total times playable
            textViewLevel.setText("Level 1");
        }
        if (intent.getStringExtra("Button").equals("2")) {
            Log.i("Button tapped:", intent.getStringExtra("Button"));
            levelOfQuestion = "easy";
            total = 10; //here you can make change for total times playable
            textViewLevel.setText("Level 2");
        }
        if (intent.getStringExtra("Button").equals("3")) {
            levelOfQuestion = "hard";
            total = 10; //here you can make change for total times playable
            textViewLevel.setText("Level 3");
        }
        if (intent.getStringExtra("Button").equals("4")) {
            levelOfQuestion = "mixed";
            total = 10; //here you can make change for total times playable
            textViewLevel.setText("Level 4");
        }

        timer();
        math.askQuestionandGiveOptions();
        userScore.setText(won + "/" + total);
        Float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        final GridLayout card_front = (GridLayout) findViewById(R.id.front_card);
        final ImageView card_back = (ImageView) findViewById(R.id.back_card);
        final TextView textView = (TextView) findViewById(R.id.textView);
        card_front.setCameraDistance(8000 * scale);
        card_back.setCameraDistance(8000 * scale);

        if (textViewLevel.getText().toString().equalsIgnoreCase("Level 1")) {

            card_back.setImageResource(R.drawable.lvl1tip);

        }
        if (textViewLevel.getText().toString().equalsIgnoreCase("Level 2")) {

            card_back.setImageResource(R.drawable.lvl2tip);

        }
        if (textViewLevel.getText().toString().equalsIgnoreCase("Level 3")) {

            card_back.setImageResource(R.drawable.lvl3tip);

        }
        if (textViewLevel.getText().toString().equalsIgnoreCase("Level 4")) {

            card_back.setImageResource(R.drawable.lvl4tip);

        }

        front_anim = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.front_animation);
        back_anim = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.back_animation);
        flipbtn = (ImageView) findViewById(R.id.flipbtn);
        flipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isFront) {
                    flipbtn.setImageResource(R.drawable.lightbulb);
                    front_anim.setTarget(card_front);
                    back_anim.setTarget(card_back);

                    front_anim.start();

                    back_anim.start();
                    textView.animate().setStartDelay(700).alpha(1).setDuration(500);
                    firstOption.setClickable(false);
                    secondOption.setClickable(false);
                    thirdOption.setClickable(false);
                    fourthOption.setClickable(false);
                    isFront = false;
                } else {
                    flipbtn.setImageResource(R.drawable.bulb);
                    front_anim.setTarget(card_back);
                    back_anim.setTarget(card_front);
                    back_anim.start();
                    front_anim.start();
                    textView.animate().alpha(0).setDuration(1);
                    firstOption.setClickable(true);
                    secondOption.setClickable(true);
                    thirdOption.setClickable(true);
                    fourthOption.setClickable(true);
                    isFront = true;
                }
            }
        });

        dialog = new Dialog(this);
    }

    public void timer() {
    /*
         level 1 = 30s
         Levels 2 to 4 = 45s
     */

    int timeLimit = 0;

    if(LevelsActivity.level == 1)
        timeLimit = 30000;
    else if(LevelsActivity.level > 1 && LevelsActivity.level < 5)
        timeLimit = 45000;

        timer = new CountDownTimer(timeLimit + 200, 1000) {
            @Override
            public void onTick(long l) {
                timerText.setText((l / 1000) + "s");
            }

            @Override
            public void onFinish() {

                onTimerFinished = true;

                if (LevelsActivity.level == 1 || LevelsActivity.level == 2 || LevelsActivity.level == 3 || LevelsActivity.level == 4) {
                    randomLevel.timerText.setText("0s");
                    randomLevel.play = false;
                }
                System.out.println("totalTimesPlayed : " + randomLevel.totalTimesPlayed);
                if (onActivityPaused == false && onTimerFinished == true) {
                    Intent intent = new Intent(randomLevel.this, GameOver.class);
                    intent.putExtra("Current Level", LevelsActivity.level);
                    intent.putExtra("Next Level", LevelsActivity.level + 1);
                    intent.putExtra("Time Up", true);
                    finish();
                    startActivity(intent);
                }
            }
        }.start();
    }

}
