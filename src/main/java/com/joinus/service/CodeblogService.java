package com.joinus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joinus.model.Post;

@Service
public interface CodeblogService {
	
	List<Post> findAll();
	Post finfById(Long id);
	Post save (Post post);

}
