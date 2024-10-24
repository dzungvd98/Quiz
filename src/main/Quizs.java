package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
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

    public void addQuestion(Question question) {
        if(questions == null) {
            questions = new HashSet<>();
        }
        questions.add(question);
    }

    public void addParticipant(Users user) {
        if(participants == null) {
            participants = new ArrayList<>();
        }
        participants.add(user);

        QuizDetails quizDetail = new QuizDetails();
        quizDetail.setStartedAt(LocalDateTime.now());
        quizDetail.setUser(user);
        quizDetail.setQuiz(this);
    }
}
