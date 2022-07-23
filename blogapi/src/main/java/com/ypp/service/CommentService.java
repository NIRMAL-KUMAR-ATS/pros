package com.ypp.service;

import com.ypp.model.Comment;
import com.ypp.payload.ApiResponse;
import com.ypp.payload.CommentRequest;
import com.ypp.payload.PagedResponse;
import com.ypp.security.UserPrincipal;

public interface CommentService {

	
	PagedResponse<Comment> getAllComments(Long postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, Long postId, UserPrincipal currentUser);

	Comment getComment(Long postId, Long id);

	Comment updateComment(Long postId, Long id, CommentRequest commentRequest, UserPrincipal currentUser);

	ApiResponse deleteComment(Long postId, Long id, UserPrincipal currentUser);

}
