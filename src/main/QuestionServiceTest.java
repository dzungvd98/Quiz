package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

    public Question initialFillBlankQuestion() {
        Question question2 = new Question(1, "Câu 1: Lịch sử?", "... là người đánh bạn 29 vạn quân ... vào năm ...", new Types(1, "Orderred Choice"), new Levels(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
        AnswerOption answer1 = new AnswerOption(1, "Quang Trung", 1);
        AnswerOption answer2 = new AnswerOption(2, "Nguyễn Huệ", 1);
        AnswerOption answer3 = new AnswerOption(3, "Thanh", 2);
        AnswerOption answer4 = new AnswerOption(4, "1789", 3);
        AnswerOption answer5 = new AnswerOption(5, "Một ngàn bảy trăm tám mươi chín", 3);
        
        question2.addAnswerOption(answer1);
        question2.addAnswerOption(answer2);
        question2.addAnswerOption(answer3);
        question2.addAnswerOption(answer4);
        question2.addAnswerOption(answer5);

        return question2;
    }


    @Test
    public void testGetNumberAnswerOptions() {
        Question question1 = initialSingleAnswerQuetion();
        assertEquals(2, question1.getAnswerOptions().size());
    }


    @Test
    public void testGetCorrectAnswerOfMultipleAnswerQuestion() {
        Question question1 = initialMultipleAnswerQuetion();
        AnswerOption answer3 = new AnswerOption(3, "Option 3");
        AnswerOption answer6 = new AnswerOption(6, "Option 6");


        List<AnswerOption> userAnswer = new ArrayList<>();
        userAnswer.add(answer6);
        userAnswer.add(answer3);
        boolean isCorrect = question1.checkUserAnswer(userAnswer);
        assertEquals(true, isCorrect);
    }

    @Test
    public void testGetCorrectAnswerOfOrderredQuestion() {
           Question question = initialOrderredAnswerQuestion();
           List<AnswerOption> userAnswer = new ArrayList<>();
           userAnswer.add(question.getAnswerOptions().get(1));
           userAnswer.add(question.getAnswerOptions().get(0));
           userAnswer.add(question.getAnswerOptions().get(2));
           userAnswer.add(question.getAnswerOptions().get(3));
           
           assertTrue(question.checkUserAnswer(userAnswer));
    }

    @Test
    public void testGetCorrectAnswerOfFillBlankQuestion() {
        Question question = initialFillBlankQuestion();
        AnswerOption answer1 = new AnswerOption(1, "Quang Trung");
        AnswerOption answer2 = new AnswerOption(2, "Nguyễn Huệ");
        AnswerOption answer3 = new AnswerOption(3, "Thanh");
        AnswerOption answer4 = new AnswerOption(4, "1789");

        List<AnswerOption> userAnswer1 = new ArrayList<>();
        userAnswer1.add(answer1);
        userAnswer1.add(answer3);
        userAnswer1.add(answer4);

        List<AnswerOption> userAnswer2 = new ArrayList<>();
        userAnswer2.add(answer3);
        userAnswer2.add(answer2);
        userAnswer2.add(answer4);


        boolean isUserAnswerCorrect1 = question.checkUserAnswer(userAnswer1);
        boolean isUserAnswerCorrect2 = question.checkUserAnswer(userAnswer2);
        
        assertEquals(true, isUserAnswerCorrect1);
        assertNotEquals(true, isUserAnswerCorrect2);
    }
}
