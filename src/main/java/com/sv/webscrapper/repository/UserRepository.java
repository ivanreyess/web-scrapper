package com.sv.webscrapper.repository;

import com.sv.webscrapper.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
			attributePaths = {"authorities"})
	Optional<User> findByUsername(String username);
	
	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
			attributePaths = {"authorities"})
	List<User> findAll();
	
	@Query("SELECT u FROM User u WHERE u.username = ?#{ principal.username}")
	Optional<User> findLoginUser();
	
}