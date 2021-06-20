package com.ngf.sp_bkend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ngf.sp_bkend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByFirstNameContaining(String firstName);

//	@Query (value = "SELECT * FROM User WHERE firstName like %?1% ORDER BY id", nativeQuery = true)
	@CrossOrigin(origins = "http://localhost:3000/users/sort_by_name/")
	@Query ("SELECT u FROM User u WHERE u.firstName like %?1% ORDER BY u.id")
	List<User> findAllSortById(String firstName);
	
}
