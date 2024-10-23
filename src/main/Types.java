package main;

public class Types {
    private int id;
    private String typeName;
    private String description;

    public Types() {
    }

    public Types(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Types(int id, String typeName, String description) {
        this.id = id;
        this.typeName = typeName;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
