package main;

import java.time.LocalDateTime;
import java.util.Set;

public class QuizDetails {
    private int id;
    private Quizs quiz;
    private Users user;
    private Float score;
    private LocalDateTime startedAt;
    private Set<UserAnswers> userAnswers;

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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public Set<UserAnswers> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswers> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
