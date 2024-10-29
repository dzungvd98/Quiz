package com.gotik.quizgeneration.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gotik.quizgeneration.Model.Question;
import com.gotik.quizgeneration.Model.Quizs;

import com.gotik.quizgeneration.Model.Users;


public class QuizService {

    List<Quizs> quizs = new ArrayList<>();

    // Create new quiz
    public Quizs createQuiz(String quizName, Users userCreated, int duration, Set<Question> questions) {
        Quizs quiz = Quizs.builder()
                .name(quizName)
                .userCreated(userCreated)
                .duration(duration)
                .questions(questions)
                .createdAt(LocalDateTime.now())
                .build();
        quizs.add(quiz);
        return quiz;
    }

    // Check is user joined quiz
    public boolean isUserJoinQuiz(Users user, Quizs quiz) {
        return quiz.getQuizUsers().stream()
            .anyMatch(quizUser -> user.getId() == quizUser.getUser().getId());

    }

//    // Check number correct answer of User in quiz
//    public List<Integer> getOutComeOfUser(Users user, Quizs quiz) {
//        boolean isUserJoinQuiz = isUserJoinQuiz(user, quiz);
//        if(!isUserJoinQuiz) {
//            return null;
//        }
//
//    }
}
