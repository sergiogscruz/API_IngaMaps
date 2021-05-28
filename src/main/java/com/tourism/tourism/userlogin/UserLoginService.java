package com.tourism.tourism.userlogin;

import com.tourism.tourism.auth.dtos.ChangePasswordDto;
import com.tourism.tourism.userlogin.exceptions.UserLoginBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public void changePassword(ChangePasswordDto changePasswordDto) {
        validateNewPassword(changePasswordDto);
        Optional<UserLogin> userLogin = userLoginRepository.findByUsername(changePasswordDto.getUsername());
        userLogin.get().setPassword(encryptPassword(changePasswordDto.getNewPassword()));
        userLoginRepository.save(userLogin.get());
    }

    public void validateNewPassword(ChangePasswordDto changePasswordDto) {
        if (Objects.isNull(changePasswordDto.getNewPassword()) || changePasswordDto.getNewPassword().isBlank()) {
            throw new UserLoginBadRequestException("Without new password.");
        }
    }
}
