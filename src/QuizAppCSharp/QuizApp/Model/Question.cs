using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Activation;

namespace QuizApp
{
    public class Question
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Content { get; set; }
        public Type Type { get; set; }
        public Level Level { get; set; }
        public List<AnswerOption> AnswerOptions { get; set; }
        public List<Quiz> Quizs { get; set; }
        public HashSet<Tag> Tags { get; set; }
        public Topic Topic { get; set; }

        public Question()
        {
            AnswerOptions = new List<AnswerOption>();
            Quizs = new List<Quiz>();
            Tags = new HashSet<Tag>();
        }

        public Question(int id, string title, string content, Type type, Level level, Topic topic)
        {
            Id = id;
            Title = title;
            Content = content;
            Type = type;
            Level = level;
            Topic = topic;
            AnswerOptions = new List<AnswerOption>();
            Quizs = new List<Quiz>();
            Tags = new HashSet<Tag>();
        }

        public bool CheckUserAnswer(List<AnswerOption> userAnswer)
        {
            SortedDictionary<int, List<AnswerOption>> result = this.GetCorrectAnswers();
            if(this.Type.Name == "Multiple Choice")
            {
                return CheckUserAnswerForMultipleChoiceQuestion(result, userAnswer); 
            }

            if(result.Count != userAnswer.Count)
            {
                return false;
            }

            for(int i = 0; i < userAnswer.Count; i++)
            {
                AnswerOption answerOption = userAnswer[i];
                if (!ContainAnswerInList(answerOption, result[i + 1]))
                {
                    return false;
                }
            }
            return true; 
        }

        private bool ContainAnswerInList(AnswerOption answer, List<AnswerOption> answerOptions)
        {
            if(answerOptions.Contains(answer)) {
                return true;
            }
            return false;
        }

        private SortedDictionary<int, List<AnswerOption>> GetCorrectAnswers()
        {
            SortedDictionary<int, List<AnswerOption>> result = new SortedDictionary<int, List<AnswerOption>>();
            foreach(AnswerOption answerOption in AnswerOptions)
            {
                if(answerOption.NumberCorrectAnswer >= 1)
                {
                    if (!result.ContainsKey(answerOption.NumberCorrectAnswer))
                    {
                        
                        result[answerOption.NumberCorrectAnswer] = new List<AnswerOption>();
                    }
                    result[answerOption.NumberCorrectAnswer].Add(answerOption);
                    
                }
            }
            return result;
        }

        public bool CheckUserAnswerForMultipleChoiceQuestion(SortedDictionary<int, List<AnswerOption>> resultMap, List<AnswerOption> userAnswers)
        {
         
            List<AnswerOption> correctAnswers = resultMap.First().Value;
            foreach (AnswerOption answer in correctAnswers)
            {
                if (!userAnswers.Contains(answer))
                {
                    return false;
                }

            }
            return userAnswers.Count == correctAnswers.Count;
        }

        public void AddAnswerOption(AnswerOption answerOption)
        {
            answerOption.Question = this;
            AnswerOptions.Add(answerOption);
        }
    }

}