package com.example.softwareengmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartPage extends AppCompatActivity {

    int count = 0;
    Button newbie, intermediate, expert, result;
    TextView title, info;

    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start_page);

        title = findViewById(R.id.Title);
        info = findViewById(R.id.info);
        newbie = findViewById(R.id.newbie);
        intermediate = findViewById(R.id.intermediate);
        expert = findViewById(R.id.expert);
        result = findViewById(R.id.result);

        Context context = getApplicationContext();

        this.totalScore = Result.totalScore;

        newbie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPage.this, Newbie_intro.class);
                startActivity(intent);
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Result.totalScore <= 20 ){
                    Toast.makeText(context,"You have to solve level 1 to view score " ,
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StartPage.this, Newbie_intro.class);
                    startActivity(intent);
                    }
                else {
                    Intent intent = new Intent(StartPage.this, Intermediate_intro.class);
                    startActivity(intent);
                }
            }
        });

        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 if(Result.totalScore >20 && Result.totalScore <= 30 ){
                     Toast.makeText(context,"You have to solve level 2 to view score " ,
                             Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(StartPage.this, Newbie_intro.class);
                     startActivity(intent);
                    }
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(count == 0 ){
                     Toast.makeText(context,"You have to solve level 1 to view score " ,
                             Toast.LENGTH_LONG).show();
                     Intent intent = new Intent(StartPage.this, Newbie_intro.class);
                     startActivity(intent);

                    }
                   else{
                     Intent intent = new Intent(StartPage.this, Result.class);
                     startActivity(intent);
                   }

            }
        });
        
    }
}
