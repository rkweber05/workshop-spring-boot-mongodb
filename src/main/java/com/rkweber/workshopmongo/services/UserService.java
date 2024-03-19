package com.rkweber.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkweber.workshopmongo.domain.User;
import com.rkweber.workshopmongo.dto.UserDTO;
import com.rkweber.workshopmongo.repository.UserRepository;
import com.rkweber.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService { // precisa do repository

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){ // responsavel por retornar todos os usuários do meu banco de dados
		return repository.findAll(); //retorna todos os usuarios
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
	
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
