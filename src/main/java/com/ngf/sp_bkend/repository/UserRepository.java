package com.ngf.sp_bkend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngf.sp_bkend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByFirstNameContaining(String firstName);

}
