package com.example.quiz;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionTest {

    @Test
    public void testQuestionWithFiveOptions() {
        Question question = new Question("Question 1", "Option A", "Option B", "Option C", "Option D", "Option E");

        assertEquals("Question 1", question.getNewQuestion());

        List<String> options = question.getOptions();
        assertEquals(5, options.size());
        assertTrue(options.contains("Option A"));
        assertTrue(options.contains("Option B"));
        assertTrue(options.contains("Option C"));
        assertTrue(options.contains("Option D"));
        assertTrue(options.contains("Option E"));
    }

    @Test
    public void testQuestionWithThreeOptions() {
        Question question = new Question("Question 2", "Option A", "Option B", "Option C", "", "");

        assertEquals("Question 2", question.getNewQuestion());

        List<String> options = question.getOptions();
        assertEquals(3, options.size());
        assertTrue(options.contains("Option A"));
        assertTrue(options.contains("Option B"));
        assertTrue(options.contains("Option C"));
    }

    @Test
    public void testQuestionWithNoOptions() {
        Question question = new Question("Question 3");

        assertEquals("Question 3", question.getNewQuestion());

        List<String> options = question.getOptions();
        assertTrue(options.isEmpty());
    }
}

