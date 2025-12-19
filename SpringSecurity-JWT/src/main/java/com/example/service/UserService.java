package com.example.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.UserInfo;
import com.example.repository.UserInfoRepository;

@Service
public class UserService {

    private final UserInfoRepository repo;
    private final PasswordEncoder encoder;

    public UserService(UserInfoRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public void addUser(UserInfo user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }
}
