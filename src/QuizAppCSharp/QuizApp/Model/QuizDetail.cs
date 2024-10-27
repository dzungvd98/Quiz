using System;
using System.Collections.Generic;

namespace QuizApp
{
    public class QuizDetail
    {
        public int Id {  get; set; }
        public Quiz Quiz { get; set; }
        public User User { get; set; }
        public int Score { get; set; }
        public DateTime StartedAt { get; set; }
        public List<UserAnswer> UserAnswers { get; set; }
    }
}