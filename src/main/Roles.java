package main;

import java.util.Set;

public class Roles {
    private int id;
    private String roleName;
    private Set<Users> users;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Set<Users> getUsers() {
        return users;
    }
    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
