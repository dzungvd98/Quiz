package main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Users {
    private int id;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Quizs> quizs;
    private Set<Roles> roles;
    private Set<QuizDetails> quizDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Quizs> getQuizs() {
        return quizs;
    }

    public void setQuizs(List<Quizs> quizs) {
        this.quizs = quizs;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Set<QuizDetails> getQuizDetails() {
        return quizDetails;
    }

    public void setQuizDetails(Set<QuizDetails> quizDetails) {
        this.quizDetails = quizDetails;
    }

}