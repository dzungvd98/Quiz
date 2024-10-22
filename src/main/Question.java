package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question {
    private int id;
    private String title;
    private String content;
    private QType type;
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

    public Question(int id, String title, String content, QType type, Levels level, Topic topic) {
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

    public QType getType() {
        return type;
    }

    public void setType(QType type) {
        this.type = type;
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

    public List<AnswerOption> getCorrectAnswers() {
        List<AnswerOption> result = new ArrayList<>();
        for(AnswerOption answerOption : this.answerOptions) {
            if(answerOption.isCorrect()) {
                result.add(answerOption);
            }
        }

        if(type == QType.FILL_IN_BLANK) {   
            Collections.sort(result, Comparator.comparingInt(AnswerOption::getNumberOrder));
        }
        return result;
    }

    public boolean isCorrectAnswers(List<AnswerOption> userAnswers) {
        if(this.type != QType.FILL_IN_BLANK) {
            HashSet<AnswerOption> setCorrectAnswer = new HashSet<>(getCorrectAnswers());
            HashSet<AnswerOption> setUserAnswer = new HashSet<>(userAnswers);
            return setCorrectAnswer.equals(setUserAnswer);
        }

        return checkAnswerOfQuestionTypeFillInBlank(userAnswers);
    }

    public boolean checkAnswerOfQuestionTypeFillInBlank(List<AnswerOption> userAnswers) {
        List<AnswerOption> correctAnswers = this.getCorrectAnswers();
        if(userAnswers.size() != correctAnswers.size()) {
            return false;
        }

        for(int i = 0; i < userAnswers.size(); i++) {
            if(!correctAnswers.get(i).equals(userAnswers.get(i))) {
                return false;
            }
        }
        return true;
    }
}
