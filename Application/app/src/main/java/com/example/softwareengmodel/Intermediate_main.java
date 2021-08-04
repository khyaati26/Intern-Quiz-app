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

public class Intermediate_main extends AppCompatActivity {

    private TextView question;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;

    private String rightAnswer ;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 15;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String level2[][] = {

        // {"Question", "Right Answer", "Choice1", "Choice2", "Choice3"}

        {
          "What are the key components of DevOps?",
          "All of the above", "Continuous Delivery & Monitoring", "Continuous Testing", "Continuous Integration"
        },
        { "DevOps is an extension of ? ", "Agile", "Waterfall", "RAD model", "None of the above"},
        {"Which of these terms are level names in the Capability Maturity Model?",
                "Performed", "Repeated", "Optimized", "None of the above"
        },
        {"Which of the following is not a maturity level in CMM?", " Design", "Repeatable", "Managed", "Optimizing"},

        {"The CMM emphasizes?", "the need to record information", "continuous process improvement",
         "the need to accept quality system", "None of the above"
        },
        {"Which of the following is not associated with Agile Manufacturing?",
         "Slow approach", "Operator augmentation", "Bottom-up innovation", "Operational Flexibility"},
        {"Which of the following is not a reason for organizations to adopt flexible systems under agile manufacturing?",
         "Waterfall model", "Political factors", "Economic factors", "Increasing fluctuations in demand"
         },
        {"Agile Software Development is based on", "Both Incremental and Iterative Development",
                "Linear Development", "Iterative Development", "Incremental Development"
        },
        {"How is plan driven development different from agile development ?",
          " Iteration occurs within activities", " All of the mentioned",
                "Specification, design, implementation and testing are interleaved",
                "Outputs are decided through a process of negotiation during the software development process"
        },
        {"Which of the following does not apply to agility to a software process?	",
         "Eliminate the use of project planning and testing", "Only essential work products are produced",
         " Uses incremental product delivery strategy", "All of the mentioned"
        },
        {"Which of the following is not a validation activity", " Walkthroughs",
                "Acceptance testing", " System testing", " Unit testing"
        },
        {"Which of the following is not a verification activity", " Acceptance testing",
                "Inspections", "Walkthroughs", " Buddy check"},
        {"A planned meeting is also known as a", "Formal review", "Informal review",
                "Technical review ", "Dynamic review"},
        {"Which one of the following is not a phase of Prototyping Model?", "Coding",
                "Quick Design", "Prototype Refinement", "Engineer Product"},
        {"Which of the following statements regarding Build & Fix Model is wrong?",
                "It scales up well to large projects", "No room for structured design",
                "Code soon becomes unfixable & unchangeable", "Maintenance is practically not possible"
        },
        {"A model that is the demo implementation of the system.", "prototype",
                "waterfall", "incremental", "agile"},
        {"A stage in which individual components are integrated and ensured that they are error-free to meet customer requirements.",
                "Testing", "Coding", "Design", "Implementation"},
        {"___________ is a step in which design is translated into machine-readable form.",
                "Coding", "Design", "Conversion", "Debugging"}

    };


     @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intermediate_main);

         question = findViewById(R.id.question);
         answerBtn1 = findViewById(R.id.answerBtn1);
         answerBtn2 = findViewById(R.id.answerBtn2);
         answerBtn3 = findViewById(R.id.answerBtn3);
         answerBtn4 = findViewById(R.id.answerBtn4);

         // Create quizArray from level1.
         for (int i = 0; i < level2.length; i++) {

             // Prepare array.
             ArrayList<String> tmpArray = new ArrayList<>();
             tmpArray.add(level2[i][0]); // Country
             tmpArray.add(level2[i][1]); // Right Answer
             tmpArray.add(level2[i][2]); // Choice1
             tmpArray.add(level2[i][3]); // Choice2
             tmpArray.add(level2[i][4]); // Choice3

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



