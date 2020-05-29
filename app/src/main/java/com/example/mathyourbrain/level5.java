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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import static com.example.mathyourbrain.math.easy;
import static com.example.mathyourbrain.math.equation;
import static com.example.mathyourbrain.math.generateNumberOfElements;
import static com.example.mathyourbrain.math.generateQuestion;

import static com.example.mathyourbrain.math.random;

public class level5 extends AppCompatActivity {
    Boolean play=true;
    int totalTimesPlayed=0;
    Boolean userWon = false;
    static List indexOfsigns = new ArrayList();
    List signList = new ArrayList();
    static TextView timerText , QuestionText , textViewScore;
    Intent intent;
    int won=0;
    String question;
    CountDownTimer timer ;
    ImageView imageViewResult;
    AnimatorSet front_anim;
    AnimatorSet back_anim;
    ImageView flipbtn;
    Boolean isFront=true;
    static boolean onActivityPaused = false, onTimerFinished = false;

    boolean exit = false;
    Dialog dialog;
    Button levelExitYes , levelExitNo , button1 , button2;
    public void generateListofsignIndex(String str)
    {
        signList.add('+');signList.add('-');signList.add('/');signList.add('*');
        if(str.isEmpty()==false)
        {
            for(int i=0 ; i<str.length() ; i++)
            {
                if(i!=0 && str.charAt(i-1)!='(') {
                    if (signList.contains(str.charAt(i))) {
                        indexOfsigns.add(i);
                    }
                }
            }
        }
    }
    public void giveQuestion()
    {

        generateNumberOfElements();
        question = generateQuestion();
        generateListofsignIndex(question);
        System.out.println("listOfsignIndex : "+indexOfsigns);
        Collections.shuffle(indexOfsigns);
        int whatShouldweplace=random.nextInt(2); // 0 - greater than and 1 - less than
        if(whatShouldweplace==0)//place - greater than
        {
            question = question.substring(0 , (int)indexOfsigns.get(0))+">"+question.substring((int)indexOfsigns.get(0)+1);
        }
        else //place - less than
        {
            question = question.substring(0,(int)indexOfsigns.get(0))+"<"+question.substring((int)indexOfsigns.get(0)+1);
        }
        indexOfsigns.clear();

        QuestionText.setText(question);
        try {
            math.generateAnswer(QuestionText.getText().toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void enter(View view)
    {
        if(play)
        {

            if(((Button)view).getText().toString().equalsIgnoreCase(math.answer.toString()))
            {

                imageViewResult.setImageResource(R.drawable.correctanswer);
                won++;
                textViewScore.setText(won+"/10");

            }
            else
            {

                imageViewResult.setImageResource(R.drawable.wronganswer);

            }
            totalTimesPlayed++;
            if(totalTimesPlayed>=10)
            {
                play= false;

                if (won == 10) {
                    userWon = true;
                    if(HomeActivity.sharedPreferences.getInt("active level", 1) < 6)
                        HomeActivity.sharedPreferences.edit().putInt("active level", 6).apply();
                    HomeActivity.sharedPreferences.edit().putBoolean("level 6 state", true).apply();
                } else {
                    userWon = false;
                }
                Intent gameOver = new Intent(level5.this, GameOver.class);
                gameOver.putExtra("Current Level", 5);
                System.out.println(LevelsActivity.level);
                gameOver.putExtra("Next Level", 6);
                gameOver.putExtra("User Won", userWon);
                timer.cancel();
                finish();
                startActivity(gameOver);
            }

            giveQuestion();

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
        int level=random.nextInt(3);
        if(level==0)
        {
            randomLevel.levelOfQuestion="easy";
        }
        if(level==1)
        {
            randomLevel.levelOfQuestion="mixed";
        }
        if(level==2)
        {
            randomLevel.levelOfQuestion="hard";
        }

        Log.i("Resumed", "User opened app");

        if(onActivityPaused == true && onTimerFinished == true) {

            onActivityPaused = false;

            Intent intent = new Intent(level5.this, GameOver.class);
            intent.putExtra("Current Level", LevelsActivity.level);
            intent.putExtra("Next Level", 6);
            intent.putExtra("Time Up", true);
            finish();
            startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);
        won=0;
        totalTimesPlayed=0; userWon = false;

        onActivityPaused = false;

        onTimerFinished = false;

        exit = false;

        intent = getIntent();
        timer();
        int level=random.nextInt(3);
        if(level==0)
        {
            randomLevel.levelOfQuestion="easy";
        }
        if(level==1)
        {
            randomLevel.levelOfQuestion="mixed";
        }
        if(level==2)
        {
            randomLevel.levelOfQuestion="hard";
        }
        signList.clear();
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        imageViewResult = (ImageView) findViewById(R.id.imageViewResult);
        textViewScore =(TextView) findViewById(R.id.textViewScore);
        timerText =(TextView) findViewById(R.id.timerText);
        QuestionText = (TextView) findViewById(R.id.QuestionText);
        System.out.println("Button tapped "+intent.getStringExtra("Button"));
        textViewScore.setText(won+"/10");
        giveQuestion();
        Float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        final LinearLayout card_front = (LinearLayout) findViewById(R.id.front_card);
        final ImageView card_back = (ImageView) findViewById(R.id.back_card);
        final TextView textView = (TextView) findViewById(R.id.textView);
        card_front.setCameraDistance(8000*scale);
        card_back.setCameraDistance(8000*scale);

        front_anim =(AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext() , R.animator.front_animation) ;
        back_anim =(AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext() , R.animator.back_animation) ;
        flipbtn = (ImageView) findViewById(R.id.flipbtn);
        flipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isFront)
                {
                    flipbtn.setImageResource(R.drawable.lightbulb);
                    front_anim.setTarget(card_front);
                    back_anim.setTarget(card_back);

                    front_anim.start();

                    back_anim.start();

                    button1.setClickable(false);
                    button2.setClickable(false);
                    isFront=false;
                }
                else {
                    flipbtn.setImageResource(R.drawable.bulb);
                    front_anim.setTarget(card_back);
                    back_anim.setTarget(card_front);
                    back_anim.start();
                    front_anim.start();

                    button1.setClickable(true);
                    button2.setClickable(true);
                    isFront=true;
                }

            }
        });
        dialog = new Dialog(this);

    }
    public void timer() {
        timer=new CountDownTimer(30000 + 100, 1000) {
            @Override
            public void onTick(long l) {
                timerText.setText((l / 1000) + "s");
            }

            @Override
            public void onFinish() {

                onTimerFinished = true;

                if(LevelsActivity.level == 5) {
                    level5.timerText.setText("0s");
                }
                System.out.println("totalTimesPlayed : " + totalTimesPlayed);
                if(onActivityPaused == false && onTimerFinished == true) {
                    Intent intent = new Intent(level5.this, GameOver.class);
                    intent.putExtra("Current Level", LevelsActivity.level);
                    intent.putExtra("Next Level", 6);
                    intent.putExtra("Time Up", true);
                    finish();
                    startActivity(intent);
                }
            }
        }.start();
    }
}
