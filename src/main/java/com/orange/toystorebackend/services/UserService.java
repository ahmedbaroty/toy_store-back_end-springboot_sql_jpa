package com.orange.toystorebackend.services;

import com.orange.toystorebackend.entities.User;
import com.orange.toystorebackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByMailAndPassword(String mail, String password) {
      return userRepository.findByEmailAndPassword(mail, password);
    }

    public User getUser(Integer userId) {
        return userRepository.findOne(userId);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }


    public User getUserByEmail(String mail) {
        return userRepository.findByEmail(mail);
    }

    public void deleteUser(Integer userId) {
        userRepository.delete(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
