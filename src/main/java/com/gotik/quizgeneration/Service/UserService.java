package com.gotik.quizgeneration.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.gotik.quizgeneration.Model.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserService {
    private List<Users> users = new ArrayList<>();

    public QuizUsers joinQuiz(Quizs quiz, Users user) {
        QuizUsers quizUser =  QuizUsers.builder()
                .user(user)
                .quiz(quiz)
                .startedAt(LocalDateTime.now())
                .build();

        quiz.getQuizUsers().add(quizUser);
        user.getQuizUsers().add(quizUser);
        return quizUser;
    }

    public boolean isUserAnswerCorrect(List<UserAnswers> userAnswers, Question question) {
        // Lấy ra danh sách câu trả lời của user trong câu hỏi
        List<UserAnswers> answerOfQuestions = getAnswerOfUserInQuestion(userAnswers, question);

        // Lấy ra các đáp án đúng cho câu hỏi
        List<AnswerOption> correctAnswer = getCorrectAnswerOfQuestion(question);

        if(question.getType().equals(QType.FILL_IN_BLANK)) {
            return isUserAnswerCorrectInFillInBlankQuestion(answerOfQuestions, correctAnswer);
        }

        if(answerOfQuestions.size() != correctAnswer.size()) {
            return  false;
        }

        // So sánh
        for(int i = 0; i < correctAnswer.size(); i++) {
            UserAnswers userAnswer = answerOfQuestions.get(i);
            AnswerOption answerOption = correctAnswer.get(i);
            if(userAnswer.getOrderIndex() != answerOption.getNumberCorrectAnswer() // Kiểm tra có trùng vị trí và đúng option chưa
                    || userAnswer.getAnswerOptionId() != answerOption.getId()) {
                return false;
            }
        }
        return true;
    }

    // Hàm lấy ra danh sách câu trả lời đúng của câu hỏi
    private List<AnswerOption> getCorrectAnswerOfQuestion(Question question) {
        return question.getAnswerOptions().stream()
                .filter(option -> option.getNumberCorrectAnswer() >= 1)
                .sorted(Comparator.comparing(AnswerOption::getNumberCorrectAnswer))
                .toList();
    }

    // Hàm lấy ra danh sách câu trả lời của người dùng cho câu hỏi
    private List<UserAnswers> getAnswerOfUserInQuestion(List<UserAnswers> userAnswers, Question question) {
        return userAnswers.stream()
                .filter(userAnswer -> userAnswer.getQuestionId() == question.getId())
                .sorted(Comparator.comparing(UserAnswers::getOrderIndex))
                .toList();
    }


    // Hàm kiểm tra user của làm đúng với trường hợp kiểu câu hỏi là fill in blank
    public boolean isUserAnswerCorrectInFillInBlankQuestion(List<UserAnswers> answerOfQuestions, List<AnswerOption> correctAnswer) {
        int count = 0;
        int positionCheck = 1;
        int i = 0, j = 0;
        while(i < answerOfQuestions.size() && j < correctAnswer.size()) {
            UserAnswers userAnswer = answerOfQuestions.get(i);
            AnswerOption answerOption = correctAnswer.get(j);
            if(userAnswer.getOrderIndex() == positionCheck && answerOption.getContent().equals(userAnswer.getAnswerText())) {
                count ++;
                positionCheck ++;
                i++;
            }
            j++;
        }

        return answerOfQuestions.size() == count;
    }

    public int submitQuiz(QuizUsers quizUser) {
        int countCorrect = 0;
        for(Question question : quizUser.getQuiz().getQuestions()) {
            if(isUserAnswerCorrect(quizUser.getUserAnswer(), question)) {
                countCorrect++;
            }
        }
        quizUser.setScore(countCorrect);
        return countCorrect;
    }
}
