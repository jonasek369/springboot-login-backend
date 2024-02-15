package me.jonas.login.service;

import me.jonas.login.model.User;
import me.jonas.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(@Autowired  UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean loginUser(User payloadUser) {
        Optional<User> e = userRepository.findById(payloadUser.getName());
        if (e.isEmpty()){
            return false;
        }else{
            User db_user = e.get();
            return db_user.getPasswordHash().equals(payloadUser.getPasswordHash());
        }
    }

    public boolean contains(User payloadUser) {
        return userRepository.existsById(payloadUser.getName());
    }

    public void add(User user) {
        userRepository.save(user);
    }
}
