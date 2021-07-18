package com.User.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.User.User.Function.ChangePasswordDto;
import com.User.User.Function.LoginDto;
import com.User.User.Function.SignUpDto;
import com.User.User.Service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
    public ApiResponse signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }
	
	@PostMapping("/users/login")
    public ApiResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
	
	@PostMapping("/users/changePassword")
	public ApiResponse changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
		return userService.changePassword(changePasswordDto);
	}

}
