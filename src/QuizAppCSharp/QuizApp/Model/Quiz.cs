using System;
using System.Collections.Generic;

namespace QuizApp
{
    public class Quiz
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public User UserCreated { get; set; }
        public int Duration;
        public DateTime CreatedAt { get; set; }
        public List<User> Participants { get; set; }
        public HashSet<Question> Questions { get; set; }

        public Quiz()
        {
            this.Participants =  new List<User>();
            Questions = new HashSet<Question>();
        }
    }
}