package main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class QuizService {
    private Quizs quiz;

    public Quizs getQuiz() {
        return quiz;
    }

    public void setQuiz(Quizs quiz) {
        this.quiz = quiz;
    }

    public Quizs createQuiz(String quizName, Users userCreated, int duration, Set<Question> questions) {
        quiz = new Quizs();
        quiz.setName(quizName);
        quiz.setUserCreated(userCreated);
        quiz.setDuration(duration);
        quiz.setQuestions(questions);
        quiz.setCreatedAt(LocalDateTime.now());
        return quiz;
    }

    // public List< getScoreOfUserInQuiz(Users user) {
    //     for(QuizDetails quizDetail : user.getQuizDetails()) {
    //         if(quizDetail.getQuiz().getId() == quiz.getId()) {

    //         }
    //     }
    // }

    public int calculateScore(List<UserAnswers> allUserAnswer) {
        int score = 0;
        for(UserAnswers userAnswers : allUserAnswer) {
            if(checkUserAnswerInQuiz(userAnswers)) {
                score ++;
            }
        }
        return score;
    }

    public boolean checkUserAnswerInQuiz(UserAnswers userAnswer) {
        if(userAnswer == null || userAnswer.getQuestionId() == null) return false;
        for(Question quest : quiz.getQuestions()) {
            if(quest.getId() == userAnswer.getQuestionId()) {
                System.out.println(quest.getId());
                return quest.checkUserAnswer(userAnswer.getUserAnswer());
            }
        }
        return false;
    }


    public void addQuestion(Question question1) {
        quiz.addQuestion(question1);
    }


}
