package com.example.fmw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fmw.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByfirstName(String firstName);

	User findByid(Long User_id);
	//User findByUsername(String email);   
	User findBypassword(String password);

	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(value =
	 * "update user set first_name = ?1,last_name = ?2,password = ?3 where user_id = ?4"
	 * , nativeQuery = true) int update(String firstName,String lastName,String
	 * password, Long id);
	 */
	//@Query(SELECT u FROM user u JOIN u.roles)
}