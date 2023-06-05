package org.example.backend.service;

import org.example.backend.repository.UserRepository;
import org.example.entity.User;

import java.util.List;

public class UserService {
    UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    // Câu 2:
    public List<User> getUserByProject (int id) {
        return userRepository.getUserByProject(id);
    }

    // Câu 3:
    public List<User> getManagerEachProject() {
        return userRepository.getManagerEachProject();
    }

    // Câu 4:
    public void login(String email, String password) {
        userRepository.login(email, password);
    }
}
