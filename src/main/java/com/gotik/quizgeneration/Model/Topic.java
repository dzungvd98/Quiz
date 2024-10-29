package com.gotik.quizgeneration.Model;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class Topic {
    private int id;
    private String name;
    private String description;
    @Builder.Default
    private Set<Question> questions = new HashSet<>();

}
