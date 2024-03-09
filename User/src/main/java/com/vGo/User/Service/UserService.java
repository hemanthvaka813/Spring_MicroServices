package com.vGo.User.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vGo.User.DTO.LoginDTO;
import com.vGo.User.Entity.User;
import com.vGo.User.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public String signUpUser(User user) {
		User userd=userRepo.saveAndFlush(user);
		if(userd==null) {
			return "Details ivvu ra Chambel";
		}
		else {
			return "SignUp Ayyindi rooo";
		}
	}
	public String signInUser(LoginDTO logins) {
		User cust=userRepo.findById(logins.getUserId()).get();
		if(cust==null) {
			return "Sign in Avvu ra Mundu";
		}
		else if(!cust.getPassword().equals(logins.getPassword())) {
			return "password Marchipoyav ra ";
		}
		else {
			return "Login Ayyav Royyy";
		}
	}

}
