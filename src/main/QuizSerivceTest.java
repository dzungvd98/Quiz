package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class QuizSerivceTest {
    
    public QuizService initialQuiz() {
        Question question1 = new Question(1, "What is Java?", "Explain Java", new Types(1, "Single Choice"), new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer1 = new AnswerOption(1, "Option 1", 1);
        AnswerOption answer2 = new AnswerOption(2, "Option 2", 0);
        question1.addAnswerOption(answer1);
        question1.addAnswerOption(answer2);
 
        Question question2 = new Question(2, "What is C#?", "Explain See Sharp", new Types(2, "Multiple Choice"), new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer3 = new AnswerOption(3, "Option 3", 1);
        AnswerOption answer4 = new AnswerOption(4, "Option 4", 0);
        AnswerOption answer5 = new AnswerOption(5, "Option 5", 0);
        AnswerOption answer6 = new AnswerOption(6, "Option 6", 1);

        question2.addAnswerOption(answer3);
        question2.addAnswerOption(answer4);
        question2.addAnswerOption(answer5);
        question2.addAnswerOption(answer6);
        
        Question question3 = new Question(3, "Câu 1: Sắp xếp", "Sắp xếp các số sau theo thứ tự tăng dần?", new Types(3, "Orderred Choice"), new Levels(1, "Level 1", "Vỡ lòng"), new Topic(1, "Toán", "Toán lớp 1"));
        AnswerOption answer7 = new AnswerOption(7, "2", 2);
        AnswerOption answer8 = new AnswerOption(8, "1", 1);
        AnswerOption answer9 = new AnswerOption(9, "4", 3);
        AnswerOption answer10 = new AnswerOption(10, "8", 4);

        question3.addAnswerOption(answer7);
        question3.addAnswerOption(answer8);
        question3.addAnswerOption(answer9);
        question3.addAnswerOption(answer10);

        Users teacher = new Users();
        teacher.setUsername("daovo");

        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        
        QuizService quizService = new QuizService();
        quizService.createQuiz("Java Basic", teacher, 60, questions);
        return quizService;
    }

    @Test
    public void testCreateQuiz() {
        Users teacher = new Users();
        teacher.setUsername("daovo");

        Question question1 = new Question();
        question1.setTitle("What is Java?");

        Question question2 = new Question();
        question2.setTitle("What is Polymorphism");

        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);

        QuizService quizService = new QuizService();
        Quizs quiz = quizService.createQuiz("Java Basic", teacher, 60, questions);

        assertEquals(60, quiz.getDuration());
        assertEquals(2, quiz.getQuestions().size());
        assertEquals(teacher, quiz.getUserCreated());
    }   

    @Test
    public void testCalculateScore() {
        QuizService quizService = initialQuiz();
        
        UserAnswers userAnswers1 = new UserAnswers(1);
        AnswerOption answer1 = new AnswerOption(1, "Option 1");
        userAnswers1.addAnswerOption(answer1);

        UserAnswers userAnswers2 = new UserAnswers(2);
        AnswerOption answer3 = new AnswerOption(3, "Option 3");
        AnswerOption answer6 = new AnswerOption(6, "Option 6");
        userAnswers2.addAnswerOption(answer6);
        userAnswers2.addAnswerOption(answer3);

        UserAnswers userAnswers3 = new UserAnswers(3);
        AnswerOption answer7 = new AnswerOption(7, "2");
        AnswerOption answer8 = new AnswerOption(8, "1");
        AnswerOption answer9 = new AnswerOption(9, "4");
        AnswerOption answer10 = new AnswerOption(10, "8");
        userAnswers3.addAnswerOption(answer8);
        userAnswers3.addAnswerOption(answer7);
        userAnswers3.addAnswerOption(answer9);
        userAnswers3.addAnswerOption(answer10);

        List<UserAnswers> listUserAnswers = new ArrayList<>();
        listUserAnswers.add(userAnswers1);
        listUserAnswers.add(userAnswers2);
        listUserAnswers.add(userAnswers3);


        int score = quizService.calculateScore(listUserAnswers);

        assertEquals(3, score);
    }


}
