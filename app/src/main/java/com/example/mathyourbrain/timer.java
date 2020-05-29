package com.example.mathyourbrain;

import android.content.Intent;
import android.os.CountDownTimer;

public class timer {
 static    long  timeLimit;
    static CountDownTimer a;
    public static void startTimer(long timeLimit) {
      a = new CountDownTimer(timeLimit + 100, 1000) {
         @Override
            public void onTick(long l) {
             if (LevelsActivity.level == 1 || LevelsActivity.level == 2 || LevelsActivity.level == 3 || LevelsActivity.level == 4) {
                 randomLevel.timerText.setText((l / 1000) + "s");
             }
             if (LevelsActivity.level == 5) {
                 level5.timerText.setText((l / 1000) + "s");
             }
         }

            @Override
            public void onFinish() {
                if (LevelsActivity.level == 1 || LevelsActivity.level == 2 || LevelsActivity.level == 3 || LevelsActivity.level == 4) {
                    randomLevel.timerText.setText("0s");
                    randomLevel.play=false;
                }
                if(LevelsActivity.level == 5) {
                    level5.timerText.setText("0s");
                }
                System.out.println("totalTimesPlayed : "+randomLevel.totalTimesPlayed);
            }
        }.start();
    }
    public static void stopTimer() {
        a.cancel();
    }
    public static void setTimeLimit(long timeLimit) {
        timer.timeLimit = 30000;

    }

}
