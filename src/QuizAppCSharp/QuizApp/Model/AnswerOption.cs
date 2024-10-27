using System;
using System.Collections.Generic;

namespace QuizApp
{
    public class AnswerOption
    {
        public AnswerOption(int id, string content, int numberCorrectAnswer)
        {
            Id = id;
            Content = content;
            NumberCorrectAnswer = numberCorrectAnswer;
        }
        public AnswerOption(int id, string content)
        {
            Id = id;
            Content = content;
        }

        public int Id {  get; set; }
        public Question Question { get; set; }
        public string Content { get; set; }
        public int NumberCorrectAnswer { get; set; }
        public string AnswerType { get; set; }

        public override bool Equals(object obj)
        {
            return obj is AnswerOption option &&
                   Id == option.Id &&
                   Content == option.Content;
        }

        public override int GetHashCode()
        {
            int hashCode = 1058685026;
            hashCode = hashCode * -1521134295 + Id.GetHashCode();
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Content);
            return hashCode;
        }

    }
}