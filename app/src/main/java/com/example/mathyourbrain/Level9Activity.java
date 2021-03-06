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

public class Level9Activity extends AppCompatActivity {

    Button button1, button2, button3, button4;
    TextView textViewTimer, textViewScore, textViewQuestion;
    ImageView imageView;
    CountDownTimer countDownTimer;
    RelativeLayout relativeLayout;

    String question1 = "8y - 4y = 20,\ny = ?";
    String question2 = "9b - 4b + 3b = 16,\nb = ?";
    String question3 = "6 = 7 + 2p - 5,\np = ?";
    String question4 = "8 - 7x = 13 + 8,\nx = ?";
    String question5 = "4x - 5x + 2x = 28 + 3x,\nx = ?";
    String question6 = "6 - 5m -1 + 3m = 0,\nm = ?";
    String question7 = "0.4x - 1.2 = 0.3x + 0.6,\nx = ?";
    String question8 = "6(x + 4) = 36,\nx = ?";
    String question9 = "x(x + 5) = x² + x 32,\nx = ?";
    String question10 = "(x - 4) (2x + 3) = 2x²,\nx = ?";

    String answer1 = "5";
    String answer2 = "2";
    String answer3 = "2";
    String answer4 = "0";
    String answer5 = "-14";
    String answer6 = "5/2";
    String answer7 = "18";
    String answer8 = "2";
    String answer9 = "8";
    String answer10 = "-12/5";

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

        if (questionNumber < 10) {

            questionNumber = questionNumber + 1;
            Log.i("Question Number", questionNumber + "");
            correctAnswer = rand.nextInt(4) + 1;
            Log.i("Correct Answer", correctAnswer + "");
            if (questionNumber == 1) {
                textViewQuestion.setText(question1);
                if (correctAnswer == 1) {
                    button1.setText(answer1);
                    button2.setText("3");
                    button3.setText("6");
                    button4.setText("4");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer1);
                    button1.setText("3");
                    button3.setText("6");
                    button4.setText("4");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer1);
                    button1.setText("3");
                    button2.setText("6");
                    button4.setText("4");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer1);
                    button1.setText("3");
                    button2.setText("6");
                    button3.setText("-9");
                }
                Log.i("Answer", answer1 + " Position: " + correctAnswer);
            }

            if (questionNumber == 2) {
                textViewQuestion.setText(question2);
                if (correctAnswer == 1) {
                    button1.setText(answer2);
                    button2.setText("0");
                    button3.setText("4");
                    button4.setText("3");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer2);
                    button1.setText("0");
                    button3.setText("4");
                    button4.setText("3");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer2);
                    button1.setText("0");
                    button2.setText("4");
                    button4.setText("3");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer2);
                    button1.setText("0");
                    button2.setText("4");
                    button3.setText("3");
                }
                Log.i("Answer", answer2 + " Position: " + correctAnswer);
            }

            if (questionNumber == 3) {
                textViewQuestion.setText(question3);
                if (correctAnswer == 1) {
                    button1.setText(answer3);
                    button2.setText("4");
                    button3.setText("3");
                    button4.setText("0");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer3);
                    button1.setText("4");
                    button3.setText("3");
                    button4.setText("39");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer3);
                    button1.setText("4");
                    button2.setText("3");
                    button4.setText("0");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer3);
                    button1.setText("4");
                    button2.setText("3");
                    button3.setText("0");
                }
                Log.i("Answer", answer3 + " Position: " + correctAnswer);
            }

            if (questionNumber == 4) {
                textViewQuestion.setText(question4);
                if (correctAnswer == 1) {
                    button1.setText(answer4);
                    button2.setText("10");
                    button3.setText("2");
                    button4.setText("4");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer4);
                    button1.setText("10");
                    button3.setText("2");
                    button4.setText("4");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer4);
                    button1.setText("10");
                    button2.setText("2");
                    button4.setText("4");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer4);
                    button1.setText("10");
                    button2.setText("2");
                    button3.setText("4");
                }
                Log.i("Answer", answer4 + " Position: " + correctAnswer);
            }

            if (questionNumber == 5) {
                textViewQuestion.setText(question5);
                if (correctAnswer == 1) {
                    button1.setText(answer5);
                    button2.setText("-4");
                    button3.setText("-24");
                    button4.setText("-12");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer5);
                    button1.setText("-4");
                    button3.setText("-24");
                    button4.setText("-12");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer5);
                    button1.setText("-4");
                    button2.setText("-24");
                    button4.setText("-12");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer5);
                    button1.setText("-4");
                    button2.setText("-24");
                    button3.setText("-12");
                }
                Log.i("Answer", answer5 + " Position: " + correctAnswer);
            }

            if (questionNumber == 6) {
                textViewQuestion.setText(question6);
                if (correctAnswer == 1) {
                    button1.setText(answer6);
                    button2.setText("15/2");
                    button3.setText("2/5");
                    button4.setText("5/4");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer6);
                    button1.setText("15/2");
                    button3.setText("2/5");
                    button4.setText("5/4");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer6);
                    button1.setText("15/2");
                    button2.setText("2/5");
                    button4.setText("5/4");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer6);
                    button1.setText("15/2");
                    button2.setText("2/5");
                    button3.setText("5/4");
                }
                Log.i("Answer", answer6 + " Position: " + correctAnswer);
            }

            if (questionNumber == 7) {
                textViewQuestion.setText(question7);
                if (correctAnswer == 1) {
                    button1.setText(answer7);
                    button2.setText("8");
                    button3.setText("28");
                    button4.setText("14");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer7);
                    button1.setText("8");
                    button3.setText("28");
                    button4.setText("14");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer7);
                    button1.setText("8");
                    button2.setText("28");
                    button4.setText("14");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer7);
                    button1.setText("8");
                    button2.setText("28");
                    button3.setText("14");
                }
                Log.i("Answer", answer7 + " Position: " + correctAnswer);
            }

            if (questionNumber == 8) {
                textViewQuestion.setText(question8);
                if (correctAnswer == 1) {
                    button1.setText(answer8);
                    button2.setText("1");
                    button3.setText("4");
                    button4.setText("-2");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer8);
                    button1.setText("1");
                    button3.setText("4");
                    button4.setText("-2");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer8);
                    button1.setText("1");
                    button2.setText("4");
                    button4.setText("-2");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer8);
                    button1.setText("1");
                    button2.setText("4");
                    button3.setText("-2");
                }
                Log.i("Answer", answer8 + " Position: " + correctAnswer);
            }

            if (questionNumber == 9) {
                textViewQuestion.setText(question9);
                if (correctAnswer == 1) {
                    button1.setText(answer9);
                    button2.setText("18");
                    button3.setText("6");
                    button4.setText("16");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer9);
                    button1.setText("18");
                    button3.setText("6");
                    button4.setText("16");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer9);
                    button1.setText("18");
                    button2.setText("6");
                    button4.setText("16");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer9);
                    button1.setText("18");
                    button2.setText("6");
                    button3.setText("16");
                }
                Log.i("Answer", answer9 + " Position: " + correctAnswer);
            }

            if (questionNumber == 10) {
                textViewQuestion.setText(question10);
                if (correctAnswer == 1) {
                    button1.setText(answer10);
                    button2.setText("-22/5");
                    button3.setText("-2/5");
                    button4.setText("-32/5");
                }
                if (correctAnswer == 2) {
                    button2.setText(answer10);
                    button1.setText("-22/5");
                    button3.setText("-2/5");
                    button4.setText("-32/5");
                }
                if (correctAnswer == 3) {
                    button3.setText(answer10);
                    button1.setText("-22/5");
                    button2.setText("-2/5");
                    button4.setText("-32/5");
                }
                if (correctAnswer == 4) {
                    button4.setText(answer10);
                    button1.setText("-22/5");
                    button2.setText("-2/5");
                    button3.setText("-32/5");
                }
                Log.i("Answer", answer10 + " Position: " + correctAnswer);
            }

            textViewScore.setText(score + "/10");

        }

    }

    public void timer() {

        countDownTimer = new CountDownTimer(60000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (questionNumber <= 10) {
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
                    if (score < 10) {
                        goToGameOver.putExtra("User won", false);
                    } else if (score == 10) {
                        goToGameOver.putExtra("User won", true);
                    }
                    goToGameOver.putExtra("Current Level", 9);
                    goToGameOver.putExtra("Next Level", 10);
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
                if (score < 10) {
                    score = score + 1;

                    imageViewResult.setImageResource(R.drawable.correctanswer);
                }
                if (score == 10) {

                    display = false;
                    countDownTimer.cancel();
                    // Level Completed!

                    if (HomeActivity.sharedPreferences.getInt("active level", 1) < 10)
                        HomeActivity.sharedPreferences.edit().putInt("active level", 10).apply();
                    HomeActivity.sharedPreferences.edit().putBoolean("level 10 state", true).apply();

                    goToGameOver.putExtra("User Won", true);
                    goToGameOver.putExtra("Current Level", 9);
                    goToGameOver.putExtra("Next Level", 10);
                    startActivity(goToGameOver);
                    finish();

                }
            } else {

                imageViewResult.setImageResource(R.drawable.wronganswer);
            }
            if (score < 10 && questionNumber == 10) {
                Log.i("Info", "if entered");
                questionNumber = questionNumber + 1;
                display = false;
                countDownTimer.cancel();
                // Level Failed!

                goToGameOver.putExtra("User Won", false);
                goToGameOver.putExtra("Current Level", 9);
                goToGameOver.putExtra("Next Level", 10);
                startActivity(goToGameOver);
                finish();

            }
            textViewScore.setText(score + "/10");
            questionManager();
        }
        textViewScore.setText(score + "/10");
    }

    public void playAgain(View view) {

        display = true;
        questionNumber = 0;
        score = 0;
        textViewScore.setText(score + "/10");
        timer();
        relativeLayout.animate().translationXBy(1000).setDuration(0);

    }

    public void nextLevel(View view) {

        Toast.makeText(this, "Next Level Tapped!", Toast.LENGTH_SHORT).show();

        display = true;
        questionNumber = 0;
        score = 0;
        textViewScore.setText(score + "/10");

        Intent intent = new Intent(getApplicationContext(), Level10Activity.class);
        startActivity(intent);

        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level9);

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

            if (score < 10) {
                goToGameOver.putExtra("User Won", false);
            } else if (score == 10) {
                goToGameOver.putExtra("User Won", true);
            }
            goToGameOver.putExtra("Current Level", 9);
            goToGameOver.putExtra("Next Level", 10);
            goToGameOver.putExtra("Time Up", true);
            startActivity(goToGameOver);
            finish();
        }

    }

}
