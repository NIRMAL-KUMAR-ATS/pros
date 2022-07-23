package com.ypp.controller;

import java.awt.print.Pageable;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ypp.model.Post;
import com.ypp.model.Posts;
import com.ypp.payload.PagedResponse;
import com.ypp.repository.PostRepository;
import com.ypp.service.PostService;
import com.ypp.utils.AppConstants;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
@Autowired	
private PostRepository postRepository;

@Autowired
private PostService postService;
	
@GetMapping("/postes")
 List<Post> getAllPosts(@RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
		@RequestParam(value = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
PagedResponse<Post> response = postService.getAllPosts(page, size);
   return postRepository.findAll();    
   
}

//
//@GetMapping
//public ResponseEntity<PagedResponse<Post>> getAllPosts(
//		@RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
//		@RequestParam(value = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
//	PagedResponse<Post> response = postService.getAllPosts(page, size);
//
//	return new ResponseEntity< >(response, HttpStatus.OK);
//}

@PostMapping("/post")
public Posts createPost(@Valid @RequestBody Posts posts) {
	
    return postRepository.save(posts);
    
}
}
