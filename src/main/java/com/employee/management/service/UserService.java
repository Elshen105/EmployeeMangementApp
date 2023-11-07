package com.employee.management.service;

import com.employee.management.entity.User;
import com.employee.management.model.UserRequest;
import com.employee.management.model.UserResponse;

import java.util.Optional;

public interface UserService {
    UserResponse saveUser(UserRequest request);

    User findByUsername(String username);
}
