package com.gotik.quizgeneration.Test;

import com.gotik.quizgeneration.Model.Question;
import com.gotik.quizgeneration.Model.Quizs;
import com.gotik.quizgeneration.Model.Users;
import com.gotik.quizgeneration.Service.QuizService;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class QuizServiceTest {
    private QuizService quizService;

    @Before
    public void setUp() {
        quizService = new QuizService();
    }

    public Quizs createNewQuiz() {
        Set<Question> questions = new HashSet<>();
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
}
