using System;
using System.Collections.Generic;

namespace QuizApp
{
    public class UserAnswer
    {
        public int Id { get; set; }
        public QuizDetail QuizDetail {  get; set; }
        public int QuestionId {  get; set; }
        public List<AnswerOption> AnswerOptions { get; set; }
        public DateTime SubmittedAt { get; set; }

        public UserAnswer()
        {
            AnswerOptions = new List<AnswerOption>();
        }

        public UserAnswer(int questionId)
        {
            QuestionId = questionId;
            AnswerOptions = new List<AnswerOption>();
        }

        public void AddAnswerOption(AnswerOption answerOption)
        {
            AnswerOptions.Add(answerOption);
        }
    }
}