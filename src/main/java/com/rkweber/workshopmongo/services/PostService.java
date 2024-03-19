package com.rkweber.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkweber.workshopmongo.domain.Post;
import com.rkweber.workshopmongo.repository.PostRepository;
import com.rkweber.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService { // precisa do repository

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}
