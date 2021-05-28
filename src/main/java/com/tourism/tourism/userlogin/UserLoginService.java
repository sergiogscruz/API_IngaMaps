package com.tourism.tourism.userlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserLoginService {
    @Autowired
    private UserLoginRepository userLoginRepository;

    public Long getIdByUsername(String username) {
        return userLoginRepository.getIdByUsername(username);
    }

    public UserLogin save(UserLogin userLogin) {
        this.validateUser(userLogin);
        userLogin.setPassword(encryptPassword(userLogin.getPassword()));
        return userLoginRepository.save(userLogin);
    }

    public void validateUser(UserLogin userLogin) {
        if (Objects.isNull(userLogin.getUsername())) {
            throw new UserLoginBadRequestException("User without username.");
        }
        Optional<UserLogin> userExistent = userLoginRepository.findByUsername(userLogin.getUsername());
        if (userExistent.isPresent()) {
            throw new UserLoginBadRequestException("User already registered.");
        }
        if (Objects.isNull(userLogin.getPassword())) {
            throw new UserLoginBadRequestException("User without password.");
        }
        if (Objects.isNull(userLogin.getName())) {
            throw new UserLoginBadRequestException("User without name.");
        }
        if (Objects.isNull(userLogin.getRole())) {
            throw new UserLoginBadRequestException("User without role.");
        }
    }

    public String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public void changePassword(Map credentials) {
        validateCredentialsToChangePassword(credentials);
        Optional<UserLogin> userLogin = userLoginRepository.findByUsername(credentials.get("username").toString());
        userLogin.get().setPassword(encryptPassword(credentials.get("newPassword").toString()));
        userLoginRepository.save(userLogin.get());
    }

    public void validateCredentialsToChangePassword(Map credentials) {
        if (Objects.isNull(credentials.get("newPassword")) || credentials.get("newPassword").toString().isBlank()) {
            throw new UserLoginBadRequestException("Without new password.");
        }
    }
}
