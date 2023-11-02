package com.employee.management.controller;

import com.employee.management.model.UserRequest;
import com.employee.management.model.UserResponse;
import com.employee.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    UserResponse saveUser(@RequestBody UserRequest request) {
        return userService.saveUser(request);
    }

}
