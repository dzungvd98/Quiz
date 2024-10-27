using System.Collections.Generic;

namespace QuizApp
{
    public class Level
    {
        public int Id {  get; set; }
        public string Name {  get; set; }
        public string Description { get; set; }
        public HashSet<Question> Questions { get; set; }

        public Level(int id, string name, string description)
        {
            Id = id;
            Name = name;
            Description = description;
        }
    }
}