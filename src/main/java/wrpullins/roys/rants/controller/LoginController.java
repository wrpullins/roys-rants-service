package wrpullins.roys.rants.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wrpullins.roys.rants.dto.JwtToken;
import wrpullins.roys.rants.exceptions.UnauthorisedException;
import wrpullins.roys.rants.user.UserRepository;
import wrpullins.roys.rants.security.JwtUtil;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping
    public JwtToken login(@RequestBody Map<String, String> request) {
        return userRepository.findDistinctByUsernameAndPassword(request.get("username"), request.get("password"))
                .map(jwtUtil::createUserToken)
                .orElseThrow(() -> new UnauthorisedException("Invalid user credentials"));
    }

}
