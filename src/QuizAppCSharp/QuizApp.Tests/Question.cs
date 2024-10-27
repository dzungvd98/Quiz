
namespace QuizApp.Tests
{
    internal class Question
    {
        public string Title { get; set; }
        public string Content { get; set; }
        public int LevelId { get; set; }
        public string Type { get; set; }
        public int TopicId { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
    }
}