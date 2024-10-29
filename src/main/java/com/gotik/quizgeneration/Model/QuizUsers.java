package com.gotik.quizgeneration.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class QuizUsers {
    private int id;
    private Quizs quiz;
    private Users user;
    private Integer score;
    private LocalDateTime startedAt;
    @Builder.Default
    private List<UserAnswers> userAnswers = new ArrayList<>();

}
