package com.saar.blog.service;

import java.util.List;

import com.saar.blog.entity.Post;
import com.saar.blog.payloads.PostDto;

public interface PostService {
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer postId);
	void deletePost(Integer postId);
	List<PostDto> getAllPost();
	PostDto getPostById(Integer postId);
	List<PostDto>getPostByCategory(Integer categoryId);//get all posts by category
	List<PostDto>getPostsByUser(Integer userId);//get all posts by user
	// search posts
	List<PostDto> searchPosts(String keywords);

}
