package com.gotik.quizgeneration.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.gotik.quizgeneration.Model.*;


public class QuizService {

    List<Quizs> quizs = new ArrayList<>();

    // Create new quiz
    public Quizs createQuiz(String quizName, Users userCreated, int duration, List<Question> questions) {
        Quizs quiz = Quizs.builder()
                .name(quizName)
                .userCreated(userCreated)
                .duration(duration)
                .questions(questions)
                .createdAt(LocalDateTime.now())
                .build();
        quizs.add(quiz);
        return quiz;
    }

    // Check is user joined quiz
    public boolean isUserJoinQuiz(Users user, Quizs quiz) {
        return quiz.getQuizUsers().stream()
            .anyMatch(quizUser -> user.getId() == quizUser.getUser().getId());

    }

    // Check history join of user in quiz
    public List<QuizUsers> getHistoryJoinQuizOfUser(Users user, Quizs quiz) {
        List<QuizUsers> outComeOfUserInQuizs = new ArrayList<>();
        boolean isUserJoinQuiz = isUserJoinQuiz(user, quiz);
        if(!isUserJoinQuiz) {
            return null;
        }

        return quiz.getQuizUsers().stream()
                .filter(quizUser -> quizUser.getUser().getId() == user.getId())
                .collect(Collectors.toList());
    }

    public Quizs generateQuiz(String quizName, List<Question> questions,
                              Users userCreated,
                              int duration,
                              Integer topicId,
                              Integer levelId,
                              QType type,
                              Set<Tags> tags,
                              int numberQuestion) {
        QuestionService questionService = new QuestionService();
        questionService.setQuestions(questions);


        List<Question> questionInQuiz = questionService.filterQuestions(topicId, levelId, type, tags);
        if(questionInQuiz.size() < numberQuestion) {
            throw new RuntimeException("Not enough question to create quiz");
        }

        List<Question> questionOfQuiz = getUniqueRandomQuestion(questions, numberQuestion);
        Quizs quiz = createQuiz(quizName, userCreated, duration, questionOfQuiz);

        return quiz;
    }

    // Hàm lấy random một số câu hỏi từ danh sách câu hỏi
    public  List<Question> getUniqueRandomQuestion(List<Question> questions, int numberOfQuestion) {
        Collections.shuffle(questions);
        return questions.subList(0, numberOfQuestion);
    }


}
