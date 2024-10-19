package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubjectTest {
    
    public Subject initialSubject() {
        Subject subject = new Subject();
        subject.setName("CSharp");
        subject.setDescription("Fundamental about CSharp For Beginners");
        
        Question question = new Question();
        question.setType(QType.SINGLE);
        question.setContent("Is c# is the most popular language in the world?");
        question.setTitle("C Sharp Fundamental");
        question.setLevel(Level.EASY);

        AnswerOption answerOption1 = new AnswerOption(question, "yes", true);
        AnswerOption answerOption2 = new AnswerOption(question, "no", false);
        question.addAnswerOption(answerOption1);
        question.addAnswerOption(answerOption2);

        subject.addQuestion(question);
        return subject;
    }

    @Test
    public void GetNumberQuestionOfSubject() {
        Subject subject = initialSubject();
        assertEquals(1, subject.getQuestions().size());
    }
}
