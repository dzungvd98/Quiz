package com.gotik.quizgeneration.Test;

import java.util.List;

import com.gotik.quizgeneration.Model.AnswerOption;
import com.gotik.quizgeneration.Model.Question;
import com.gotik.quizgeneration.Service.QuestionService;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


public class QuestionServiceTest {
    private QuestionService questionService;

    @Before
    public void setUp() {
        questionService = new QuestionService();
        initializeQuestions();
    }

    private void initializeQuestions() {
        questionService.getQuestions().addAll(List.of(
                createQuestion(1, List.of(
                        createAnswer("Option 1", 1),
                        createAnswer("Option 2", 0)
                )),
                createQuestion(2, List.of(
                        createAnswer("Option 5", 1),
                        createAnswer("Option 6", 1),
                        createAnswer("Option 7", 1),
                        createAnswer("Option 8", 0)
                )),
                createQuestion(3, List.of(
                        createAnswer("5", 2),
                        createAnswer("2", 1),
                        createAnswer("9", 4),
                        createAnswer("7", 3)
                )),
                createQuestion(4, List.of(
                        createAnswer("Quang Trung", 1),
                        createAnswer("Nguyen Hue", 1),
                        createAnswer("1789", 2)
                ))
        ));
    }

    private Question createQuestion(int id, List<AnswerOption> answers) {
        Question question = Question.builder().id(id).build();
        question.setAnswerOptions(answers);
        return question;
    }

    private AnswerOption createAnswer(String content, int numberCorrectAnswer) {
        return AnswerOption.builder()
                .content(content)
                .numberCorrectAnswer(numberCorrectAnswer)
                .build();
    }

    @Test
    public void testGetCorrectAnswerOfSingleChoiceQuestion() {
        List<String> listCorrectAnswer = questionService.getCorrectAnswer(1);
        assertEquals("[Option 1]", listCorrectAnswer.get(0));
    }

    @Test
    public void testGetCorrectAnswerOfMultipleChoiceQuestion() {
        List<String> listCorrectAnswer = questionService.getCorrectAnswer(2);
        assertEquals("[[Option 5, Option 6, Option 7]]", listCorrectAnswer.toString());
    }

    @Test
    public void testGetCorrectAnswerOfOrderedChoiceQuestion() {
        List<String> listCorrectAnswer = questionService.getCorrectAnswer(3);
        assertEquals("[[2], [5], [7], [9]]", listCorrectAnswer.toString());
    }

    @Test
    public void testGetCorrectAnswerOfFillInBlankQuestion() {
        List<String> listCorrectAnswer = questionService.getCorrectAnswer(4);
        assertEquals("[[Quang Trung, Nguyen Hue], [1789]]", listCorrectAnswer.toString());
    }
}
