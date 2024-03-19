package com.rkweber.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rkweber.workshopmongo.domain.User;
import com.rkweber.workshopmongo.dto.UserDTO;
import com.rkweber.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource { // precisa do service
	
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // ou @Getmapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll(); // busco no banco os usuarios e guardo nesta lista
		List<UserDTO> listDto = list.stream().
								map(x -> new UserDTO(x)).
								collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST) // ou @Postmapping
 	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTo) {
		User obj = service.fromDTO(objDTo);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // pega o endereço do novo objeto inserido
		
		return ResponseEntity.created(uri).build();
	}
	
	
}
 