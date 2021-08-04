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

public class Expert_intro extends AppCompatActivity {

    TextView text1,text2,text3,text4,text5,text6,text7,text8;
    ImageView img1,img2,img3,img4,img5;
    Button start;

    Animation leftAnim,rightAnim;

    String intro[] = {
            "Well Done!! Well Done!!\n As you have scored really well, we grant you another PROMOTION",
            "Welcome to the Expert level and yes yes you will have raise in the salary as well",
            "Now, your core knowledge of Software engineering is strong." +
            " Our chief Manager Ms. Sharma will be asking some questions related to the advance Software engineering.",
            "Greetings Ma'am",
            "Hello. I am Tania Sharma, chief Manager of this firm.",
            "Pleasure meeting you Ma'am",
            "Oh and I have heard a lot about you. So this time I will test your advance knowledge of Software Engineering subject.",
            "And yes it wont be easy. \n So when you are ready, start the quiz"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_expert_intro);

        leftAnim = AnimationUtils.loadAnimation(this, R.anim.chat_animation_left);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.chat_animation_right);

        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        img3 = findViewById(R.id.image3);
        img4 = findViewById(R.id.image4);
        img5 = findViewById(R.id.image5);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);
        text8 = findViewById(R.id.text8);

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
        //user
        img4.setAnimation(rightAnim);
        text6.setAnimation(rightAnim);
        //manager
        img5.setAnimation(leftAnim);
       // text7.setAnimation(leftAnim);
        text8.setAnimation(leftAnim);

        text1.setText(intro[0]);
        text2.setText(intro[1]);
        text3.setText(intro[2]);
        text4.setText(intro[3]);
        text5.setText(intro[4]);
        text6.setText(intro[5]);
        text7.setText(intro[6]);
        text8.setText(intro[7]);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Expert_intro.this, Expert_main.class);
                startActivity(intent);
            }
        });
    }
}