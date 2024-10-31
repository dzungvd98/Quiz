package com.gotik.quizgeneration.Test;

import com.gotik.quizgeneration.Model.*;
import com.gotik.quizgeneration.Service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    private UserService userService;
    private Quizs quiz;
    private Users user;

    @Before
    public void setUp() {
        userService = new UserService();
        quiz = Quizs.builder().build();
        user = Users.builder().build();

        Question question1 = createSampleSingleQuestion(); //
        Question question2 = createSampleMultipleChoiceQuestion();
        Question question3 = createSampleOrderredQuestion();
        Question question4 = createSampleFillInBlankQuestion();

        List<Question> questions = Arrays.asList(question1, question2, question3, question4);

        quiz.setQuestions(questions);
    }

    @Test
    public void testJoinQuiz() {
        userService.joinQuiz(quiz, user);
        assertEquals(1, quiz.getQuizUsers().size());
        assertEquals(1, user.getQuizUsers().size());
    }

    @Test
    public void testSubmitQuiz() {
        QuizUsers quizUser = userService.joinQuiz(quiz, user);
        List<UserAnswers> userSubmit = createSampleUserAnswer();
        quizUser.setUserAnswer(userSubmit);
        int numberCorrect = userService.submitQuiz(quizUser);

        assertEquals(4, numberCorrect);
    }

    public Question createSampleMultipleChoiceQuestion() {
        AnswerOption option1 = AnswerOption.builder().id(1).content("Answer 1").numberCorrectAnswer(1).build();
        AnswerOption option2 = AnswerOption.builder().id(2).content("Answer 2").numberCorrectAnswer(1).build();
        AnswerOption option3 = AnswerOption.builder().id(3).content("Answer 3").numberCorrectAnswer(0).build();
        Question question = Question.builder().build();
        question.setId(1);
        question.setAnswerOptions(Arrays.asList(option1, option2, option3));
        question.setType(QType.MULTIPLE); // or QType.FILL_IN_BLANK, etc.
        return question;
    }

    public Question createSampleSingleQuestion() {
        AnswerOption option1 = AnswerOption.builder().id(4).content("Answer 4").numberCorrectAnswer(0).build();
        AnswerOption option2 = AnswerOption.builder().id(5).content("Answer 5").numberCorrectAnswer(1).build();
        AnswerOption option3 = AnswerOption.builder().id(6).content("Answer 6").numberCorrectAnswer(0).build();
        Question question = Question.builder().build();
        question.setId(2);
        question.setAnswerOptions(Arrays.asList(option1, option2, option3));
        question.setType(QType.SINGLE); // or QType.FILL_IN_BLANK, etc.
        return question;
    }

    public Question createSampleOrderredQuestion() {
        AnswerOption option1 = AnswerOption.builder().id(7).content("Answer 7").numberCorrectAnswer(2).build();
        AnswerOption option2 = AnswerOption.builder().id(8).content("Answer 8").numberCorrectAnswer(1).build();
        AnswerOption option3 = AnswerOption.builder().id(9).content("Answer 9").numberCorrectAnswer(3).build();
        Question question = Question.builder().build();
        question.setId(3);
        question.setAnswerOptions(Arrays.asList(option1, option2, option3));
        question.setType(QType.ORDERRED); // or QType.FILL_IN_BLANK, etc.
        return question;
    }

    public Question createSampleFillInBlankQuestion() {
        AnswerOption option1 = AnswerOption.builder().id(10).content("Answer 7").numberCorrectAnswer(1).build();
        AnswerOption option2 = AnswerOption.builder().id(11).content("Answer 8").numberCorrectAnswer(1).build();
        AnswerOption option3 = AnswerOption.builder().id(12).content("Answer 9").numberCorrectAnswer(2).build();
        Question question = Question.builder().build();
        question.setId(4);
        question.setAnswerOptions(Arrays.asList(option1, option2, option3));
        question.setType(QType.FILL_IN_BLANK); // or QType.FILL_IN_BLANK, etc.
        return question;
    }

    public List<UserAnswers> createSampleUserAnswer() {
        // Đáp án cho câu 1. Multiple
        UserAnswers userAnswer1 = UserAnswers.builder().answerOptionId(1).questionId(1).orderIndex(1).build();
        UserAnswers userAnswer2 = UserAnswers.builder().answerOptionId(2).orderIndex(1).questionId(1).build();

        // Đáp án cho câu 2 single
        UserAnswers userAnswer3 = UserAnswers.builder().answerOptionId(5).questionId(2).orderIndex(1).build();

        // Đáp án cho câu 3 orderred
        UserAnswers userAnswer4 = UserAnswers.builder().answerOptionId(8).questionId(3).orderIndex(1).build();
        UserAnswers userAnswer5 = UserAnswers.builder().answerOptionId(7).questionId(3).orderIndex(2).build();
        UserAnswers userAnswer6 = UserAnswers.builder().answerOptionId(9).questionId(3).orderIndex(3).build();

        // Đáp án cho câu 4 fill in blank
        UserAnswers userAnswer7 = UserAnswers.builder().questionId(4).orderIndex(1).answerText("Answer 7").build();
        UserAnswers userAnswer8 = UserAnswers.builder().questionId(4).orderIndex(2).answerText("Answer 9").build();

        return Arrays.asList(userAnswer1, userAnswer2, userAnswer3, userAnswer4, userAnswer5, userAnswer6, userAnswer7, userAnswer8);
    }

}
