package com.gotik.quizgeneration.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class UserAnswers {
    private int id;
    private QuizUsers quizUsers;
    private Integer questionId;
    private List<AnswerOption> userAnswer;
    private LocalDateTime submittedAt;
}
