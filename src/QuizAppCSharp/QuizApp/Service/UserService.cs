using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuizApp.Service
{
    public class UserService
    {
        public User User { get; set; }
        public UserService() { 
        
        }

        public QuizDetail JoinQuiz(Quiz quiz)
        {
            QuizDetail quizDetail = new QuizDetail();
            quizDetail.User = User;
            quizDetail.Quiz = quiz;
            quizDetail.StartedAt = DateTime.Now;

            if(User.QuizDetails == null)
            {
                User.QuizDetails = new HashSet<QuizDetail>();
            }

            User.QuizDetails.Add(quizDetail);
            return quizDetail;
        }

        public int SubmitQuiz(QuizDetail quizDetail)
        {
            QuizService quizService = new QuizService();
            quizService.Quiz = quizDetail.Quiz;
            int totalScore = 0;
            DateTime timeEndQuiz = quizDetail.StartedAt.AddMinutes(quizDetail.Quiz.Duration);
            foreach(UserAnswer userAnswer in quizDetail.UserAnswers) {
                if (userAnswer.SubmittedAt <= timeEndQuiz && quizService.CheckUserAnswerInQuiz(userAnswer))
                {
                    totalScore++;
                }
            }
            quizDetail.Score = totalScore;
            return totalScore;
        }
    }
}
