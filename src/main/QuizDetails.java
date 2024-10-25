package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuizDetails {
    private int id;
    private Quizs quiz;
    private Users user;
    private Integer score;
    private LocalDateTime startedAt;
    private List<UserAnswers> userAnswers;

    
    public QuizDetails() {
        this.score = 0;
        this.userAnswers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quizs getQuiz() {
        return quiz;
    }

    public void setQuiz(Quizs quiz) {
        this.quiz = quiz;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }


    public void addUserAnswers(UserAnswers userAnswer) {
        if(userAnswers == null) {
            userAnswers = new ArrayList<>();
        }
        userAnswers.add(userAnswer);
    }

    public List<UserAnswers> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswers> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    
}
