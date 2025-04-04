package com.dkelly205.docker_tutorial.service.impl;

import com.dkelly205.docker_tutorial.dto.UserRequest;
import com.dkelly205.docker_tutorial.dto.UserResponse;
import com.dkelly205.docker_tutorial.entity.User;
import com.dkelly205.docker_tutorial.mapper.UserMapper;
import com.dkelly205.docker_tutorial.repository.UserRepository;
import com.dkelly205.docker_tutorial.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));    }
}
