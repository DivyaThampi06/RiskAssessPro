package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

//public class Question {
//    private List<String> options = new ArrayList<>();
//  //  private String correctOption;
//    private String newQuestion;
//
//    public Question(String newQuestion, String ... options ) {
//        this.newQuestion = newQuestion;
//       // this.correctOption = correctOption;
//        this.options.add(options[0]);
//        this.options.add(options[1]);
//        this.options.add(options[2]);
//        this.options.add(options[3]);
//        this.options.add(options[4]);
//
//    }
//
//
//    public String getNewQuestion() {
//        return newQuestion;
//    }
//
//    public List<String> getOptions() {
//        return options;
//    }
//
////    public String getCorrectOption() {
////        return correctOption;
////    }
//}


import java.util.ArrayList;
import java.util.List;

public class Question {
    private List<String> options = new ArrayList<>();
    private String newQuestion;

    public Question(String newQuestion, String... options) {
        this.newQuestion = newQuestion;
        // Add options only if they are not empty
        for (String option : options) {
            if (!option.isEmpty()) {
                this.options.add(option);
            }
        }
    }

    public String getNewQuestion() {
        return newQuestion;
    }

    public List<String> getOptions() {
        return options;
    }
}
