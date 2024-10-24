package main;

import java.util.ArrayList;
import java.util.List;

public class UserAnswers {
    private int id;
    private QuizDetails quizDetails;
    private Integer questionId;
    private List<AnswerOption> userAnswer;

    public UserAnswers() {
        userAnswer = new ArrayList<>();
    }

    public UserAnswers(int questionId) {
        this.questionId = questionId;
        userAnswer = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public QuizDetails getQuizDetails() {
        return quizDetails;
    }

    public void setQuizDetails(QuizDetails quizDetails) {
        this.quizDetails = quizDetails;
    }

    public List<AnswerOption> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(List<AnswerOption> userAnswer) {
        this.userAnswer = userAnswer;
    }

    public void addAnswerOption(AnswerOption answerOption) {
        if(userAnswer == null) {
            userAnswer = new ArrayList<>();
        }
        userAnswer.add(answerOption);
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
