package com.gotik.quizgeneration.Model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Users {
    private int id;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Builder.Default
    private Set<QuizUsers> quizUsers = new HashSet<>();

}
