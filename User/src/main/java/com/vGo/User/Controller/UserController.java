package com.vGo.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vGo.User.DTO.LoginDTO;
import com.vGo.User.Entity.User;
import com.vGo.User.Service.UserService;

import jakarta.validation.Valid;



@RestController
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@RequestMapping(value="/login" ,method=RequestMethod.POST,consumes = "application/json")
	public ResponseEntity<String> signInUser(@Valid @RequestBody LoginDTO login){
		String result="Neku Asalu Credentials Gurtunnaya";
		result= userServ.signInUser(login);
		return  new ResponseEntity<String>(result, HttpStatus.OK);
	}
	@RequestMapping(value="/register" ,method=RequestMethod.POST,consumes = "application/json")
	public ResponseEntity<String> signUpUser(@Valid @RequestBody User user){
		String result="Anni Fill Cheyyali Amma";
		result=userServ.signUpUser(user);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
