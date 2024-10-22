package main;

public class AnswerOption {
    private int id;
    private Question question;
    private String content;
    private boolean isCorrect;
    private int numberOrder;
    
    public AnswerOption(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    public AnswerOption(int id, String content, boolean isCorrect) {
        this.id = id;
        this.content = content;
        this.isCorrect = isCorrect;
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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((question == null) ? 0 : question.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + (isCorrect ? 1231 : 1237);
        result = prime * result + numberOrder;
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
        if (question == null) {
            if (other.question != null)
                return false;
        } else if (!question.equals(other.question))
            return false;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (isCorrect != other.isCorrect)
            return false;
        if (numberOrder != other.numberOrder)
            return false;
        return true;
    }

    
}
