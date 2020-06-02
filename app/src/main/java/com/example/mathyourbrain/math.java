package com.example.mathyourbrain;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.script.*;

public class math {
    static int numberOfElements;
    static Object answer;
    static Random random = new Random();

    static List signList = new ArrayList();
    static String equation;
    static int i;
    static int indexToPlaceDecimalNumber;static String number1,number2,number3;



        public static void askQuestionandGiveOptions () {
            math.generateNumberOfElements();
            String Question1 = math.generateQuestion();
            String Question2 = (Question1.replace('*', '×') + "= ?").replace('/', '÷');
            randomLevel.QuestionText.setText(Question2);
            try {
                math.generateAnswer(Question1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            math.placeOptions();
        }

        public static void veryEasy () {
            int number = random.nextInt(20) - 9;
            if (randomLevel.won > 5) {
                number = number * 10 + random.nextInt(20) - 9;
            }
            if ((char) signList.get(0) == '*') {
                signList.set(0, '+');
            }
            if ((char) signList.get(0) == '/') {
                signList.set(0, '-');
            }
            if (number < 0) {
                equation += "(" + String.valueOf(number) + ")" + " " + signList.get(0) + " ";
            } else {
                equation += String.valueOf(number) + " " + signList.get(0) + " ";
            }
        }

    public static void easy() {
        int number = random.nextInt(20) - 9;
        if(randomLevel.won>5)
        {
            number=number*10+random.nextInt(20)-9;
        }
        if (number < 0) {
            equation += "(" + String.valueOf(number) + ")" + " " + signList.get(0) + " ";
        } else {
            equation += String.valueOf(number) + " " + signList.get(0) + " ";
        }
    }

    public static void hard() {
        if ((char) signList.get(0) == '/') {
            signList.set(0, '*');
        }
        if (i == 1) {
            indexToPlaceDecimalNumber = random.nextInt(numberOfElements);
        }
        if (i == indexToPlaceDecimalNumber) {
            double number = random.nextDouble() * 10;
            equation += String.valueOf(number).substring(0, String.valueOf(number).indexOf('.') + 2) + " " + signList.get(0) + " ";
        } else {
            int number = random.nextInt(10);
            equation += String.valueOf(number).substring(0, String.valueOf(number).indexOf('.') + 2) + " " + signList.get(0) + " ";
        }

    }

    public static void generateNumberOfElements() {
        if (randomLevel.levelOfQuestion == "very easy") {
            numberOfElements = 2;
        }
        if (randomLevel.levelOfQuestion == "easy") {
            numberOfElements = random.nextInt(2) + 2;
        }
        if (randomLevel.levelOfQuestion == "hard") {
            numberOfElements = random.nextInt(2) + 3;
        }
        if (randomLevel.levelOfQuestion == "mixed") {
            numberOfElements = random.nextInt(2) + 4;
        }
        if (randomLevel.levelOfQuestion == "greaterThanlessThan") {
            numberOfElements = random.nextInt(2) + 4;
        }
        if (randomLevel.levelOfQuestion == "") {
            Log.i("Error found", "levelOfQuestion");
        }
    }

    public static String generateQuestion() {

        signList.clear();

        signList.add('+');
        signList.add('-');
        signList.add('/');
        signList.add('*');
        equation = "";
        for (i = 0; i < numberOfElements; i++) {
            Collections.shuffle(signList);
            System.out.println("signList:" + signList);

            if (randomLevel.levelOfQuestion == "very easy") {
                veryEasy();
            }

            if (randomLevel.levelOfQuestion == "easy") {
                easy();
            }
            if (randomLevel.levelOfQuestion == "hard") {
                hard();
            }
            if (randomLevel.levelOfQuestion == "mixed") {
                int whatWeShouldAdd = random.nextInt(3);

                if (whatWeShouldAdd == 0) {
                    veryEasy();
                }
                if (whatWeShouldAdd == 1) {
                    easy();
                }
                if (whatWeShouldAdd == 2) {
                    hard();
                }
            }
            if ((char) signList.get(0) == '/') {
                signList.remove(0);
            }
        }

        equation = equation.substring(0, equation.length() - 2);
        try {
            generateAnswer(equation);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in calling for answer in generating equation");
        }
        if (answer.toString().isEmpty() == false) {
            if (isNonTerminating(answer.toString())) {
                System.out.println("called");
                generateQuestion();
            }
        }
        return equation;
    }

    public static void generateAnswer(String equation) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("rhino");
        answer = engine.eval(equation);
        System.out.println("equation:" + equation);
        System.out.println("answer:" + answer);
    }

    public static void placeOptions() {
        System.out.println("aya");
        giveOptions(answer);
        int answerPosition = random.nextInt(4);
        if (0 == answerPosition) {
            randomLevel.firstOption.setText(answer.toString());
            randomLevel.secondOption.setText(number1);
            randomLevel.thirdOption.setText(number2);
            randomLevel.fourthOption.setText(number3);
        }
        if (1 == answerPosition) {
            randomLevel.secondOption.setText(answer.toString());
            randomLevel.firstOption.setText(number1);
            randomLevel.thirdOption.setText(number2);
            randomLevel.fourthOption.setText(number3);
        }
        if (2 == answerPosition) {
            randomLevel.thirdOption.setText(answer.toString());
            randomLevel.secondOption.setText(number1);
            randomLevel.firstOption.setText(number2);
            randomLevel.fourthOption.setText(number3);;
        }
        if (3 == answerPosition) {
            randomLevel.fourthOption.setText(answer.toString());
            randomLevel.secondOption.setText(number1);
            randomLevel.thirdOption.setText(number2);
            randomLevel.firstOption.setText(number3);
        }
    }
    
    public static void giveOptions(Object answer)
    {
        number1 = String.valueOf((double) answer + (random.nextInt(20) -9) + random.nextInt(random.nextInt(8) + 2) + 1) ;
         number2 = String.valueOf((double) answer + (random.nextInt(20) -9) + random.nextInt(random.nextInt(8) + 2) + 1) ;
         number3 = String.valueOf((double) answer + (random.nextInt(20) -9) + random.nextInt(random.nextInt(8) + 2) + 1);
     if(isNonTerminating(number1))   number1 = number1.substring(0,number1.indexOf('.') + 3);
     if(isNonTerminating(number2))   number2 = number2.substring(0,number2.indexOf('.') + 3);
     if(isNonTerminating(number3)) number3 = number3.substring(0,number3.indexOf('.') + 3);
    }

    public static Boolean isNonTerminating(String result) {
        if (result.substring(result.indexOf('.') + 1).length() > 4) {
            return true;
        } else {
            return false;
        }
    }
}

