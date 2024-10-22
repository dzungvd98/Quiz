package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuestionServiceTest {

    public Question initialSingleAnswerQuetion() {
        Question question1 = new Question(1, "What is Java?", "Explain Java", QType.SINGLE, new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer1 = new AnswerOption(1, "Option 1", true);
        AnswerOption answer2 = new AnswerOption(2, "Option 2", false);
        question1.addAnswerOption(answer1);
        question1.addAnswerOption(answer2);
        return question1;
    }

    public Question initialMultipleAnswerQuetion() {
        Question question2 = new Question(1, "What is C#?", "Explain See Sharp", QType.MULTIPLE, new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer3 = new AnswerOption(3, "Option 3", true);
        AnswerOption answer4 = new AnswerOption(4, "Option 4", false);
        AnswerOption answer5 = new AnswerOption(5, "Option 5", false);
        AnswerOption answer6 = new AnswerOption(6, "Option 6", true);

        question2.addAnswerOption(answer3);
        question2.addAnswerOption(answer4);
        question2.addAnswerOption(answer5);
        question2.addAnswerOption(answer6);
        return question2;
    }

    @Test
    public void testGetNumberAnswerOptions() {
        Question question1 = initialSingleAnswerQuetion();
        assertEquals(2, question1.getAnswerOptions().size());
    }

    @Test
    public void getCorrectAnswerOfSingleAnswerQuestion() {
        Question question1 = initialSingleAnswerQuetion();

        List<AnswerOption> correctAnswers = new ArrayList<>();
        correctAnswers.add(question1.getAnswerOptions().get(0));

        List<AnswerOption> answers = question1.getCorrectAnswers();
        
        assertEquals(correctAnswers, answers);
    }

    @Test
    public void getCorrectAnswerOfMultipleAnswerQuestion() {
        Question question1 = initialMultipleAnswerQuetion();

        List<AnswerOption> correctAnswers = new ArrayList<>();
        correctAnswers.add(question1.getAnswerOptions().get(0));
        correctAnswers.add(question1.getAnswerOptions().get(3));

        List<AnswerOption> answers = question1.getCorrectAnswers();
        
        assertEquals(correctAnswers, answers);
    }

    @Test
    public void getCorrectAnswerOfFillInBlankQuestion() {
           
    }
}
