package com.myself.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myself.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
