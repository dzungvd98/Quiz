using Microsoft.VisualStudio.TestTools.UnitTesting;
using QuizApp.Service;
using QuizApp;
using System;
using System.Collections.Generic;

namespace QuizAppTests.Service
{
    [TestClass]
    public class UserServiceTest
    {
        public UserService InitialUserService()
        {
            User user1 = new User();
            user1.Username = "Dungvd";
            user1.CreateAt = DateTime.Now;
            

            UserService userService = new UserService();
            userService.User = user1;

            return userService;
        }

        public Quiz InitialQuiz()
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

            Question question3 = new Question(3, "Câu 1: Sắp xếp", "Sắp xếp các số sau theo thứ tự tăng dần?", new QuizApp.Type(3, "Ordered Choice"), new Level(1, "Level 1", "Vỡ lòng"), new Topic(1, "Toán", "Toán lớp 1"));
            AnswerOption answer7 = new AnswerOption(7, "2", 2);
            AnswerOption answer8 = new AnswerOption(8, "1", 1);
            AnswerOption answer9 = new AnswerOption(9, "4", 3);
            AnswerOption answer10 = new AnswerOption(10, "8", 4);

            question3.AddAnswerOption(answer7);
            question3.AddAnswerOption(answer8);
            question3.AddAnswerOption(answer9);
            question3.AddAnswerOption(answer10);

            User teacher = new User
            {
                Username = "daovo"
            };

            HashSet<Question> questions = new HashSet<Question>
            {
                question1,
                question2,
                question3
            };

            QuizService quizService = new QuizService();
            quizService.CreateQuiz("Java Basic", teacher, 60, questions);
            return quizService.Quiz;
        }

        [TestMethod]
        public void TestUserSubmitQuiz()
        {
            UserService userService = InitialUserService();
            Quiz quiz = InitialQuiz();
            QuizDetail quizDetail = userService.JoinQuiz(quiz);

            UserAnswer userAnswers1 = new UserAnswer(1);
            AnswerOption answer1 = new AnswerOption(1, "Option 1");
            userAnswers1.AddAnswerOption(answer1);

            UserAnswer userAnswers2 = new UserAnswer(2);
            AnswerOption answer3 = new AnswerOption(3, "Option 3");
            AnswerOption answer6 = new AnswerOption(6, "Option 6");
            userAnswers2.AddAnswerOption(answer6);
            userAnswers2.AddAnswerOption(answer3);

            UserAnswer userAnswers3 = new UserAnswer(3);
            AnswerOption answer7 = new AnswerOption(7, "2");
            AnswerOption answer8 = new AnswerOption(8, "1");
            AnswerOption answer9 = new AnswerOption(9, "4");
            AnswerOption answer10 = new AnswerOption(10, "8");
            userAnswers3.AddAnswerOption(answer8);
            userAnswers3.AddAnswerOption(answer7);
            userAnswers3.AddAnswerOption(answer9);
            userAnswers3.AddAnswerOption(answer10);

            List<UserAnswer> listUserAnswers = new List<UserAnswer> { userAnswers1, userAnswers2, userAnswers3 };

            quizDetail.UserAnswers = listUserAnswers;

            Assert.AreEqual(3, userService.SubmitQuiz(quizDetail));
        }
    }
}
