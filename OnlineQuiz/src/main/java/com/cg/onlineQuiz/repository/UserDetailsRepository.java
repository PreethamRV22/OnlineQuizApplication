package com.cg.onlineQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.onlineQuiz.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>
{
	@Modifying
	@Query(
	  value = 
	    "insert into UserDetails (user_id, user_name, user_password, first_name,last_name,mobile_no,email) values (:userId, :userName, :userPassword, :firstName,:lastName,:mobileNo,:email)",
	  nativeQuery = true)
	void insertUserDetails(@Param("userId") Integer userId, @Param("userName") String userName, 
	  @Param("userPassword") String userPassword, @Param("firstName") String fisrtName,@Param("lastName") String lastName,@Param("mobileNo") long mobileNo ,@Param("email") String email);

}
