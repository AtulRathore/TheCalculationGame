package com.atulRtech.atul.thecalcualtiongame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Atul on 16-04-2017.
 */

public class SelectGame extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_game);
    }

    public void additionScreen(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void multiplicationScreen(View view){
        Intent i1 = new Intent(this, Multiplication.class);
        startActivity(i1);
    }
}
