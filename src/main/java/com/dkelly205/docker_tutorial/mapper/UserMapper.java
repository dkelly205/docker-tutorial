package com.dkelly205.docker_tutorial.mapper;

import com.dkelly205.docker_tutorial.dto.UserRequest;
import com.dkelly205.docker_tutorial.dto.UserResponse;
import com.dkelly205.docker_tutorial.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .email(userRequest.getEmail())
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }
}
