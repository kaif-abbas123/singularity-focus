package com.singularityFocus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singularityFocus.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	

}
