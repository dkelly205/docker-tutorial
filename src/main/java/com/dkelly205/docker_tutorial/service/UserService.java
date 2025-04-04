package com.dkelly205.docker_tutorial.service;

import com.dkelly205.docker_tutorial.dto.UserRequest;
import com.dkelly205.docker_tutorial.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    UserResponse findById(Long id);
}
