package com.tourism.tourism.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String getIdByUsername(String username) {
        return userRepository.getIdByUsername(username);
    }

    public UserLogin save(UserLogin userLogin) {
        this.validateUser(userLogin);
        userLogin.setPassword(encryptPassword(userLogin.getPassword()));
        return userRepository.save(userLogin);
    }

    public void validateUser(UserLogin userLogin) {
        if (Objects.isNull(userLogin.getUsername())) {
            throw new UserBadRequestException("User without username.");
        }
        Optional<UserLogin> userExistent = userRepository.findByUsername(userLogin.getUsername());
        if (userExistent.isPresent()) {
            throw new UserBadRequestException("User already registered.");
        }
        if (Objects.isNull(userLogin.getPassword())) {
            throw new UserBadRequestException("User without password.");
        }
        if (Objects.isNull(userLogin.getName())) {
            throw new UserBadRequestException("User without name.");
        }
        if (Objects.isNull(userLogin.getRole())) {
            throw new UserBadRequestException("User without role.");
        }
    }

    public String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
