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


public class Intermediate_intro extends AppCompatActivity {

    TextView text1,text2,text3,text4,text5,text6,text7;
    ImageView img1,img2,img3;
    Button start;

    Animation leftAnim,rightAnim;

    String intro[] = {
            "Well Done Newbie!!\n As you have scored really well, we grant you a PROMOTION",
            "Welcome to the Intermediate level and definitely you will have raise in salary",
            "Now, your fundamentals of Software engineering is strong." +
            " Our manager Mr. Malhotra will be asking furthur questions related to the core of Software engineering.",
            "Greetings Sir",
            "Hello. My name is Mr. Raj Malhotra. I am the manager of this firm",
            "Sir instructed me to test your core knowledge of Software Engineering subject.",
            "Haha, I will be asking bit medium level questions :)\n When you are ready, start the quiz"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intermediate_intro);

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
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);

        start = findViewById(R.id.quiz);
        //boss
        img1.setAnimation(leftAnim);
        text1.setAnimation(leftAnim);
        text2.setAnimation(leftAnim);
        text3.setAnimation(leftAnim);
        //user
        img2.setAnimation(rightAnim);
        text4.setAnimation(rightAnim);
        //manager
        img3.setAnimation(leftAnim);
        text5.setAnimation(leftAnim);
        text6.setAnimation(leftAnim);
        text7.setAnimation(leftAnim);
        // Create quizArray from level1.

        text1.setText(intro[0]);
        text2.setText(intro[1]);
        text3.setText(intro[2]);
        text4.setText(intro[3]);
        text5.setText(intro[4]);
        text6.setText(intro[5]);
        text7.setText(intro[6]);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intermediate_intro.this, Intermediate_main.class);
                startActivity(intent);
            }
        });
    }
}