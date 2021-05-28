package com.tourism.tourism.auth;

import com.tourism.tourism.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/public/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserLoginService userLoginService;

    @PostMapping
    public ResponseEntity login(@RequestBody Map login) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    login.get("username"), login.get("password")
                            )
                    );

            String token = authService.generateToken(login.get("username").toString(), login.get("password").toString());
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping(path = "change-password")
    public ResponseEntity changePassword(@RequestBody Map credentials) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    credentials.get("username"), credentials.get("password")
                            )
                    );

            userLoginService.changePassword(credentials);
            String token = authService.generateToken(credentials.get("username").toString(), credentials.get("newPassword").toString());
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
