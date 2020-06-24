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

public class Level10Activity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    TextView textViewTimer, textViewScore, textViewQuestion;
    ImageView imageView;
    CountDownTimer countDownTimer;
    RelativeLayout relativeLayout;

    String question1 = "What are the roots of the following equation:\nx² - 3x - 10 = 0";
    String question2 = "What are the roots of the following equation:\nx² - 4x - 12 = 0";
    String question3 = "What are the roots of the following equation:\n(x - 4)² + 5² = 13²";
    String question4 = "What are the roots of the following equation:\n3(x - 2)² = 147";
    String question5 = "What is the roots of the following equation:\n2x² - 9x + 10 = 0, when x ∈ N";
    String question6 = "Find the values of 'p' for which the\nfollowing equation has real roots:\n3x² - px + 5 = 0";

    String answer1 = "-2, 5";
    String answer2 = "-2, 6";
    String answer3 = "16, -8";
    String answer4 = "-5, 9";
    String answer5 = "2";
    String answer6 = "2√15, -2√15";

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

        if (questionNumber < 6) {

            questionNumber = questionNumber + 1;
            Log.i("Question Number", questionNumber + "");
            correctAnswer = rand.nextInt(4) + 1;
            Log.i("Correct Answer", correctAnswer + "");
            if (questionNumber == 1) {
                textViewQuestion.setText(question1);
                if (correctAnswer == 1) {
                    button1.setText(answer1);
                    button2.setText("-2, 6");
                    button3.setText("-2, 4");
                    button4.setText("-3, 11");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer1);
                    button1.setText("-2, 6");
                    button3.setText("-2, 4");
                    button4.setText("-3, 11");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer1);
                    button1.setText("-2, 6");
                    button2.setText("-2, 4");
                    button4.setText("-3, 11");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer1);
                    button1.setText("-2, 6");
                    button2.setText("-2, 4");
                    button3.setText("-3, 11");
                }
                Log.i("Answer", answer1 + " Position: " + correctAnswer);
            }

            if (questionNumber == 2) {
                textViewQuestion.setText(question2);
                if (correctAnswer == 1) {
                    button1.setText(answer2);
                    button2.setText("-3, 6");
                    button3.setText("-1, 4");
                    button4.setText("4, 5");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer2);
                    button1.setText("-3, 6");
                    button3.setText("-1, 4");
                    button4.setText("4, 5");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer2);
                    button1.setText("-3, 6");
                    button2.setText("-1, 4");
                    button4.setText("4, 5");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer2);
                    button1.setText("-3, 6");
                    button2.setText("-1, 4");
                    button3.setText("4, 5");
                }
                Log.i("Answer", answer2 + " Position: " + correctAnswer);
            }

            if (questionNumber == 3) {
                textViewQuestion.setText(question3);
                if (correctAnswer == 1) {
                    button1.setText(answer3);
                    button2.setText("16, -7");
                    button3.setText("-8, 16");
                    button4.setText("-10, 15");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer3);
                    button1.setText("16, -7");
                    button3.setText("-8, 16");
                    button4.setText("-10, 15");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer3);
                    button1.setText("16, -7");
                    button2.setText("-8, 16");
                    button4.setText("-10, 15");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer3);
                    button1.setText("16, -7");
                    button2.setText("-8, 16");
                    button3.setText("-10, 15");
                }
                Log.i("Answer", answer3 + " Position: " + correctAnswer);
            }

            if (questionNumber == 4) {
                textViewQuestion.setText(question4);
                if (correctAnswer == 1) {
                    button1.setText(answer4);
                    button2.setText("-6, 10");
                    button3.setText("8, 4");
                    button4.setText("-7, 6");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer4);
                    button1.setText("-6, 10");
                    button3.setText("8, 4");
                    button4.setText("-7, 6");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer4);
                    button1.setText("-6, 10");
                    button2.setText("8, 4");
                    button4.setText("-7, 6");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer4);
                    button1.setText("-6, 10");
                    button2.setText("8, 4");
                    button3.setText("-7, 6");
                }
                Log.i("Answer", answer4 + " Position: " + correctAnswer);
            }

            if (questionNumber == 5) {
                textViewQuestion.setText(question5);
                if (correctAnswer == 1) {
                    button1.setText(answer5);
                    button2.setText("4");
                    button3.setText("1");
                    button4.setText("-2");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer5);
                    button1.setText("4");
                    button3.setText("1");
                    button4.setText("-2");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer5);
                    button1.setText("4");
                    button2.setText("1");
                    button4.setText("-2");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer5);
                    button1.setText("4");
                    button2.setText("1");
                    button3.setText("-2");
                }
                Log.i("Answer", answer5 + " Position: " + correctAnswer);
            }

            if (questionNumber == 6) {
                textViewQuestion.setText(question6);
                if (correctAnswer == 1) {
                    button1.setText(answer6);
                    button2.setText("4√15, -4√15");
                    button3.setText("√15, -√15");
                    button4.setText("2√60, -2√60");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer6);
                    button1.setText("4√15, -4√15");
                    button3.setText("√15, -√15");
                    button4.setText("2√60, -2√60");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer6);
                    button1.setText("4√15, -4√15");
                    button2.setText("√15, -√15");
                    button4.setText("2√60, -2√60");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer6);
                    button1.setText("4√15, -4√15");
                    button2.setText("√15, -√15");
                    button3.setText("2√60, -2√60");
                }
                Log.i("Answer", answer6 + " Position: " + correctAnswer);
            }

            textViewScore.setText(score + "/6");

        }

    }

    public void timer() {

        countDownTimer = new CountDownTimer(60000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (questionNumber <= 6) {
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
                textViewTimer.setText("0s");
                // Time's Up!

                if (onActivityPaused == false && onTimerFinished == true) {
                    if (score < 6) {
                        goToGameOver.putExtra("User Won", false);
                    } else if (score == 6) {
                        goToGameOver.putExtra("User Won", true);
                    }
                    goToGameOver.putExtra("Current Level", 10);
                    goToGameOver.putExtra("Next Level", 0);
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
                if (score < 6) {
                    score = score + 1;

                    imageViewResult.setImageResource(R.drawable.correctanswer);
                }
                if (score == 6) {

                    display = false;
                    countDownTimer.cancel();
                    // Level Completed!

                    HomeActivity.sharedPreferences.edit().putBoolean("is game complete", true).apply();
                    goToGameOver.putExtra("User Won", true);
                    goToGameOver.putExtra("Current Level", 10);
                    goToGameOver.putExtra("Next Level", 0);
                    startActivity(goToGameOver);
                    finish();

                }
            } else {

                imageViewResult.setImageResource(R.drawable.wronganswer);
            }
            if (score < 6 && questionNumber == 6) {
                Log.i("Info", "if entered");
                questionNumber = questionNumber + 1;
                display = false;
                countDownTimer.cancel();
                // Level Failed!

                goToGameOver.putExtra("User Won", false);
                goToGameOver.putExtra("Current Level", 10);
                goToGameOver.putExtra("Next Level", 0);
                startActivity(goToGameOver);
                finish();

            }
            textViewScore.setText(score + "/6");
            questionManager();
        }
        textViewScore.setText(score + "/6");
    }

    public void playAgain(View view) {

        display = true;
        questionNumber = 0;
        score = 0;
        textViewScore.setText(score + "/6");
        timer();
        relativeLayout.animate().translationXBy(1000).setDuration(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level10);

        questionNumber = 0;
        score = 0;

        Intent intent = getIntent();

        textViewTimer = (TextView) findViewById(R.id.textViewTimer);
        textViewScore = (TextView) findViewById(R.id.textViewScore);
        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        imageView = (ImageView) findViewById(R.id.imageView);

        imageViewResult = (ImageView) findViewById(R.id.imageViewResult);

        goToGameOver = new Intent(getApplicationContext(), GameOver.class);

        onActivityPaused = false;

        onTimerFinished = false;

        exit = false;

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

            if (score < 6) {
                goToGameOver.putExtra("User Won", false);
            } else if (score == 6) {
                goToGameOver.putExtra("User Won", true);
            }
            goToGameOver.putExtra("Current Level", 10);
            goToGameOver.putExtra("Next Level", 0);
            goToGameOver.putExtra("Time Up", true);
            startActivity(goToGameOver);
            finish();
        }

    }

}
