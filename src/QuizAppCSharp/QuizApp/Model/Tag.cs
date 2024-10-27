using System.Collections.Generic;

namespace QuizApp
{
    public class Tag
    {
        public int Id {  get; set; }
        public string Name { get; set; }
        public HashSet<Question> Questions { get; set; }
    }
}