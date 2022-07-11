package com.gl.student.repository;

// repository will provide all the hibernate method via spring
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.student.entity.User;

	public interface UserRepository extends JpaRepository<User, Integer> {
		@Query("from User u where u.username=?1")
		public User getUserByUserName(String username);
	}