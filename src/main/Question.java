package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Question {
    private int id;
    private String title;
    private String content;
    private Types type;
    private Levels level;
    private Topic topic;
    private List<AnswerOption> answerOptions;
    private List<Quizs> quizs;
    private Set<Tags> tags;

    public Question() {
        this.answerOptions = new ArrayList<>();
        this.quizs = new ArrayList<>();
        this.tags = new HashSet<>();
    }

    public Question(int id, String title, String content, Types type, Levels level, Topic topic) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.level = level;
        this.topic = topic;
        this.answerOptions = new ArrayList<>();
        this.quizs = new ArrayList<>();
        this.tags = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
  
    public Levels getLevel() {
        return level;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public List<Quizs> getQuizs() {
        return quizs;
    }

    public void setQuizs(List<Quizs> quizs) {
        this.quizs = quizs;
    }

    public Set<Tags> getTags() {
        return tags;
    }

    public void setTags(Set<Tags> tags) {
        this.tags = tags;
    }

    public void addAnswerOption(AnswerOption answerOption) {
        this.answerOptions.add(answerOption);
        answerOption.setQuestion(this);
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public List<AnswerOption> getCorrectAnswers() {
        switch (this.type.getTypeName()) {
            case "Single Choice":
                return getCorrectAnswerOptionOfSingleAndMultipleChoiceQuestion();
            case "Multiple Choice": 
                return getCorrectAnswerOptionOfSingleAndMultipleChoiceQuestion();
            case "Orderred Choice": 
                return getCorrectAnswerOptionsOfOrderredChoiceQuestion();
            default:
                break;
        }
        return null; 
    }

    public List<AnswerOption> getCorrectAnswerOptionOfSingleAndMultipleChoiceQuestion() {
        List<AnswerOption> result = answerOptions.stream()
                                    .filter(answerOption -> answerOption.getNumberCorrectAnswer() == 1)
                                    .collect(Collectors.toList());
        return result;
    }

    public List<AnswerOption> getCorrectAnswerOptionsOfOrderredChoiceQuestion() {
        List<AnswerOption> result = answerOptions.stream()
                                    .filter(answerOption -> answerOption.getNumberCorrectAnswer() >= 1)
                                    .sorted(Comparator.comparingInt(AnswerOption::getNumberCorrectAnswer))
                                    .collect(Collectors.toList());
        return result;
    }

    public Object getAnswerOfFillBlankQuestion() {
        
    }


}
