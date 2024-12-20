package com.saar.blog.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saar.blog.entity.Category;
import com.saar.blog.entity.Post;
import com.saar.blog.entity.User;
import com.saar.blog.exception.ResourceNotFoundException;
import com.saar.blog.payloads.PostDto;
import com.saar.blog.repositories.CategoryRepo;
import com.saar.blog.repositories.PostRepo;
import com.saar.blog.repositories.UserRepo;
import com.saar.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private UserRepo userRepo;
	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
	Category category=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Id", categoryId));
	User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
	Post post= this.modelMapper.map(postDto,Post.class);
	post.setImgName("default.png");
	post.setAddeddate(new Date());
	post.setCategory(category);
	post.setUser(user);
	
	Post newPost=this.postRepo.save(post);
	PostDto postDto2=this.modelMapper.map(newPost, PostDto.class);
	return postDto2;
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		//Post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "id", postId));
		
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category category=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Id", categoryId));
		List<Post> posts=postRepo.findByCategory(category);
		List<PostDto>postDtos=posts.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
		List<Post> posts=postRepo.findAllByUser(user);
		 List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post, PostDto.class)) // Correct mapping
		            .collect(Collectors.toList());
		return postDtos; 
	}

	@Override
	public List<PostDto> searchPosts(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

}
