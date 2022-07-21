package com.ypp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ypp.entity.Post;

public interface PostDao extends JpaRepository<Post, Long> {

}
