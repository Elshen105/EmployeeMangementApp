package com.employee.management.service.impl;

import com.employee.management.entity.Department;
import com.employee.management.entity.User;
import com.employee.management.mapper.DepartmentMapper;
import com.employee.management.mapper.UserMapper;
import com.employee.management.model.DepartmentResponse;
import com.employee.management.model.UserRequest;
import com.employee.management.model.UserResponse;
import com.employee.management.repository.UserRepository;
import com.employee.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse saveUser(UserRequest request) {
        logger.info("ActionLog.saveUser.start request: {}", request);

        request.setPassword(passwordEncoder.encode(request.getPassword()));

        var user = UserMapper.INSTANCE.modelToEntity(request);
        var response = UserMapper.INSTANCE.entityToModel(userRepository.save(user));

            logger.info("ActionLog.saveUser.end response: {}", response);
        return response;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }
}
