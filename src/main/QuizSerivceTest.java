package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class QuizSerivceTest {
    
     private QuizService quizService;
    private Users teacher;
    private Set<Question> questions;

    @Before
    public void setUp() {
        teacher = new Users();
        teacher.setUsername("daovo");

        // Initialize quizService and questions
        quizService = new QuizService();
        questions = new HashSet<>();
        questions.add(createQuestion(1, "What is Java?", createSingleChoiceOptions()));
        questions.add(createQuestion(2, "What is C#?", createMultipleChoiceOptions()));
        questions.add(createQuestion(3, "Sắp xếp các số?", createOrderedChoiceOptions()));
    }

    private Question createQuestion(int id, String title, Set<AnswerOption> options) {
        Question question = new Question(id, title, "Description", new Types(1, "Type"), new Levels(1, "Level", "Category"), new Topic(1, "Topic", "Category"));
        question.setAnswerOptions(options);
        return question;
    }

    private Set<AnswerOption> createSingleChoiceOptions() {
        Set<AnswerOption> options = new HashSet<>();
        options.add(new AnswerOption(1, "Option 1", 1));
        options.add(new AnswerOption(2, "Option 2", 0));
        return options;
    }

    private Set<AnswerOption> createMultipleChoiceOptions() {
        Set<AnswerOption> options = new HashSet<>();
        options.add(new AnswerOption(3, "Option 3", 1));
        options.add(new AnswerOption(4, "Option 4", 0));
        return options;
    }

    private Set<AnswerOption> createOrderedChoiceOptions() {
        Set<AnswerOption> options = new HashSet<>();
        options.add(new AnswerOption(7, "2", 2));
        options.add(new AnswerOption(8, "1", 1));
        return options;
    }

    @Test
    public void testCreateQuiz() {
        Quizs quiz = quizService.createQuiz("Java Basic", teacher, 60, questions);

        assertEquals("Duration should be 60", 60, quiz.getDuration());
        assertEquals("Should have 3 questions", 3, quiz.getQuestions().size());
        assertEquals("User should be the teacher", teacher, quiz.getUserCreated());
    }

    @Test
    public void testCalculateScore() {
        List<UserAnswers> userAnswers = createUserAnswers();
        int score = quizService.calculateScore(userAnswers);
        
        assertEquals("Score should be 3", 3, score);
    }

    private List<UserAnswers> createUserAnswers() {
        List<UserAnswers> listUserAnswers = new ArrayList<>();

        UserAnswers userAnswers1 = new UserAnswers(1);
        userAnswers1.addAnswerOption(new AnswerOption(1, "Option 1")); // Correct single choice
        listUserAnswers.add(userAnswers1);

        UserAnswers userAnswers2 = new UserAnswers(2);
        userAnswers2.addAnswerOption(new AnswerOption(3, "Option 3")); // Correct multiple choice
        listUserAnswers.add(userAnswers2);

        UserAnswers userAnswers3 = new UserAnswers(3);
        userAnswers3.addAnswerOption(new AnswerOption(8, "1")); // Correct ordered choice
        listUserAnswers.add(userAnswers3);

        return listUserAnswers;
    }


}
