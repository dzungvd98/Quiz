package main;

import java.time.LocalDateTime;
import java.util.Set;

public class QuizService {
    private Quizs quiz;


    public Quizs createQuiz(String quizName, Users userCreated, int duration, Set<Question> questions) {
        quiz = new Quizs();
        quiz.setName(quizName);
        quiz.setUserCreated(userCreated);
        quiz.setDuration(duration);
        quiz.setQuestions(questions);
        quiz.setCreatedAt(LocalDateTime.now());
        return quiz;
    }


    public float calculateScore(Users participant) {
        if(quiz)
    }


}
