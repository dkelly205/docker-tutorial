package com.dkelly205.docker_tutorial.repository;

import com.dkelly205.docker_tutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
