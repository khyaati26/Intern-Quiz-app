package com.example.softwareengmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import static com.example.softwareengmodel.R.layout.activity_newbie_intro;

public class Newbie_intro extends AppCompatActivity {

    TextView text1,text2,text3,text4,text5;
    ImageView img1,img2,img3;
    Button start;

    Animation leftAnim,rightAnim;


    String intro[] = {
            "Hello and Welcome to the Office, a Software Engineering Game.\n " +
             "I assume you are familiar with the fundamentals of Software Engineering and the various models associated with it. " +
             "Our employee Ms. Khanna will be asking certain questions that will be related to the fundamental of Software engineering." +
             "Best of luck!!",
            "Hello Ma’am",
            "Hello dear.\nMy name is Ms. Anjali Khanna.",
            "Sir instructed me to test your fundamental knowledge of Software Engineering subject.",
            "Do not worry much, I won't be asking too difficult :)\n When you are ready, start the quiz"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(activity_newbie_intro);

        leftAnim = AnimationUtils.loadAnimation(this, R.anim.chat_animation_left);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.chat_animation_right);

        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        img3 = findViewById(R.id.image3);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);

        start = findViewById(R.id.quiz);

        //boss
        img1.setAnimation(leftAnim);
        text1.setAnimation(leftAnim);
        //user
        img2.setAnimation(rightAnim);
        text2.setAnimation(rightAnim);
        //employee
        img3.setAnimation(leftAnim);
        text3.setAnimation(leftAnim);
        text4.setAnimation(leftAnim);
        text5.setAnimation(leftAnim);
        // Create quizArray from level1.

        text1.setText(intro[0]);
        text2.setText(intro[1]);
        text3.setText(intro[2]);
        text4.setText(intro[3]);
        text5.setText(intro[4]);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Newbie_intro.this, Newbie_main.class);
                startActivity(intent);
            }
        });


    }
}