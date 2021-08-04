package com.example.softwareengmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class Result extends AppCompatActivity {

    static int totalScore = 0;
    int score = 0;
    int totalCount =0;
    SharedPreferences sharedPreferences;

    TextView resultLabel1, resultLabel2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result);

        resultLabel1 = findViewById(R.id.resultLabel1);
        resultLabel2 = findViewById(R.id.resultLabel2);


        //extracting value
        score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        totalCount = getIntent().getIntExtra("TOTAL_COUNT", 0);
        sharedPreferences = getSharedPreferences("QUIZ_DATA", Context.MODE_PRIVATE);

        // Update total score.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("TOTAL_SCORE", 0);
        editor.apply();

        totalScore = sharedPreferences.getInt("TOTAL_SCORE", 0);
        totalScore = totalScore + (score*5);

        resultLabel1.setText("Well done !! \n Your Score is "+ score + " /" + totalCount);
        resultLabel2.setText("And Total Score of the Quiz: " + totalScore);


    }

    public void newbieResult(View v){
        Intent intent = new Intent(Result.this, Newbie_main.class);
        startActivity(intent);

    }

    public void intermediateResult(View v){
        if(totalScore >= 20 ){
             Intent intent = new Intent(Result.this, Intermediate_intro.class);
             startActivity(intent);
            }
        else{
            Intent intent = new Intent(Result.this, Newbie_intro.class);
            startActivity(intent);
            }
    }

    public void expertResult(View v) {

        if (totalScore >= 30) {
            Intent intent = new Intent(Result.this, Expert_intro.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(Result.this, Intermediate_intro.class);
            startActivity(intent);
        }
    }

}