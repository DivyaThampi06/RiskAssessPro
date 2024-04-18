package com.example.quiz;

import android.content.Intent;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
@SuppressWarnings("deprecation")
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class AddingQuestionsTest {

    private AddingQuestions addingQuestionsActivity;

    @Mock
    private TextView questionLabels;

    @Mock
    private RadioButton option_A;

    @Mock
    private RadioButton option_B;

    @Mock
    private RadioButton option_C;

    @Mock
    private RadioButton option_D;

    @Mock
    private RadioButton option_E;

    @Mock
    private RadioGroup radioGroup;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        addingQuestionsActivity = Robolectric.buildActivity(AddingQuestions.class).create().start().resume().get();
        addingQuestionsActivity.optionConfirm = mock(Button.class);
        addingQuestionsActivity.questionLabels = questionLabels;
        addingQuestionsActivity.option_A = option_A;
        addingQuestionsActivity.option_B = option_B;
        addingQuestionsActivity.option_C = option_C;
        addingQuestionsActivity.option_D = option_D;
        addingQuestionsActivity.option_E = option_E;
        addingQuestionsActivity.radioGroup = radioGroup;
    }

    @Test
    public void testGetCorrectOption() {
        option_A.setId(R.id.optionA);
        option_B.setId(R.id.optionB);
        option_C.setId(R.id.optionC);
        option_D.setId(R.id.optionD);
        option_E.setId(R.id.optionE);

        addingQuestionsActivity.optionConfirm.performClick();
        addingQuestionsActivity.optionConfirm.callOnClick();
        addingQuestionsActivity.option_A.performClick();
        addingQuestionsActivity.option_B.performClick();
        addingQuestionsActivity.option_C.performClick();
        addingQuestionsActivity.option_D.performClick();
        addingQuestionsActivity.option_E.performClick();

        // Test if the score is correctly calculated
        assertEquals(1, addingQuestionsActivity.calculateScore("A"));
        assertEquals(2, addingQuestionsActivity.calculateScore("B"));
        assertEquals(3, addingQuestionsActivity.calculateScore("C"));
        assertEquals(4, addingQuestionsActivity.calculateScore("D"));
        assertEquals(5, addingQuestionsActivity.calculateScore("E"));
    }

    @Test
    public void testGetQuestion() {
        addingQuestionsActivity.questions = new ArrayList<>();
        List<String> options = new ArrayList<>();
        options.add("Novice");
        options.add("Intermediate");
        options.add("Advanced");
        options.add("");
        options.add("");
        addingQuestionsActivity.questions.add(new Question("How would you describe your approach to saving and investing for retirement?", options.toArray(new String[0])));

        addingQuestionsActivity.getQuestion();

        assertNotNull(addingQuestionsActivity.questions);
        assertTrue(addingQuestionsActivity.questions.isEmpty());
    }

    @Test
    public void testOnRestart() {
        addingQuestionsActivity.onRestart();
        assertNotNull(addingQuestionsActivity);
    }
}
