using Microsoft.VisualStudio.TestTools.UnitTesting;
using QuizApp.Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuizApp.Service.Tests
{
    [TestClass()]
    public class QuestionServiceTests
    {
        public Question InitialSingleAnswerQuestion()
        {
            Question question1 = new Question(1, "What is Java?", "Explain Java", new Type(1, "Single Choice"), new Level(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
            
            AnswerOption answerOption1 = new AnswerOption(1, "Option 1", 1);
            AnswerOption answerOption2 = new AnswerOption(2, "Option 2", 0);
            
            question1.AddAnswerOption(answerOption1);
            question1.AddAnswerOption(answerOption2);
            
            return question1;
        }

        public Question InitialMultipleAnswerQuestion()
        {
            Question question = new Question(1, "What is C#?", "Explain See Sharp", new Type(1, "Multiple Choice"), new Level(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
           
            AnswerOption answer3 = new AnswerOption(3, "Option 3", 1);
            AnswerOption answer4 = new AnswerOption(4, "Option 4", 0);
            AnswerOption answer5 = new AnswerOption(5, "Option 5", 0);
            AnswerOption answer6 = new AnswerOption(6, "Option 6", 1);

            question.AddAnswerOption(answer3);
            question.AddAnswerOption(answer4);
            question.AddAnswerOption(answer5);
            question.AddAnswerOption(answer6);

            return question;
        }

        public Question InitialOrderredAnswerQuestion()
        {
            Question question1 = new Question(1, "Câu 1: Sắp xếp", "Sắp xếp các số sau theo thứ tự tăng dần?", new Type(3, "Orderred Choice"), new Level(1, "Level 1", "Vỡ lòng"), new Topic(1, "Toán", "Toán lớp 1"));
            AnswerOption answer3 = new AnswerOption(3, "2", 2);
            AnswerOption answer4 = new AnswerOption(4, "1", 1);
            AnswerOption answer5 = new AnswerOption(5, "4", 3);
            AnswerOption answer6 = new AnswerOption(6, "8", 4);

            question1.AddAnswerOption(answer3);
            question1.AddAnswerOption(answer4);
            question1.AddAnswerOption(answer5);
            question1.AddAnswerOption(answer6);

            return question1;
        }

        public Question InitialFillBlankQuestion()
        {
            Question question2 = new Question(1, "Câu 1: Lịch sử?", "... là người đánh bạn 29 vạn quân ... vào năm ...", new Type(1, "Orderred Choice"), new Level(1, "Programming", "IT"), new Topic(1, "Programming", "IT"));
            AnswerOption answer1 = new AnswerOption(1, "Quang Trung", 1);
            AnswerOption answer2 = new AnswerOption(2, "Nguyễn Huệ", 1);
            AnswerOption answer3 = new AnswerOption(3, "Thanh", 2);
            AnswerOption answer4 = new AnswerOption(4, "1789", 3);
            AnswerOption answer5 = new AnswerOption(5, "Một ngàn bảy trăm tám mươi chín", 3);

            question2.AddAnswerOption(answer1);
            question2.AddAnswerOption(answer2);
            question2.AddAnswerOption(answer3);
            question2.AddAnswerOption(answer4);
            question2.AddAnswerOption(answer5);

            return question2;
        }

        [TestMethod]
        public void testGetCorrectAnswerOfMultipleAnswerQuestion()
        {
            Question question1 = InitialMultipleAnswerQuestion();
            AnswerOption answer3 = new AnswerOption(3, "Option 3");
            AnswerOption answer6 = new AnswerOption(6, "Option 6");


            List<AnswerOption> userAnswer = new List<AnswerOption>();
            userAnswer.Add(answer6);
            userAnswer.Add(answer3);
            bool isCorrect = question1.CheckUserAnswer(userAnswer);
            Assert.AreEqual(true, isCorrect);
        }

        [TestMethod]
        public void TestGetNumberAnswerOptions()
        {
            Question question1 = InitialSingleAnswerQuestion();
            Assert.AreEqual(2, question1.AnswerOptions.Count);
        }

        [TestMethod]
        public void TestGetCorrectAnswerOfMultipleAnswerQuestion()
        {
            Question question1 = InitialMultipleAnswerQuestion();
            AnswerOption answer3 = new AnswerOption(3, "Option 3");
            AnswerOption answer6 = new AnswerOption(6, "Option 6");

            List<AnswerOption> userAnswer = new List<AnswerOption> { answer6, answer3 };
            bool isCorrect = question1.CheckUserAnswer(userAnswer);
            Assert.AreEqual(true, isCorrect);
        }

        [TestMethod]
        public void TestGetCorrectAnswerOfOrderedQuestion()
        {
            Question question = InitialOrderredAnswerQuestion();
            List<AnswerOption> userAnswer = new List<AnswerOption>
        {
            question.AnswerOptions[1],
            question.AnswerOptions[0],
            question.AnswerOptions[2],
            question.AnswerOptions[3]
        };

            Assert.IsTrue(question.CheckUserAnswer(userAnswer));
        }

        [TestMethod]
        public void TestGetCorrectAnswerOfFillBlankQuestion()
        {
            Question question = InitialFillBlankQuestion();
            AnswerOption answer1 = new AnswerOption(1, "Quang Trung");
            AnswerOption answer2 = new AnswerOption(2, "Nguyen Hue");
            AnswerOption answer3 = new AnswerOption(3, "Thanh");
            AnswerOption answer4 = new AnswerOption(4, "1789");

            List<AnswerOption> userAnswer1 = new List<AnswerOption> { answer1, answer3, answer4 };
            List<AnswerOption> userAnswer2 = new List<AnswerOption> { answer3, answer2, answer4 };

            bool isUserAnswerCorrect1 = question.CheckUserAnswer(userAnswer1);
            bool isUserAnswerCorrect2 = question.CheckUserAnswer(userAnswer2);

            Assert.AreEqual(true, isUserAnswerCorrect1);
            Assert.AreNotEqual(true, isUserAnswerCorrect2);
        }
    }
}