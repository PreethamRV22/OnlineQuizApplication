package com.cg.onlineQuiz.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.onlineQuiz.entity.UserDetails;
import com.cg.onlineQuiz.repository.UserDetailsRepository;



@Service
public class UserDetailsService
{
	@Autowired
	UserDetailsRepository userDetailsRepository ;
	
	@Transactional(readOnly = true)
	public UserDetails getUserDetails(int userId)
	{
		Optional<UserDetails> userDetailsList = userDetailsRepository.findById(userId);
		if(userDetailsList.isPresent())
			return userDetailsList.get();
		throw new RuntimeException("UserDetails Not Found");
		
	}
 	
	 @Transactional(readOnly=true)
	 public List<UserDetails> getUserDetailsList()
	 {
		 List<UserDetails> userDetailsList = userDetailsRepository.findAll();
		 if(userDetailsList.size() > 0)
			 return userDetailsList;
		 throw new RuntimeException("User Details Not Found Not Found");
	 }
	 
	 @Transactional
	 public boolean addOrModifyUserDetails(UserDetails userDetails)
	 {
		 UserDetails userDetails1 = userDetailsRepository.save(userDetails);
		 return userDetails1 !=null;
	 }
	 
	 @Transactional
		public void addUserDetails(int userId ,String userName,String userPassword ,String firstName ,String lastName,long mobileNo,String email) {
			 
			 userDetailsRepository.insertUserDetails(userId,userName,userPassword,firstName,lastName,mobileNo,email);
			
		}
		
	 
	 	
	 @Transactional
	 public void removeUserDetails(int userId)
	 {
		 userDetailsRepository.deleteById(userId);
	 }
}
