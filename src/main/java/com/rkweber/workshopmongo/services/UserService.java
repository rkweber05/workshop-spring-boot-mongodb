package com.rkweber.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkweber.workshopmongo.domain.User;
import com.rkweber.workshopmongo.repository.UserRepository;

@Service
public class UserService { // precisa do repository

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){ // responsavel por retornar todos os usuários do meu banco de dados
		return repository.findAll(); //retorna todos os usuarios
	}
}
