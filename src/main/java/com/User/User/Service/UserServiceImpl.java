package com.User.User.Service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User.User.Controller.ApiResponse;
import com.User.User.Dao.UserDao;
import com.User.User.Entity.User;
import com.User.User.Function.ChangePasswordDto;
import com.User.User.Function.LoginDto;
import com.User.User.Function.SignUpDto;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDao userDao;
	
	
	
	@Override
    public ApiResponse signUp(SignUpDto signUpDto) {
        validateSignUp(signUpDto);
        User user = new User();
        BeanUtils.copyProperties(signUpDto, user);
        userDao.save(user);
        return new ApiResponse(200, "success", user);
    }
	
	@Override
    public ApiResponse login(LoginDto loginDto) {
        User user = userDao.findByUsername(loginDto.getUsername());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", null) ;

    }


	private void validateSignUp(SignUpDto signUpDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ApiResponse changePassword(ChangePasswordDto changePasswordDto) {
		// TODO Auto-generated method stub
		User user = userDao.findByUsername(changePasswordDto.getUsername());
		if(user==null) {
			throw new RuntimeException("User does not exist.");
		}
		if(!user.getPassword().equals(changePasswordDto.getOldpassword())){
            throw new RuntimeException("Old Password does not match.");
        }
		
		user.setPassword(changePasswordDto.getNewpassword());
		
		
		return new ApiResponse(200, "Password Changed successfully", null);
	}
	
	

}
