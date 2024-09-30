package com.example.projAutenticator2Infnet.user;

import com.example.projAutenticator2Infnet.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    JwtService jwtService;

    @Autowired
    UserRepository userRepository;

    @Override
    public User creater(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if(existingUser != null){
            throw new Error("O usuário já existe");
        }
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        User createdUser = userRepository.save(user);
        return createdUser;
    }



}
