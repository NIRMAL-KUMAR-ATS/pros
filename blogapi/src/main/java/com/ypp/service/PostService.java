package com.ypp.service;

import com.ypp.model.Post;
import com.ypp.payload.ApiResponse;
import com.ypp.payload.PagedResponse;
import com.ypp.payload.PostRequest;
import com.ypp.payload.PostResponse;
import com.ypp.security.UserPrincipal;

public interface PostService {

	PagedResponse<Post> getAllPosts(int page, int size);

	PagedResponse<Post> getPostsByCreatedBy(String username, int page, int size);

	PagedResponse<Post> getPostsByCategory(Long id, int page, int size);

	PagedResponse<Post> getPostsByTag(Long id, int page, int size);

	Post updatePost(Long id, PostRequest newPostRequest, UserPrincipal currentUser);

	ApiResponse deletePost(Long id, UserPrincipal currentUser);

	PostResponse addPost(PostRequest postRequest, UserPrincipal currentUser);

	Post getPost(Long id);

}
