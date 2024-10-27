namespace QuizApp
{
    public class Type
    {
        public int Id {  get; set; }
        public string Name { get; set; }
        public string Description { get; set; }

        public Type(int id, string name)
        {
            Id = id;
            Name = name;
        }
    }
}