using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace QuizApp
{
    public class Topic
    {

        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public HashSet<Question> Questions { get; set; }

        public Topic(int id, string name, string description)
        {
            Id = id;
            Name = name;
            Description = description;
        }

    }
}
