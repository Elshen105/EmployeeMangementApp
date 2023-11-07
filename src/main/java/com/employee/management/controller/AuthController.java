package com.employee.management.controller;

import com.employee.management.model.UserRequest;
import com.employee.management.model.UserResponse;
import com.employee.management.service.UserService;
import com.employee.management.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/auth")
public class AuthController {

    private final UserService userService;

    private final JwtService jwtService;

    @PostMapping("/register")
    public UserResponse saveUser(@RequestBody UserRequest request) {
        return userService.saveUser(request);
    }

    @GetMapping("/generate-jwt/{username}")
    public String generateJwt(@PathVariable String username) {
        return jwtService.generateToken(userService.findByUsername(username));
    }

}
