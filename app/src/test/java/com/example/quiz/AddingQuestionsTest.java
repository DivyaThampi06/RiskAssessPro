package com.example.quiz;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class AddingQuestionsTest {

    private AddingQuestions addingQuestions;

    @Before
    public void setUp() {
        addingQuestions = Robolectric.buildActivity(AddingQuestions.class).create().get();
    }

    @Test
    public void testGetCorrectOption() {
        RadioButton optionA = new RadioButton(addingQuestions);
        optionA.setId(R.id.optionA);
        RadioButton optionB = new RadioButton(addingQuestions);
        optionB.setId(R.id.optionB);
        RadioButton optionC = new RadioButton(addingQuestions);
        optionC.setId(R.id.optionC);
        RadioButton optionD = new RadioButton(addingQuestions);
        optionD.setId(R.id.optionD);
        RadioButton optionE = new RadioButton(addingQuestions);
        optionE.setId(R.id.optionE);

        // Set the correct answer
        addingQuestions.option = "A";

        // Select option A
        addingQuestions.radioGroup.check(optionA.getId());
        addingQuestions.getCorrectOption(null);
        assertEquals(1, addingQuestions.quizScore);

        // Select option B
        addingQuestions.radioGroup.check(optionB.getId());
        addingQuestions.getCorrectOption(null);
        assertEquals(3, addingQuestions.quizScore);

        // Select option C
        addingQuestions.radioGroup.check(optionC.getId());
        addingQuestions.getCorrectOption(null);
        assertEquals(6, addingQuestions.quizScore);

        // Select option D
        addingQuestions.radioGroup.check(optionD.getId());
        addingQuestions.getCorrectOption(null);
        assertEquals(10, addingQuestions.quizScore);

        // Select option E
        addingQuestions.radioGroup.check(optionE.getId());
        addingQuestions.getCorrectOption(null);
        assertEquals(15, addingQuestions.quizScore);
    }

    @Test
    public void testCalculateScore() {
        assertEquals(1, addingQuestions.calculateScore("A"));
        assertEquals(2, addingQuestions.calculateScore("B"));
        assertEquals(3, addingQuestions.calculateScore("C"));
        assertEquals(4, addingQuestions.calculateScore("D"));
        assertEquals(5, addingQuestions.calculateScore("E"));
    }

    @Test
    public void testGetQuestion() {
        // Ensure the initial size of the questions list
        assertEquals(5, addingQuestions.questions.size());

        // Remove one question
        addingQuestions.getQuestion();

        // Ensure the size is decreased by one
        assertEquals(4, addingQuestions.questions.size());

        // Test whether the question and options are displayed correctly
        assertEquals("How would you describe your approach to saving and investing for retirement?", addingQuestions.questionLabels.getText());
        assertEquals("Novice", addingQuestions.option_A.getText().toString());
        assertEquals("Intermediate", addingQuestions.option_B.getText().toString());
        assertEquals("Advanced", addingQuestions.option_C.getText().toString());
        assertEquals(View.GONE, addingQuestions.option_D.getVisibility());
        assertEquals(View.GONE, addingQuestions.option_E.getVisibility());
    }
}
