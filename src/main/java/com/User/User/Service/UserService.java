package com.User.User.Service;

import com.User.User.Controller.ApiResponse;
import com.User.User.Function.ChangePasswordDto;
import com.User.User.Function.LoginDto;
import com.User.User.Function.SignUpDto;

public interface UserService {

	ApiResponse signUp(SignUpDto signUpDto);
	ApiResponse login(LoginDto loginDto);
	ApiResponse changePassword(ChangePasswordDto changePasswordDto);
	
	

}
