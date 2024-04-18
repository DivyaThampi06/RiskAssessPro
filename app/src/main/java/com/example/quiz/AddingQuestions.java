package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddingQuestions extends AppCompatActivity {
    Button optionConfirm;
    String option;
    List<Question> questions;
    int quizScore;
    RadioButton option_A;
    RadioButton option_B;
    RadioButton option_C;
    RadioButton option_D;
    RadioButton option_E;
    RadioGroup radioGroup;
    TextView questionLabels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        optionConfirm = findViewById(R.id.confirm);
        questionLabels = findViewById(R.id.lblPergunta);
        option_A = findViewById(R.id.optionA);
        option_B = findViewById(R.id.optionB);
        option_C = findViewById(R.id.optionC);
        option_D = findViewById(R.id.optionD);
        option_E= findViewById(R.id.optionE);
        quizScore = 0;
        radioGroup = findViewById(R.id.radioGroup);

        questions = new ArrayList<Question>(){
            {
                add(new Question("How would you describe your approach to saving and investing for retirement?",  "Novice", "Intermediate","Advanced", "",""));
                add(new Question("How would you rate your comfort level with investing in high-risk financial products?",  "Novice", "Intermediate","Advanced", "",""));
                add(new Question("As I withdraw money from these investments, I plan to spend it over a period of...", "2 years or less", "3-5 years", "6-10 years","More than 11 years",""));
                add(new Question("My current and future income sources (for example, salary, social security, pensions) are...", "Very Unstable", "Unstable","Stable","Somewhat Stable", "Very Stable"));
                add(new Question("How do you perceive the relationship between risk and return in investing?",  "Very Risk-Averse", "Somewhat Risk-Averse","Neutral", "Somewhat Risk-Tolerant","Very Risk-Tolerant"));
            }
        };

        getQuestion();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        getQuestion();
    }

    public void getCorrectOption(View view) {
        int op = radioGroup.getCheckedRadioButtonId();

        switch (op){
            case R.id.optionA:
                option ="A";
                break;

            case R.id.optionB:
                option ="B";
                break;

            case R.id.optionC:
                option ="C";
                break;

            case R.id.optionD:
                option ="D";
                break;
            case R.id.optionE:
                option ="E";
                break;

            default:
                return;
        }

        int score = calculateScore(option);
        quizScore += score;
        radioGroup.clearCheck();

        Intent screen = new Intent(this, RightAnswerBuzz.class);
        startActivity(screen);

    }

     int calculateScore(String answer) {
        int score = 0;
        switch (answer) {
            case "A":
                score = 1;
                break;
            case "B":
                score = 2;
                break;
            case "C":
                score = 3;
                break;
            case "D":
                score = 4;
                break;
            case "E":
                score = 5;
                break;
        }
        return score;
    }

    protected void getQuestion() {
        if (questions.size() > 0) {
            Question q = questions.remove(0);
            questionLabels.setText(q.getNewQuestion());
            List<String> answers = q.getOptions();

            option_A.setText(answers.get(0));
            option_B.setText(answers.get(1));
            option_C.setText(answers.get(2));

            // Display option D and E for questions from 3 onwards
            if (answers.size() >= 4) {
                option_D.setVisibility(View.VISIBLE);
                option_D.setText(answers.get(3));
            } else {
                option_D.setVisibility(View.GONE);
            }

            if (answers.size() >= 5) {
                option_E.setVisibility(View.VISIBLE);
                option_E.setText(answers.get(4));
            } else {
                option_E.setVisibility(View.GONE);
            }
        } else {
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("score", quizScore);
            startActivity(intent);
            finish();
        }
    }




}
