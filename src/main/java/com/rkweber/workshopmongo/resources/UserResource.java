package com.rkweber.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rkweber.workshopmongo.domain.User;
import com.rkweber.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource { // precisa do service
	
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // ou @Getmapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll(); // busco no banco os usuarios e guardo nesta lista
		
		return ResponseEntity.ok().body(list);
	}
}
 