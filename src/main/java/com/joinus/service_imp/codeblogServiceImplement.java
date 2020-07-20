package com.joinus.service_imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joinus.model.Post;
import com.joinus.repository.PostRepository;
import com.joinus.service.CodeblogService;

@Service
public class codeblogServiceImplement implements CodeblogService{
	
	@Autowired
	PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post finfById(Long id) {
		return postRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		
		return postRepository.save(post);
	}

}
