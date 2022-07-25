package com.ypp.controller;

import java.awt.print.Pageable;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@PostMapping
public Posts createPost(@Valid @RequestBody Posts posts) {
	
    return postRepository.save(posts);
    
}
//
//@PutMapping("/post/{postId}")
//public Posts updatePost(@PathVariable Long id, @Valid @RequestBody Posts postRequest) {
//    return postRepository.findById(id).map(postses -> {
//    	postses.setTitle(postRequest.getTitle());
//    	postses.setc
//    	postses
//    	postses
//    	postses
//    	postses
//        post.setTitle(postRequest.getTitle());
//        ((Posts) post).setDescription(postRequest.getDescription());
//        post.setContent(postRequest.getContent());
//        return postRepository.save(post);
//    }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//}
//
//
//@PutMapping("/post/{postId}")
//public Posts updatePost(@PathVariable Long id, @Valid @RequestBody Posts posts) {
//	
//    return postRepository.findById(id).map(post -> {
//    	
//        post.setTitle(posts.getTitle());
//        ((Posts) post).setDescription(posts.getDescription());
//        ((Posts) post).setContent(posts.getContent());
//        return postRepository.save(post);
//    }).orElseThrow();
//}

}
