package main;

public class UserAnswers {
    private int id;
    private QuizDetails quizDetails;
    private Question question;
    private AnswerOption answerOption;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerOption getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(AnswerOption answerOption) {
        this.answerOption = answerOption;
    }

}
