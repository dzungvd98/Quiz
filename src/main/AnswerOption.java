package main;

public class AnswerOption {
    private int id;
    private Question question;
    private String content;
    private int numberCorrectAnswer;
    private String answerType;

    public AnswerOption(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public AnswerOption(String content, int correctAnswer) {
        this.content = content;
        this.numberCorrectAnswer = correctAnswer;
    }

    public AnswerOption(int id, String content, int correctAnswer) {
        this.id = id;
        this.content = content;
        this.numberCorrectAnswer = correctAnswer;
    }

    public AnswerOption(int id, String content, int correctAnswer, String answerType) {
        this.id = id;
        this.content = content;
        this.numberCorrectAnswer = correctAnswer;
        this.answerType = answerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumberCorrectAnswer() {
        return numberCorrectAnswer;
    }

    public void setNumberCorrectAnswer(int correctAnswer) {
        this.numberCorrectAnswer = correctAnswer;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AnswerOption other = (AnswerOption) obj;
        if (id != other.id)
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AnswerOption [id=" + id + ", content=" + content + "]";
    }

}
