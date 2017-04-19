package com.example.atul.thecalcualtiongame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Atul on 16-04-2017.
 */


public class Multiplication extends AppCompatActivity {

    Button startButton;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button plaAgainBTN;
    TextView resultTV;
    TextView sumTV;
    TextView pointsTV;
    TextView timerTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfRightAnswer;
    int gameScore = 0;
    int numberOfProblems = 0;
    RelativeLayout startGameRelativeLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplication);
        startButton = (Button) findViewById(R.id.startGameButton);
        sumTV = (TextView) findViewById(R.id.sumTV);
        resultTV = (TextView) findViewById(R.id.resultTV);
        pointsTV = (TextView) findViewById(R.id.pointsTV);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        plaAgainBTN = (Button) findViewById(R.id.playAgainBTN);
        startGameRelativeLayout = (RelativeLayout) findViewById(R.id.startGameRelativeLayout);
        reGame(findViewById(R.id.playAgainBTN));
    }

    public void reGame(View view) {
        gameScore = 0;
        numberOfProblems = 0;
        timerTextView.setText("30s");
        pointsTV.setText("0/0");
        resultTV.setText("");
        plaAgainBTN.setVisibility(View.INVISIBLE);
        generateQuestion();
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }
            @Override
            public void onFinish() {
                plaAgainBTN.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTV.setText("Your Score:" +
                        Integer.toString(gameScore) + "/" +
                        Integer.toString(numberOfProblems));
            }
        }.start();
    }

    /*For Generating a new question*/
    public void generateQuestion() {
        Random rdm = new Random();
        int num1 = rdm.nextInt(11);
        int num2 = rdm.nextInt(11);
        sumTV.setText(Integer.toString(num1) + " X "
                + Integer.toString(num2));
        locationOfRightAnswer = rdm.nextInt(4);
        answers.clear();
        int wrongAnswer;
        for (int i = 0; i < 4; i++) {
            if (i == locationOfRightAnswer) {
                answers.add(num1 * num2);
            } else {
                wrongAnswer = rdm.nextInt(101);
                while (wrongAnswer == num1 * num2) {
                    wrongAnswer = rdm.nextInt(101);
                }
                answers.add(wrongAnswer);
            }
        }
        button3.setText(Integer.toString(answers.get(0)));
        button4.setText(Integer.toString(answers.get(1)));
        button5.setText(Integer.toString(answers.get(2)));
        button6.setText(Integer.toString(answers.get(3)));
    }
    /*For Selecting the right answer and updating the score*/
    public void selectAnswer(View view) {
        if (view.getTag().toString().equals
                (Integer.toString(locationOfRightAnswer))) {
            gameScore++;
            resultTV.setText("Correct!");
        } else {
            resultTV.setText("Incorrect!");
        }
        numberOfProblems++;
        pointsTV.setText(Integer.toString(gameScore) +
                "/" + Integer.toString(numberOfProblems));
        generateQuestion();
    }

    public void startGame(View view) {
        startButton.setVisibility(View.INVISIBLE);
        startGameRelativeLayout.setVisibility(RelativeLayout.VISIBLE);
        reGame(findViewById(R.id.playAgainBTN));
    }

}
