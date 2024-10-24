package main;

import java.time.LocalDateTime;

public class UserTest {
    public Users initialUser() {
        Users user1 = new Users();
        user1.setUsername("Dungvd");
        user1.setCreatedAt(LocalDateTime.now());

        Quizs quiz = new Quizs("Kiem tra giua ky", new Users(), 60);
        user1.joinQuiz(quiz);
        QuizService quizService = new QuizService();

        return user1;
        
    }
}
