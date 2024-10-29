package com.gotik.quizgeneration.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Quizs {
    private int id;
    private String name;
    private Users userCreated;
    private int duration;
    private LocalDateTime createdAt;
    @Builder.Default
    private List<QuizUsers> quizUsers = new ArrayList<>();
    @Builder.Default
    private Set<Question> questions = new HashSet<>();
}
