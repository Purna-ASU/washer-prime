package com.prime.washer.controller;

import com.prime.washer.model.Users;
import com.prime.washer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")
public class UsersController {

    @Autowired
    private UserRepository usersRepository;

    @PostMapping("/add")
    public Users addUser(@RequestBody Users user) {
        return usersRepository.save(user);
    }

    @GetMapping("/fetch")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/fetch/{id}")
    public Optional<Users> getUser(@PathVariable Long id){
        return usersRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        usersRepository.deleteById(id);
    }
}