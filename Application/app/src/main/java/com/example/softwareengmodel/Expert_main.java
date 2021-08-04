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

public class Expert_main extends AppCompatActivity {

    private TextView question;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;

    private String rightAnswer ;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 15;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String level3[][] = {

            {"The customer requirements are broken down into logical modules for ease of _______________	",
                    "implementation", "editing", "design", "inheritance"},
            {"What do you call a technical person who is capable of understanding the basic requirements?",
                    "analyst", "team leader", "engineer", "stakeholder"},
            {"A step in the waterfall model that involves a meeting with the customer to understand the requirements.",
                    "Requirement Gathering", "SRS", "Implementation", "Customer review"},
            {"A planned program of work that requires a definitive amount of time, effort and planning to complete.	",
                    "Project", "Problem", "Process", "Program"},
            {"An individual who plans and directs the work", " Project manager", "Stakeholder",
                    "Team leader", "Programmer"},
            {"Methodology in which project management processes were step-by step", "Waterfall",
                    "Incremental", "Spiral", "Prototyping"},
            {"What is the major drawback of using RAD Model?", "Increases reusability of components," +
                    " Highly specialized & skilled developers/designers are required,",
                    "Encourages customer/client feedback", "Increases reusability of components",
                    "Highly specialized & skilled developers/designers are required"},
            {"The item of documentation added to the description of the new system is _____?", "Feedback",
                    "Control review", "I/O analysis", "Problem overview"},
            {"Top-down software design scheme is:", "Both (a) and (b)",
                    "Is the process of designing a program by first identifying its modules",
                    "Decomposes major components into lower level components", "None of these"},
            {"How is Incremental Model different from Spiral Model?", "Progress can be measured for Incremental Model",
                    "Changing requirements can be accommodated in Incremental Model",
                    "Users can see the system early in Incremental Model", "All of the mentioned"},
            {"The spiral model has two dimensions namely ___________ and ___________", "radial, angular",
                    "diagonal, perpendicular", "tradial, perpendicular", "diagonal, angular"},
            {"Structured walkthrough is a", "Informal static testing",
                    "Dynamic testing technique", "Acceptance testing technique", "Formal static testing technique"},
            {
                    "Which of the following statements best describes the goal of DevOps?",
                    "Establish an environment to release more reliable applications faster",
                    "Establish an environment where the release of applications is valued more than its quality.",
                    "Establish an environment where application development performs all the operation tasks",
                    "Establish an environment where change management does not control application releases"
            },
            {"What are the advantages of the CMM model?",
                    "It guides towards repeatable standard processes and hence reduces the learning time on how to get things done.",
                    "CMM determines what a process should address instead of how it should be implemented.",
                    "Both of i and ii", "None of the above"
            },
            {
                "Define Capability Maturity Model ",
                "a framework which is used to analyse the approach and techniques followed by any " +
                        "organization to develop software products.",
                "development method which concentrates specifically on how to manage tasks within a team-based development environment",
                "a software development approach which involves Continuous Development and Continuous Testing",
                "software development methodology that uses minimal planning in favor of rapid prototyping"
            },
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_expert_main);
        question = findViewById(R.id.question);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        // Create quizArray from level1.
        for (int i = 0; i < level3.length; i++) {

            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(level3[i][0]); // Country
            tmpArray.add(level3[i][1]); // Right Answer
            tmpArray.add(level3[i][2]); // Choice1
            tmpArray.add(level3[i][3]); // Choice2
            tmpArray.add(level3[i][4]); // Choice3

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