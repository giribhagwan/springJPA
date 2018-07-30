package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.services.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "api/user")
@CrossOrigin(allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"}, methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserRepo userRepo;
    Map<String, Object> map = new HashMap<>();
    User user;
    @PostMapping(value = "/saveUser")
    public Callable<ResponseEntity<?>> saveUser(@RequestBody User newUser) {
        return () -> {
            map.clear();
            user = userRepo.save(newUser);
            if (user != null) {
                map.put("message", "Save successfully");
                map.put("user", user);
                return new ResponseEntity<Object>(map,HttpStatus.CREATED);
            } else {
                map.put("message", "something went wrong");
                return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
            }
        };
    }
    @PostMapping(value = "/login")
    public Callable<ResponseEntity<?>> login(@RequestBody LoginDto loginDto){
        return ()->{
            map.clear();
            user =userRepo.findByUserNameAndPassword(loginDto.getUserName(),loginDto.getPassword());
            if (user!=null){
                map.put("message","Login successfully");
                map.put("user",user);
                return ResponseEntity.ok(map);
            }
            else {
                map.put("message","Try again later");
                return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
            }
        };
    }
}
