package com.example.demo.DAO;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {
    private final UserRepository _userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return _userRepository.getUsersByName(username);
    }

    public boolean addUser(UserDTO userAdd) {
        User user = new User(userAdd.getName(), userAdd.getName());
        try {
            _userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
