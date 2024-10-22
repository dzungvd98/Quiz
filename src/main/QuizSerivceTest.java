package main;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class QuizSerivceTest {
    
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
        Question question1 = new Question(1, "What is Java?", "Explain Java", QType.SINGLE, new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer1 = new AnswerOption(1, "Option 1", true);
        AnswerOption answer2 = new AnswerOption(2, "Option 2", false);
        
        question1.addAnswerOption(answer1);
        question1.addAnswerOption(answer2);

        Question question2 = new Question(2, "What is C#?", "Explain See Sharp", QType.SINGLE, new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer3 = new AnswerOption(3, "Option 1", true);
        AnswerOption answer4 = new AnswerOption(4, "Option 2", false);

        question2.addAnswerOption(answer3);
        question2.addAnswerOption(answer4);

        QuizService quizService = new QuizService();
        float score = quizService.calculateScore();
    }

}
