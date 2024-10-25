package main;

import java.time.LocalDateTime;

public class UserTest {
    public Users initialUser() {
        Users user1 = new Users();
        user1.setUsername("Dungvd");
        user1.setCreatedAt(LocalDateTime.now());
        
        UserService userService = new UserService();
        userService.setUser(user1);

        Quizs quiz = new Quizs("Kiem tra giua ky", new Users(), 60);
        userService.joinQuiz(quiz);
        return user1;
    }
}
