package com.gotik.quizgeneration.Test;

import com.gotik.quizgeneration.Model.*;
import com.gotik.quizgeneration.Service.QuizService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class QuizServiceTest {
    private QuizService quizService;

    @Before
    public void setUp() {
        quizService = new QuizService();
        createNewQuiz();
    }

    public Quizs createNewQuiz() {
        List<Question> questions = new ArrayList<>();
        Question question1 = Question.builder().build();
        Question question2 = Question.builder().build();
        Question question3 = Question.builder().build();

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        Users teacher = Users.builder()
                .username("Dao Vo")
                .build();

        Quizs quiz = quizService.createQuiz("Kiem tra giua ky", teacher, 60, questions);
        return quiz;
    }

    @Test
    public void testCreateQuiz() {
        Quizs quiz = createNewQuiz();
        assertEquals(3, quiz.getQuestions().size());
        assertEquals(60, quiz.getDuration());
    }

    @Test
    public void testQuizActive() {
        Quizs quiz = quizService.getQuizs().get(0);

        boolean isActive = quizService.isQuizActive(quiz);
        assertEquals(true, isActive);

        quiz.setStartedAt(LocalDateTime.now().minusMinutes(1));
        isActive = quizService.isQuizActive(quiz);
        assertEquals(true, isActive);
    }

    @Test
    public void testGenerateQuiz_Succes() {
        String quizName = "Test Quiz";
        List<Question> questions = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            questions.add(Question.builder().content("Câu hỏi" + i).build());
        }

        Users userCreated = Users.builder().build();
        int duration = 30;
        Integer topicId = null;
        Integer levelId = null;
        QType type = null;
        Set<Tags> tags = null;
        int numberQuestion = 10;

        Quizs quiz = quizService.generateQuiz("Kiem tra",questions, userCreated, duration, topicId, levelId, type, tags, 10);

        assertEquals(10, quiz.getQuestions().size());

    }
}
