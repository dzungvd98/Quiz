package main;

import java.time.LocalDateTime;
import java.util.HashSet;

public class UserService {
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public QuizDetails joinQuiz(Quizs quiz) {
        QuizDetails quizDetail = new QuizDetails();
        quizDetail.setUser(user);
        quizDetail.setQuiz(quiz);
        quizDetail.setStartedAt(LocalDateTime.now());

        if(user.getQuizDetails() == null) {
            user.setQuizDetails(new HashSet<>());
        }

        user.getQuizDetails().add(quizDetail);
        return quizDetail;
    }

    public int submitQuiz(QuizDetails quizDetails) {
        QuizService quizService = new QuizService();
        quizService.setQuiz(quizDetails.getQuiz());
        int totalScore = 0;
        LocalDateTime timeEndQuiz = quizDetails.getStartedAt().plusMinutes(quizDetails.getQuiz().getDuration());
        for(UserAnswers userAnswer : quizDetails.getUserAnswers()) {
            if(userAnswer.getSubmittedAt().isBefore(timeEndQuiz) && quizService.checkUserAnswerInQuiz(userAnswer)) {
                totalScore ++;
            }
        }
        quizDetails.setScore(totalScore);
        return totalScore;
    }
}
