package main;

import java.util.HashSet;
import java.util.Set;

public class Subject {
    private String name;
    private String description;
    Set<Question> questions;

    public Subject() {
        this.questions = new HashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

}
