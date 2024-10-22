package main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Quizs {
    private int id;
    private String name;
    private Users userCreated;
    private int duration;
    private LocalDateTime createdAt;
    private List<Users> participants;
    private Set<Question> questions;

    public Quizs(String name, Users userCreated, int duration) {
        this.name = name;
        this.userCreated = userCreated;
        this.duration = duration;
    }

    public Quizs() {
        //TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Users getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Users userCreated) {
        this.userCreated = userCreated;
    }

    public List<Users> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Users> participants) {
        this.participants = participants;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
