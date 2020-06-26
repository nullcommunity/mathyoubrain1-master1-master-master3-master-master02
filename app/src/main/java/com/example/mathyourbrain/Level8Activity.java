package com.example.mathyourbrain;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Level8Activity extends AppCompatActivity {

    TextView textViewQuestion, textViewTimer, textViewScore;
    Button button1, button2, button3, button4, buttonPlayAgain, buttonNextLevel;
    CountDownTimer countDownTimer;
    RelativeLayout relativeLayout;

    String question1 = "2, -1, -4, ?, -10\nWhat is the missing number?";
    String question2 = "Which term of the sequence\n3, 10, 17, 24, ....., is 87?";
    String question3 = "What is the sum of the first 5 multiples of 3?";
    String question4 = "The sum of the sequence\n1, 4, 16, ......\n is 341, then what is the number of terms in the sequence?";
    String question5 = "If x, 2 + x, 3 + x\nare three terms of Geometric Progression,\nthen what is the fourth term?";
    String answer1 = "-7";
    String answer2 = "11";
    String answer3 = "45";
    String answer4 = "5";
    String answer5 = "-27/2";
    AnimatorSet front_anim;
    AnimatorSet back_anim;
    ImageView flipbtn;
    Boolean isFront = true;
    int number1, number2, answer, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, questionNumber = 0, score = 0, operation;
    boolean display = true;

    Intent goToGameOver;

    ImageView imageViewResult;

    static boolean onActivityPaused = false;

    static boolean onTimerFinished = false;

    boolean exit = false;
    Dialog dialog;
    Button levelExitYes, levelExitNo;

    public void questionManager() {

        Random rand = new Random();

        if (questionNumber < 5) {

            questionNumber = questionNumber + 1;
            Log.i("Question Number", questionNumber + "");
            correctAnswer = rand.nextInt(4) + 1;
            Log.i("Correct Answer", correctAnswer + "");
            if (questionNumber == 1) {
                textViewQuestion.setText(question1);
                if (correctAnswer == 1) {
                    button1.setText(answer1);
                    button2.setText("-8");
                    button3.setText("-6");
                    button4.setText("-9");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer1);
                    button1.setText("-8");
                    button3.setText("-6");
                    button4.setText("-9");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer1);
                    button1.setText("-8");
                    button2.setText("-6");
                    button4.setText("-9");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer1);
                    button1.setText("-8");
                    button2.setText("-6");
                    button3.setText("-9");
                }
                Log.i("Answer", answer1 + " Position: " + correctAnswer);
            }

            if (questionNumber == 2) {
                textViewQuestion.setText(question2);
                if (correctAnswer == 1) {
                    button1.setText(answer2);
                    button2.setText("10");
                    button3.setText("12");
                    button4.setText("9");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer2);
                    button1.setText("10");
                    button3.setText("12");
                    button4.setText("9");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer2);
                    button1.setText("10");
                    button2.setText("12");
                    button4.setText("9");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer2);
                    button1.setText("10");
                    button2.setText("12");
                    button3.setText("9");
                }
                Log.i("Answer", answer2 + " Position: " + correctAnswer);
            }

            if (questionNumber == 3) {
                textViewQuestion.setText(question3);
                if (correctAnswer == 1) {
                    button1.setText(answer3);
                    button2.setText("48");
                    button3.setText("42");
                    button4.setText("39");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer3);
                    button1.setText("48");
                    button3.setText("42");
                    button4.setText("39");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer3);
                    button1.setText("48");
                    button2.setText("42");
                    button4.setText("39");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer3);
                    button1.setText("48");
                    button2.setText("42");
                    button3.setText("39");
                }
                Log.i("Answer", answer3 + " Position: " + correctAnswer);
            }

            if (questionNumber == 4) {
                textViewQuestion.setText(question4);
                if (correctAnswer == 1) {
                    button1.setText(answer4);
                    button2.setText("6");
                    button3.setText("7");
                    button4.setText("4");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer4);
                    button1.setText("6");
                    button3.setText("7");
                    button4.setText("4");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer4);
                    button1.setText("6");
                    button2.setText("7");
                    button4.setText("4");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer4);
                    button1.setText("6");
                    button2.setText("7");
                    button3.setText("4");
                }
                Log.i("Answer", answer4 + " Position: " + correctAnswer);
            }

            if (questionNumber == 5) {
                textViewQuestion.setText(question5);
                if (correctAnswer == 1) {
                    button1.setText(answer5);
                    button2.setText("27/2");
                    button3.setText("-2/27");
                    button4.setText("3/26");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer5);
                    button1.setText("27/2");
                    button3.setText("-2/27");
                    button4.setText("3/26");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer5);
                    button1.setText("27/2");
                    button2.setText("-2/27");
                    button4.setText("3/26");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer5);
                    button1.setText("27/2");
                    button2.setText("-2/27");
                    button3.setText("3/26");
                }
                Log.i("Answer", answer5 + " Position: " + correctAnswer);
            }
            textViewScore.setText(score + "/5");

        }

    }

    public void timer() {

        countDownTimer = new CountDownTimer(45000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (questionNumber <= 5) {
                    display = true;
                } else {
                    display = false;
                    countDownTimer.cancel();
                }
                textViewTimer.setText((millisUntilFinished / 1000) + "s");

            }

            @Override
            public void onFinish() {

                onTimerFinished = true;

                display = false;
                // Time's Up!

                if (onActivityPaused == false && onTimerFinished == true) {
                    if (score < 5) {
                        goToGameOver.putExtra("User won", false);
                    } else if (score == 5) {
                        goToGameOver.putExtra("User won", true);
                    }
                    goToGameOver.putExtra("Current Level", 8);
                    goToGameOver.putExtra("Next Level", 9);
                    goToGameOver.putExtra("Time Up", true);
                    startActivity(goToGameOver);
                    finish();
                }

            }

        }.start();

        if (display == true) {
            questionManager();
        }
    }

    public void answerClick(View view) {

        Button counter = (Button) view;
        int counterTag = Integer.parseInt(counter.getTag().toString());

        if (display == true) {

            if (counterTag == correctAnswer) {
                if (score < 5) {
                    score = score + 1;

                    imageViewResult.setImageResource(R.drawable.correctanswer);
                }
                if (score == 5) {
                    // Level Completed!
                    display = false;
                    countDownTimer.cancel();

                    if (HomeActivity.sharedPreferences.getInt("active level", 1) < 9)
                        HomeActivity.sharedPreferences.edit().putInt("active level", 9).apply();
                    HomeActivity.sharedPreferences.edit().putBoolean("level 9 state", true).apply();

                    goToGameOver.putExtra("User Won", true);
                    goToGameOver.putExtra("Current Level", 8);
                    goToGameOver.putExtra("Next Level", 9);
                    startActivity(goToGameOver);
                    finish();

                }
            } else {

                imageViewResult.setImageResource(R.drawable.wronganswer);
            }
            if (score < 5 && questionNumber == 5) {
                Log.i("Info", "if entered");
                questionNumber = questionNumber + 1;
                display = false;
                countDownTimer.cancel();
                // Level Failed!

                goToGameOver.putExtra("User Won", false);
                goToGameOver.putExtra("Current Level", 8);
                goToGameOver.putExtra("Next Level", 9);
                startActivity(goToGameOver);
                finish();

            }
            textViewScore.setText(score + "/5");
            questionManager();
        }
        textViewScore.setText(score + "/5");
    }

    public void playAgain(View view) {

        display = true;
        questionNumber = 0;
        score = 0;
        textViewScore.setText(score + "/5");
        timer();
        relativeLayout.animate().translationXBy(1000).setDuration(0);

    }

    public void nextLevel(View view) {

        Toast.makeText(this, "Next Level Tapped!", Toast.LENGTH_SHORT).show();

        display = true;
        questionNumber = 0;
        score = 0;
        textViewScore.setText(score + "/5");

        Intent intent = new Intent(getApplicationContext(), Level9Activity.class);
        startActivity(intent);

        finish();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level8);

        Intent intent = getIntent();

        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        textViewTimer = (TextView) findViewById(R.id.textViewTimer);
        textViewScore = (TextView) findViewById(R.id.textViewScore);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);

        imageViewResult = (ImageView) findViewById(R.id.imageViewResult);

        goToGameOver = new Intent(getApplicationContext(), GameOver.class);

        onActivityPaused = false;

        onTimerFinished = false;

        exit = false;

        questionNumber = 0;
        score = 0;

        timer();
        Float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        final GridLayout card_front = (GridLayout) findViewById(R.id.front_card);
        final ImageView card_back = (ImageView) findViewById(R.id.back_card);
        final TextView textView = (TextView) findViewById(R.id.textView);
        card_front.setCameraDistance(8000 * scale);
        card_back.setCameraDistance(8000 * scale);

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
                    button1.setClickable(false);
                    button2.setClickable(false);
                    button3.setClickable(false);
                    button4.setClickable(false);
                    isFront = false;
                } else {
                    flipbtn.setImageResource(R.drawable.bulb);
                    front_anim.setTarget(card_back);
                    back_anim.setTarget(card_front);
                    back_anim.start();
                    front_anim.start();

                    button1.setClickable(true);
                    button2.setClickable(true);
                    button3.setClickable(true);
                    button4.setClickable(true);
                    isFront = true;
                }
            }
        });
        dialog = new Dialog(this);
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
                countDownTimer.cancel();
                display = true;
                questionNumber = 0;
                score = 0;
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

            if (score < 5) {
                goToGameOver.putExtra("User Won", false);
            } else if (score == 5) {
                goToGameOver.putExtra("User Won", true);
            }
            goToGameOver.putExtra("Current Level", 8);
            goToGameOver.putExtra("Next Level", 9);
            goToGameOver.putExtra("Time Up", true);
            startActivity(goToGameOver);
            finish();
        }

    }

}
