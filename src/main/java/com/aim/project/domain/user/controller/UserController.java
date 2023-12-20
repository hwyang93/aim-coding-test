package com.aim.project.domain.user.controller;

import com.aim.project.domain.user.dto.UserDto;
import com.aim.project.domain.user.dto.UserLoginDto;
import com.aim.project.domain.user.dto.UserSignUpDto;
import com.aim.project.domain.user.service.UserService;
import com.aim.project.global.config.ResponseResult;
import com.aim.project.global.config.ResponseService;
import com.mysql.cj.log.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "User API")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseResult<UserDto> signUp(@RequestBody UserSignUpDto userDto) {
        System.out.println(userDto);
        return new ResponseService().getResponseResult(userService.signUp(userDto));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult<UserDto> login(@RequestBody UserLoginDto userDto) {
        return new ResponseService().getResponseResult(userService.login(userDto));
    }
}
