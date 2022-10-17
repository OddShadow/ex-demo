package com.example.swagger.controller;

import com.example.swagger.param.UserParam;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户模块", description = "用户模块API")
public class UserController {

    @PostMapping
    public Boolean saveNewUser(@RequestBody UserParam userParam){
        return true;
    }

    @PutMapping
    public Boolean saveModifyUser(@RequestBody UserParam userParam){
        return true;
    }

    @GetMapping("/{id}")
    public Boolean getUser(@PathVariable("id") String id){
        return true;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable("id") String id){
        return true;
    }

}
