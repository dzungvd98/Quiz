package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserAnswers {
    private int id;
    private QuizDetails quizDetails;
    private Integer questionId;
    private List<AnswerOption> userAnswer;
    private LocalDateTime submittedAt;

    public UserAnswers() {
        userAnswer = new ArrayList<>();
    }

    public UserAnswers(int questionId) {
        this.questionId = questionId;
        userAnswer = new ArrayList<>();
        submittedAt = LocalDateTime.now();

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

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

}
