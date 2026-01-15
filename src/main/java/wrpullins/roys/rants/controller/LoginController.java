package wrpullins.roys.rants.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wrpullins.roys.rants.dto.JwtToken;
import wrpullins.roys.rants.exceptions.UnauthorisedException;
import wrpullins.roys.rants.security.JwtUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final JwtUtil jwtUtil;

    public LoginController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // Hardcoded credentials for now
    private static final String HARDCODED_USER = "admin";
    private static final String HARDCODED_PASS = "password123";

    @PostMapping
    public JwtToken login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        if (HARDCODED_USER.equals(username) && HARDCODED_PASS.equals(password)) {
            return JwtToken
            		.builder()
            		.token(jwtUtil.generateToken(username,"Roy", "Pullins", "w.r.pullins@gmail.com"))
            		.build();
        } else {
            throw new UnauthorisedException("Invalid user credentials");
        }
    }

}
