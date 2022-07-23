package com.ypp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ypp.model.Post;
import com.ypp.model.Posts;
import com.ypp.model.Tag;

import java.util.List;

import javax.validation.Valid;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	Page<Post> findByCreatedBy(Long userId, Pageable pageable);

	Page<Post> findByCategory(Long categoryId, Pageable pageable);

	Page<Post> findByTags(List<Tag> tags, Pageable pageable);

	Long countByCreatedBy(Long userId);

	Posts save(@Valid Posts posts);
	//Posts save(@Valid Posts posts);

}
