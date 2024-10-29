package com.gotik.quizgeneration.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.gotik.quizgeneration.Model.AnswerOption;
import com.gotik.quizgeneration.Model.Question;

import com.gotik.quizgeneration.Model.Tags;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionService {
    public List<Question> questions = new ArrayList<>();

    public Question findById(int questionId) {
        return questions.stream()
                .filter(question -> question.getId() == questionId)
                .findFirst().orElse(null);
    }

    public Map<Integer, List<AnswerOption>> getCorrectAnswerMap(int questionId) {
        return Optional.ofNullable(findById(questionId))
                .map(question -> question.getAnswerOptions().stream()
                        .filter(answer -> answer.getNumberCorrectAnswer() >= 1)
                        .collect(Collectors.groupingBy(
                                AnswerOption::getNumberCorrectAnswer,
                                TreeMap::new,
                                Collectors.toList()
                        )))
                .orElse(null);
    }

    // Method to get string result of question
    public List<String> getCorrectAnswer(int questionId) {
        Map<Integer, List<AnswerOption>> mapCorrectAnswer = getCorrectAnswerMap(questionId);
        List<String> correctAnswerString = new ArrayList<>();


        for(Map.Entry<Integer, List<AnswerOption>> entry : mapCorrectAnswer.entrySet()) {
            List<AnswerOption> answerOptions = entry.getValue();
            StringBuilder result = new StringBuilder("[");
            int count = 0;
            for(AnswerOption option : answerOptions) {
                if(count > 0) result.append(", ");
                result.append(option.getContent());
                count ++;
            }
            result.append("]");
            correctAnswerString.add(result.toString());
        }
        return correctAnswerString;
    }

    // Method filter question by type, level, topic, tag
    public List<Question> filterQuestions(Integer topicId, Integer levelId, Integer typeId, Set<Tags> tags) {
        return questions.stream()
                .filter(q -> topicId == null || q.getTopic().getId() == topicId)
                .filter(q -> levelId == null || q.getLevel().getId() == levelId)
                .filter(q -> typeId == null || q.getType().getId() == typeId)
                .filter(q -> q.getTags().stream().anyMatch(tags::contains))
                .collect(Collectors.toList());

    }
}
