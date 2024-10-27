using System.Collections.Generic;

namespace QuizApp
{
    public class Role
    {
        public int Id {  get; set; }
        public string RoleName { get; set; }
        public HashSet<User> Users { get; set; }

    }
}