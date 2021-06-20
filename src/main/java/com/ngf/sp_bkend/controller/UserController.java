package com.ngf.sp_bkend.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngf.sp_bkend.exception.ResourceNotFoundException;
import com.ngf.sp_bkend.model.User;
import com.ngf.sp_bkend.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get all users
    @GetMapping("/users")
    public List < User > getAllUsers() {
 //   	System.out.println("Passei get all users");
        return userRepository.findAll();
    }

    // get all users sort
    @GetMapping("/users/sort_by_id")
    public List < User > findAllUsers() {
 //   	System.out.println("Passei find all users sort");
        return userRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    
    // get users by FirstName rest api
    @GetMapping("/users/name/{firstName}")
    public List < User > findByFirstNameContaining(@PathVariable String firstName) {
        return userRepository.findByFirstNameContaining(firstName);
    }
    
    // get users by FirstName Sort rest api
    @GetMapping("/users/sort_by_name/{firstName}")
    public List < User > findAllSortById(@PathVariable String firstName) {
        return userRepository.findAllSortById(firstName);
    }
    
    // create user rest api
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        Calendar c = Calendar.getInstance();
    	user.setDataUltAlt(c);  	
//        System.out.println("Insert ==> data: " + c);
//      System.out.println("Passei POST ID..." + user.getId());
        return userRepository.save(user);
    }

    // get user by id rest api
    @GetMapping("/users/id/{id}")
    public ResponseEntity < User > getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("User not exist with id :" + id));
//        System.out.println("Passei get user by ID..." + id);
        return ResponseEntity.ok(user);
    }
    
 
    // update user rest api

    @PutMapping("/users/{id}")
    public ResponseEntity < User > updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("User not exist with id :" + id));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmailId(userDetails.getEmailId());
        user.setLogin(userDetails.getLogin());
        user.setSenha(userDetails.getSenha());
        user.setDataUltAlt(userDetails.getDataUltAlt());
        Calendar c = Calendar.getInstance();
        user.setDataUltAlt(c);
        User updatedUser = userRepository.save(user);
        System.out.println("Update ==> data: " + user.getLogin() + "id= " + user.getId());
        return ResponseEntity.ok(updatedUser);
    }

    // delete user rest api
    @DeleteMapping("/users/{id}")
    public ResponseEntity < Map < String, Boolean >> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("User not exist with id :" + id));

        userRepository.delete(user);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
//        System.out.println("passei Delete.....");
        return ResponseEntity.ok(response);
    }
}
