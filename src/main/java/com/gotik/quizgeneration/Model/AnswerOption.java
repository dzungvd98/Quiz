package com.gotik.quizgeneration.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AnswerOption {
    private int id;
    private Question question;
    private String content;
    private int numberCorrectAnswer;
    private String answerType;
}
