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

    public User save(User user) {
        this.validateUser(user);
        user.setPassword(encryptPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public void validateUser(User user) {
        if (Objects.isNull(user.getUsername())) {
            throw new UserBadRequestException("User without username.");
        }
        Optional<User> userExistent = userRepository.findByUsername(user.getUsername());
        if (userExistent.isPresent()) {
            throw new UserBadRequestException("User already registered.");
        }
        if (Objects.isNull(user.getPassword())) {
            throw new UserBadRequestException("User without password.");
        }
        if (Objects.isNull(user.getName())) {
            throw new UserBadRequestException("User without name.");
        }
        if (Objects.isNull(user.getRole())) {
            throw new UserBadRequestException("User without role.");
        }
    }

    public String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
