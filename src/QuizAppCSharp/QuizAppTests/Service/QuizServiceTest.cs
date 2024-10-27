using Microsoft.VisualStudio.TestTools.UnitTesting;
using QuizApp;
using QuizApp.Service;
using System;
using System.Collections.Generic;

namespace QuizAppTests.Service
{
    [TestClass]
    public class QuizServiceTest
    {
        public QuizService InitialQuizService()
        {
            Question question1 = new Question(1, "What is Java?", "Explain Java", new QuizApp.Type(1, "Single Choice"), new Level(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
            AnswerOption answer1 = new AnswerOption(1, "Option 1", 1);
            AnswerOption answer2 = new AnswerOption(2, "Option 2", 0);
            question1.AddAnswerOption(answer1);
            question1.AddAnswerOption(answer2);

            Question question2 = new Question(2, "What is C#?", "Explain See Sharp", new QuizApp.Type(2, "Multiple Choice"), new Level(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
            AnswerOption answer3 = new AnswerOption(3, "Option 3", 1);
            AnswerOption answer4 = new AnswerOption(4, "Option 4", 0);
            AnswerOption answer5 = new AnswerOption(5, "Option 5", 0);
            AnswerOption answer6 = new AnswerOption(6, "Option 6", 1);

            question2.AddAnswerOption(answer3);
            question2.AddAnswerOption(answer4);
            question2.AddAnswerOption(answer5);
            question2.AddAnswerOption(answer6);

            Question question3 = new Question(3, "Câu 1: Sắp xếp", "Sắp xếp các số sau theo thứ tự tăng dần?", new QuizApp.Type(3, "Orderred Choice"), new Level(1, "Level 1", "Vỡ lòng"), new Topic(1, "Toán", "Toán lớp 1"));
            AnswerOption answer7 = new AnswerOption(7, "2", 2);
            AnswerOption answer8 = new AnswerOption(8, "1", 1);
            AnswerOption answer9 = new AnswerOption(9, "4", 3);
            AnswerOption answer10 = new AnswerOption(10, "8", 4);

            question3.AddAnswerOption(answer7);
            question3.AddAnswerOption(answer8);
            question3.AddAnswerOption(answer9);
            question3.AddAnswerOption(answer10);

            User teacher = new User();
            teacher.Username = "Dao Vo"; 

            HashSet<Question> questions = new HashSet<Question>();
            questions.Add(question1);
            questions.Add(question2);
            questions.Add(question3);

            QuizService quizService = new QuizService();
            quizService.CreateQuiz("Java Basic", teacher, 60, questions);
            return quizService;
        }

        [TestMethod]
        public void TestCreateQuiz()
        {
            User teacher = new User();
            teacher.Username = "Dao Vo";

            Question question1 = new Question();
            Question question2 = new Question();

            HashSet<Question> questionSet = new HashSet<Question>();
            questionSet.Add(question1);
            questionSet.Add(question2);

            QuizService quizService = new QuizService();
            Quiz quiz = quizService.CreateQuiz("Java Basic", teacher, 60, questionSet);

            Assert.AreEqual(60, quiz.Duration);
            Assert.AreEqual(2, quiz.Questions.Count);
            Assert.AreEqual(teacher, quiz.UserCreated);
        }

        [TestMethod]
        public void TestCalculateScore()
        {
            QuizService quizService = InitialQuizService();

            UserAnswer userAnswer1 = new UserAnswer(1);
            AnswerOption answerOption = new AnswerOption(1, "Option 1");
            userAnswer1.AddAnswerOption(answerOption);

            UserAnswer userAnswer2 = new UserAnswer(2);
            AnswerOption answer3 = new AnswerOption(3, "Option 3");
            answer3.AnswerType = "M";
            AnswerOption answer6 = new AnswerOption(6, "Option 6");
            answer6.AnswerType = "M";

            userAnswer2.AddAnswerOption(answer6);
            userAnswer2.AddAnswerOption(answer3);

            UserAnswer userAnswer3 = new UserAnswer(3);
            AnswerOption answer7 = new AnswerOption(7, "2");
            AnswerOption answer8 = new AnswerOption(8, "1");
            AnswerOption answer9 = new AnswerOption(9, "4");
            AnswerOption answer10 = new AnswerOption(10, "8");
            userAnswer3.AddAnswerOption(answer8);
            userAnswer3.AddAnswerOption(answer7);
            userAnswer3.AddAnswerOption(answer9);
            userAnswer3.AddAnswerOption(answer10);

            List<UserAnswer> listUserAnswers = new List<UserAnswer>();
            listUserAnswers.Add(userAnswer1);
            listUserAnswers.Add(userAnswer2);
            listUserAnswers.Add(userAnswer3);


            int score = quizService.CalculateScore(listUserAnswers);
            Assert.AreEqual(3, score);
        }
    }
}
