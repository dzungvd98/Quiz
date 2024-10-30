package com.gotik.quizgeneration.Model;

import java.util.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Question {
    private int id;
    private String title;
    private String content;
    private QType type;
    private Levels level;
    private Topic topic;
    @Builder.Default
    private List<AnswerOption> answerOptions = new ArrayList<>();
    @Builder.Default
    private List<Quizs> quizs = new ArrayList<>();
    @Builder.Default
    private Set<Tags> tags = new HashSet<>();

}
