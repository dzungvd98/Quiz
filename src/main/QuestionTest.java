package main;

import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuestionTest {
    
    public Question initialYesNoQuesion() {
        Question question = new Question();
        question.setType(QType.SINGLE);
        question.setContent("Is c# is the most popular language in the world?");
        question.setTitle("C Sharp Fundamental");
        question.setLevel(Level.EASY);

        AnswerOption answerOption1 = new AnswerOption(question, "yes", true);
        AnswerOption answerOption2 = new AnswerOption(question, "no", false);
        question.addAnswerOption(answerOption1);
        question.addAnswerOption(answerOption2);
        return question;
    }

    @Test
    public void getTypeOfQuestion() {
        Question question = initialYesNoQuesion();
        assertEquals(QType.SINGLE, question.getType());
    }
    
    @Test
    public void getCorrectAnswerOfQuestion() {
        Question question = initialYesNoQuesion();
        assertEquals("yes", question.getCorrectAnswerOfQuestion().get(0).getContent());
    }

    @Test
    public void getCorrectAnswerOfQuestionMultipleChoice() {
        Question question = new Question();
        question.setType(QType.MULTIPLE);  // Setting multiple correct answers type
        question.setContent("Which of the following are value types in C#?");
        question.setTitle("C Sharp Types");
        question.setLevel(Level.MEDIUM);

        AnswerOption answerOption1 = new AnswerOption(question, "int", true);
        AnswerOption answerOption2 = new AnswerOption(question, "string", false);
        AnswerOption answerOption3 = new AnswerOption(question, "bool", true);
        AnswerOption answerOption4 = new AnswerOption(question, "double", true);
        AnswerOption answerOption5 = new AnswerOption(question, "object", false);

        question.addAnswerOption(answerOption1);
        question.addAnswerOption(answerOption2);
        question.addAnswerOption(answerOption3);
        question.addAnswerOption(answerOption4);
        question.addAnswerOption(answerOption5);
        
        List<AnswerOption> correctAnswerList = new ArrayList<>();
        correctAnswerList.add(answerOption1);
        correctAnswerList.add(answerOption3);
        correctAnswerList.add(answerOption4);

        assertEquals(correctAnswerList , question.getCorrectAnswerOfQuestion());
    }


}
