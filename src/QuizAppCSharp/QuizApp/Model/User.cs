using System;
using System.Collections.Generic;

namespace QuizApp
{
    public class User
    {
        public int Id { get; set; }
        public string Username { get; set; }
        public string password { get; set; }
        public DateTime CreateAt { get; set; }
        public DateTime UpdateAt { get; set; }
        public HashSet<Role> Roles { get; set; }
        public HashSet<QuizDetail> QuizDetails { get; set; }
    }
}