package main;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {
     private UserService userService;
    private Quizs quiz;

    @Before
    public void setUp() {
        userService = createUserService();
        quiz = createQuiz();
    }

    private UserService createUserService() {
        Users user = new Users();
        user.setUsername("Dungvd");
        user.setCreatedAt(LocalDateTime.now());

        UserService service = new UserService();
        service.setUser(user);
        return service;
    }

    private Quizs createQuiz() {
        Question question1 = createQuestion(1, "What is Java?", new AnswerOption(1, "Option 1", 1), new AnswerOption(2, "Option 2", 0));
        Question question2 = createQuestion(2, "What is C#?", new AnswerOption(3, "Option 3", 1), new AnswerOption(4, "Option 4", 0), new AnswerOption(5, "Option 5", 0), new AnswerOption(6, "Option 6", 1));
        Question question3 = createQuestion(3, "Sắp xếp các số", new AnswerOption(7, "2", 2), new AnswerOption(8, "1", 1), new AnswerOption(9, "4", 3), new AnswerOption(10, "8", 4));

        Set<Question> questions = new HashSet<>(Arrays.asList(question1, question2, question3));
        
        Users teacher = new Users();
        teacher.setUsername("daovo");

        QuizService quizService = new QuizService();
        quizService.createQuiz("Java Basic", teacher, 60, questions);
        return quizService.getQuiz();
    }

    private Question createQuestion(int id, String content, AnswerOption... options) {
        Question question = new Question(id, content, "Explain", new Types(id, "Choice"), new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        for (AnswerOption option : options) {
            question.addAnswerOption(option);
        }
        return question;
    }

    private UserAnswers createUserAnswers(int questionId, AnswerOption... options) {
        UserAnswers userAnswers = new UserAnswers(questionId);
        for (AnswerOption option : options) {
            userAnswers.addAnswerOption(option);
        }
        return userAnswers;
    }

    @Test
    public void testUserSubmitQuiz() {
        QuizDetails quizDetail = userService.joinQuiz(quiz);

        List<UserAnswers> userAnswers = Arrays.asList(
            createUserAnswers(1, new AnswerOption(1, "Option 1")),
            createUserAnswers(2, new AnswerOption(3, "Option 3"), new AnswerOption(6, "Option 6")),
            createUserAnswers(3, new AnswerOption(8, "1"), new AnswerOption(7, "2"), new AnswerOption(9, "4"), new AnswerOption(10, "8"))
        );
        
        quizDetail.setUserAnswers(userAnswers);

        assertEquals(3, userService.submitQuiz(quizDetail));
    }
}
