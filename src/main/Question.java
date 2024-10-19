package main;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String title;
    private String content;
    private QType type;
    private Subject subject;
    private List<AnswerOption> answerOptions;
    private Level level;

    public Question() {
        answerOptions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public QType getType() {
        return type;
    }
    public void setType(QType type) {
        this.type = type;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }
    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public void addAnswerOption(AnswerOption newAnswer) {
        this.answerOptions.add(newAnswer);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<AnswerOption> getCorrectAnswerOfQuestion() {
        List<AnswerOption> correctAnswerList = new ArrayList<>();
        for(AnswerOption answer : answerOptions) {
            if(answer.isCorrect()) {
                correctAnswerList.add(answer);
            }
        }
        return correctAnswerList;
    }
}
