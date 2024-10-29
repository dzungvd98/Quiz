package com.gotik.quizgeneration.Model;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Tags {
    private int id;
    private String name;
    @Builder.Default
    private Set<Question> questions = new HashSet<>();

}
