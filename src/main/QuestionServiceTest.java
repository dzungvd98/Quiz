package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuestionServiceTest {

    public Question initialSingleAnswerQuetion() {
        Question question1 = new Question(1, "What is Java?", "Explain Java", new Types(1, "Single Choice"), new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer1 = new AnswerOption(1, "Option 1", 1);
        AnswerOption answer2 = new AnswerOption(2, "Option 2", 0);
        question1.addAnswerOption(answer1);
        question1.addAnswerOption(answer2);
        return question1;
    }

    public Question initialMultipleAnswerQuetion() {
        Question question2 = new Question(1, "What is C#?", "Explain See Sharp", new Types(1, "Multiple Choice"), new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer3 = new AnswerOption(3, "Option 3", 1);
        AnswerOption answer4 = new AnswerOption(4, "Option 4", 0);
        AnswerOption answer5 = new AnswerOption(5, "Option 5", 0);
        AnswerOption answer6 = new AnswerOption(6, "Option 6", 1);

        question2.addAnswerOption(answer3);
        question2.addAnswerOption(answer4);
        question2.addAnswerOption(answer5);
        question2.addAnswerOption(answer6);
        return question2;
    }   

    public Question initialOrderredAnswerQuestion() {
        // Question question2 = new Question(1, "Câu 1: Lịch sử?", "... là người đánh bạn 29 vạn quân ... vào năm ...", new Types(1, "Orderred Choice"), new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        Question question1 = new Question(1, "Câu 1: Sắp xếp", "Sắp xếp các số sau theo thứ tự tăng dần?", new Types(3, "Orderred Choice"), new Levels(1, "Level 1", "Vỡ lòng"), new Topic(1, "Toán", "Toán lớp 1"));
        AnswerOption answer3 = new AnswerOption(3, "2", 2);
        AnswerOption answer4 = new AnswerOption(4, "1", 1);
        AnswerOption answer5 = new AnswerOption(5, "4", 3);
        AnswerOption answer6 = new AnswerOption(6, "8", 4);

        question1.addAnswerOption(answer3);
        question1.addAnswerOption(answer4);
        question1.addAnswerOption(answer5);
        question1.addAnswerOption(answer6);

        return question1;
    }


    @Test
    public void testGetNumberAnswerOptions() {
        Question question1 = initialSingleAnswerQuetion();
        assertEquals(2, question1.getAnswerOptions().size());
    }

    @Test
    public void testGetCorrectAnswerOfSingleAnswerQuestion() {
        Question question1 = initialSingleAnswerQuetion();

        List<AnswerOption> correctAnswers = new ArrayList<>();
        correctAnswers.add(question1.getAnswerOptions().get(0));

        List<AnswerOption> answers = question1.getCorrectAnswers();
        
        assertEquals(correctAnswers, answers);
    }

    @Test
    public void testGetCorrectAnswerOfMultipleAnswerQuestion() {
        Question question1 = initialMultipleAnswerQuetion();
        AnswerOption answer3 = new AnswerOption(3, "Option 3", 1);
        AnswerOption answer6 = new AnswerOption(6, "Option 6", 1);


        List<AnswerOption> correctAnswers = new ArrayList<>();
        correctAnswers.add(answer3);
        correctAnswers.add(answer6);
        
        assertEquals(question1.getCorrectAnswers().get(0).toString(), answer3.toString());
    }

    @Test
    public void testGetCorrectAnswerOfOrderredQuestion() {
           Question question = initialOrderredAnswerQuestion();
           List<AnswerOption> userAnswer = new ArrayList<>();
           userAnswer.add(question.getAnswerOptions().get(1));
           userAnswer.add(question.getAnswerOptions().get(0));
           userAnswer.add(question.getAnswerOptions().get(2));
           userAnswer.add(question.getAnswerOptions().get(3));
           
           assertEquals(question.getCorrectAnswers(), userAnswer);
    }


}
