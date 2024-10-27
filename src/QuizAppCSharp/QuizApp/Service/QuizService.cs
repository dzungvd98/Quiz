using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuizApp.Service
{
    public class QuizService
    {
        public Quiz Quiz { get; set; }

        public Quiz CreateQuiz(string quizName, User userCreated, int duration, HashSet<Question> questions)
        {
            Quiz = new Quiz();
            Quiz.Name = quizName;
            Quiz.UserCreated = userCreated;
            Quiz.Duration = duration;
            Quiz.Questions = questions;
            Quiz.CreatedAt = DateTime.Now;
            return Quiz;
        }

        public int CalculateScore(List<UserAnswer> userAnswers)
        {
            int score = 0;
            foreach (UserAnswer userAnswer in userAnswers)
            {
                if(CheckUserAnswerInQuiz(userAnswer))
                {
                    score++;
                }
            }
            return score;
        }

        public bool CheckUserAnswerInQuiz(UserAnswer userAnswer)
        {
            if (userAnswer == null) return false;
            foreach (Question question in Quiz.Questions)
            {
                if (question.Id == userAnswer.QuestionId)
                {
                    return question.CheckUserAnswer(userAnswer.AnswerOptions);
                }
            }
            return false;
        }

        public void AddQuestion(Question question)
        {
            Quiz.Questions.Add(question);
        }
    }
}
