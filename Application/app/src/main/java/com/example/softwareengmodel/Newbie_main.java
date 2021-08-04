package com.example.softwareengmodel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Newbie_main extends AppCompatActivity {

    private TextView question;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;

    private String rightAnswer ;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String level1[][] = {
            // {"Question", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"It is a piece of programming code which performs a well defined task.", "Computer Program",
                    "Computer Software", "Virus", "Debugging"},
            {"A system can be defined as", "All of the mentioned",
                    "A collection of people, machines, and methods organized to accomplish a set of functions",
                    "An integrated whole that is composed of diverse, interacting specialized structures and sub-functions",
                    "A group of subsystems united by some interaction or interdependence performing many duties but functioning as a single unit"},
            {"A person who writes a program for running the hardware of a computer is called",
                    "Programmer", " Data processor", "System designer", "System analyst"},
            {"The main activity of the design phase of the system life cycle is to?",
                    "Propose alternatives to the current system", "Replace the old system with the new one",
                    "Develop and test the new system", "Understand the current system"},
            {"What is Software ?", "Set of computer programs, procedures and possibly is a " +
                    "collection of instructions that enable the user to interact with a computer",
                    "A set of compiler instructions", "A mathematical formula", "Things which we can touch"},
            {"A Software consists of", "Set of Programs + documentation + operating procedures",
                    "Set of programs", "Set of instructions + operating procedures", "Programs + hardware manuals"},
            {"How many stages does the DevOp model have ?", "5 stages", "3 stages", "2 stages", "6 stages"},
            {"CMM stands for", "Capability Maturity Model", "Capability Maturity Module",
                    "Capability Management Module", "Conservative Maturity Model"},
            {"DevOps stands for", "Development And Operations", "Digital and Operations", "Drive and Operations",
                    "None of the above"},
            {"How many phases are there in Scrum", "Three", "Two",
                    "Scrum is an agile method which means it does not have phases", "Four"},
            {"RAD stands for", "Rapid Application Development", "Rapid Application Document",
                    "Relative Application Development", "Random Application Development"},
            {"RAD Model has", "5 phases", "2 phases", "3 phases", "6 phases"},
            {"SDLC stands for", "Software Development Life Cycle", "System Development Life cycle",
                    "Software Design Life Cycle", "System Design Life Cycle"},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_newbie_main);

        question = findViewById(R.id.question);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        // Create quizArray from level1.
        for (int i = 0; i < level1.length; i++) {

            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(level1[i][0]); // Country
            tmpArray.add(level1[i][1]); // Right Answer
            tmpArray.add(level1[i][2]); // Choice1
            tmpArray.add(level1[i][3]); // Choice2
            tmpArray.add(level1[i][4]); // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        // Generate random number between 0 and 14 (quizArray's size - 1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format: {"Question", "Right Answer", "Choice1", "Choice2", "Choice3"}
        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Question" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        if (btnText.equals(rightAnswer)) {
            rightAnswerCount++;
        }

        if (quizCount == QUIZ_COUNT) {
            // Show Result.
            Intent intent = new Intent(getApplicationContext(), Result.class);
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
            intent.putExtra("TOTAL_COUNT", QUIZ_COUNT);
            startActivity(intent);

        } else {
            quizCount++;
            showNextQuiz();
        }


    }
}

