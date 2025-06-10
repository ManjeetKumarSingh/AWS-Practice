package com.aws.dbdemo.controller;

import com.aws.dbdemo.dto.User;
import com.aws.dbdemo.dto.UserDetails;
import com.aws.dbdemo.model.UserModel;
import com.aws.dbdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GetUserController {

    private static final Logger log = LoggerFactory.getLogger(GetUserController.class);
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.ok(user);
    }


    @PostMapping("/saveUser")
    @Transactional
    public ResponseEntity<String> saveUser(@RequestBody UserModel UserModel){

        UserDetails userDetails = new UserDetails();
        userDetails.setUserAreaDetails(UserModel.getUserDetailsModel().getUserAreaDetails());

        User userObject = new User();
        userObject.setUserName(UserModel.getName());
        userObject.setUserEmail(UserModel.getEmail());

        userObject.setUserDetails(userDetails); // Setting the other class object here

        userRepository.save(userObject);
        return ResponseEntity.ok("User-Saved");
    }

    @GetMapping("/getUserByName/{name}")
    public ResponseEntity<List<User>> getUserByName(@PathVariable String name){
        List<User> userList = userRepository.getUserByUserName(name);
        return ResponseEntity.ok(userList);
    }

}
