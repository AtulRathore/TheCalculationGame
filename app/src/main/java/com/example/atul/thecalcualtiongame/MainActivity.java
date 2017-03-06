package com.example.atul.thecalcualtiongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    ArrayList<Integer> answers;
    int locationOfRightAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startGameButton);
        TextView sumTV = (TextView) findViewById(R.id.sumTV);
        Random rdm = new Random();
        int num1 = rdm.nextInt(26);
        int num2 = rdm.nextInt(26);
        sumTV.setText(Integer.toString(num1) + " + " + Integer.toString(num2));
        locationOfRightAnswer = rdm.nextInt(4);

        int wrongAnswer;
        for(int i=0; i<4; i++){
            if(i==locationOfRightAnswer){
                answers.add(num1+num2);
            }else{
                wrongAnswer= rdm.nextInt(41);
                while(wrongAnswer == num1+num2){
                    wrongAnswer= rdm.nextInt(41);
                }

                answers.add(wrongAnswer);
            }

        }
    }

    public void startGame(View view) {
        startButton.setVisibility(View.INVISIBLE);
    }
}
