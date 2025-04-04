package com.dkelly205.docker_tutorial.controller;

import com.dkelly205.docker_tutorial.dto.UserRequest;
import com.dkelly205.docker_tutorial.dto.UserResponse;
import com.dkelly205.docker_tutorial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping(path="{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity.ok(userResponse);
    }
}
