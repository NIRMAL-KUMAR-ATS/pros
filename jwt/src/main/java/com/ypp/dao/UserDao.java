package com.ypp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ypp.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
	
	//Optional<ProductResp> findByIdOrName(long id, String name);

	
}
