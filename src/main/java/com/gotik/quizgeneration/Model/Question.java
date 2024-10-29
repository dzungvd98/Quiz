package com.gotik.quizgeneration.Model;

import java.util.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Question {
    private int id;
    private String title;
    private String content;
    private Types type;
    private Levels level;
    private Topic topic;
    @Builder.Default
    private List<AnswerOption> answerOptions = new ArrayList<>();
    @Builder.Default
    private List<Quizs> quizs = new ArrayList<>();
    @Builder.Default
    private Set<Tags> tags = new HashSet<>();

    public void addAnswerOption(AnswerOption answerOption) {
        this.answerOptions.add(answerOption);
        answerOption.setQuestion(this);
    }

    public Map<Integer, List<AnswerOption>> getCorrectAnswers() {
        Map<Integer, List<AnswerOption>> result = new TreeMap<>();
        for(AnswerOption answerOption : answerOptions) {
            if(answerOption.getNumberCorrectAnswer() >=1) {
                result.computeIfAbsent(answerOption.getNumberCorrectAnswer(), k->new ArrayList<>()).add(answerOption);
            }
        }
        return result;
    }

    public boolean checkUserAnswer(List<AnswerOption> userAnswers) {
        
        Map<Integer, List<AnswerOption>> result = this.getCorrectAnswers();

        if(this.type.getType().equals(QType.MULTIPLE)) {
            return checkUserAnswerForMutilpleChoiceQuestion(result, userAnswers);
        }

        if(result.size() != userAnswers.size()) {
            return false;
        }
        
        for(int i = 1; i <= userAnswers.size(); i++) {
            AnswerOption answer = userAnswers.get(i-1);
            if(!containAnswerInList(answer, result.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean containAnswerInList(AnswerOption answer, List<AnswerOption> listAnswerOptions) {
        for(AnswerOption ans : listAnswerOptions) {
            if(ans.toString().equals(answer.toString())) {
                System.out.println(ans);
                return true;
            }
        }
        return false;
    }

    public boolean checkUserAnswerForMutilpleChoiceQuestion(Map<Integer, List<AnswerOption>> resultMap, List<AnswerOption> userAnswers) {
        List<AnswerOption> correctAnswers = resultMap.get(1);
        return userAnswers.containsAll(correctAnswers);
    }

}
