package com.tejack.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejack.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
