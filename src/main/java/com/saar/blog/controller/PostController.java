package com.saar.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saar.blog.payloads.PostDto;
import com.saar.blog.payloads.PostResponse;
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
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer id)
	{
		PostDto postDto1= postService.updatePost(postDto, id);
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
	ResponseEntity<List<PostDto>> getAllPostByUser(@PathVariable Integer id)
	{
		List<PostDto> postDtos= postService.getPostsByUser(id);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}
	
	
	@DeleteMapping ("/delete/{postId}")
	ResponseEntity<String> deletePost(@PathVariable Integer postId)
	{
		postService.deletePost(postId);
		return new ResponseEntity<String>("You Deleted postId is :"+postId,HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{postId}")
	ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
	{
		PostDto postDto=postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	
//	@GetMapping("/getAll")
//	ResponseEntity<List<PostDto>> getAllPost()
//	{
//		List<PostDto> postDtos= postService.getAllPost();
//		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
//	}
	
	
	@GetMapping("/getAll")
	ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value="pageNumber", defaultValue="1", required=false) Integer pageNumber,
			@RequestParam(value="pageSize", defaultValue="5", required=false) Integer pageSize
			)
	{
		PostResponse postDtos= postService.getAllPost(pageNumber, pageSize);
		return new ResponseEntity<PostResponse>(postDtos,HttpStatus.OK);
	}

}










