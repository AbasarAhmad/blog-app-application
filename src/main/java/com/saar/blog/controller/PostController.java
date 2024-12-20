package com.saar.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saar.blog.payloads.PostDto;
import com.saar.blog.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	@PostMapping("/add/id/{id}/categoryId/{categoryId}")
	ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto, @PathVariable Integer id,@PathVariable Integer categoryId)
	{
		PostDto postDto1= postService.createPost(postDto, id, categoryId);
		return new ResponseEntity<PostDto>(postDto1,HttpStatus.CREATED);
	}
	
	// Get All posts of this category
	
	@GetMapping("/categoryId/{categoryId}")
	ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto> postDtos= postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}
	
	@GetMapping("/userId/{id}")
	ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer id)
	{
		List<PostDto> postDtos= postService.getPostsByUser(id);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}

}










