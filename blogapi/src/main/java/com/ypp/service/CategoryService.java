package com.ypp.service;

import com.ypp.exception.UnauthorizedException;
import com.ypp.model.Category;
import com.ypp.payload.ApiResponse;
import com.ypp.payload.PagedResponse;
import com.ypp.security.UserPrincipal;

import org.springframework.http.ResponseEntity;

public interface CategoryService {

	
	PagedResponse<Category> getAllCategories(int page, int size);

	ResponseEntity<Category> getCategory(Long id);

	ResponseEntity<Category> addCategory(Category category, UserPrincipal currentUser);

	ResponseEntity<Category> updateCategory(Long id, Category newCategory, UserPrincipal currentUser)
			throws UnauthorizedException;

	ResponseEntity<ApiResponse> deleteCategory(Long id, UserPrincipal currentUser) throws UnauthorizedException;

}
