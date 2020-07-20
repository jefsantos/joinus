package com.joinus.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joinus.model.Post;
import com.joinus.service.CodeblogService;

@RestController
public class PostController {

	@Autowired
	CodeblogService codeblogService;

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeblogService.findAll();

		mv.addObject("posts", posts);

		return mv;
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeblogService.finfById(id);

		mv.addObject("post", post);

		return mv;
	}
	
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public ModelAndView getPostForm() {
		ModelAndView mv = new ModelAndView("PostForm");
		mv.getView();
		return mv;
	}
	
	
    @RequestMapping(value="/newpost", method=RequestMethod.POST)
    public ModelAndView savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
    	 ModelAndView mv = new ModelAndView("redirect:/newpost");
    	if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            
           return mv;
           
        }
        post.setData(LocalDate.now());
        codeblogService.save(post);
        return new  ModelAndView("redirect:/posts");
    }
	
	

}
