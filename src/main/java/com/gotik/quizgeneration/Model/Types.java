package com.gotik.quizgeneration.Model;

public class Types {
    private int id;
    private QType type;
    private String description;

    public Types() {
    }

    public Types(int id, QType type) {
        this.id = id;
        this.type = type;
    }

    public Types(int id, QType type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QType getType() {
        return type;
    }

    public void setType(QType type) {
        this.type = type;
    }
}
