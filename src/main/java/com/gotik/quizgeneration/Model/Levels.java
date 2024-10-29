package com.gotik.quizgeneration.Model;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Levels {
    private int id;
    private String name;
    private String description;
    private Set<Question> questions;
}
