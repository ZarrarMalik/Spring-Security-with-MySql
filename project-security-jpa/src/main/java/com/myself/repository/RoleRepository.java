package com.myself.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myself.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	

}
