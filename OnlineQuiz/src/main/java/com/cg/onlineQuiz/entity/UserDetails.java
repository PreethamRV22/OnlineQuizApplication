package com.cg.onlineQuiz.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="userdetails")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="userId")
public class UserDetails
{
	@Id	
   @Column(name = "user_id")
   int userId;
	
   @Column(name = "user_name")
   String userName;
   
   @Column(name = "user_password")
   String userPassword;
   
  
   @Column(name = "first_name")
   String firstName;
   
   @Column(name = "last_name")
   String lastName;
   
   @Column(name = "mobile_no")
   long mobileNo;
   
   @Column(name = "email")
   String email;
   
   @OneToOne(cascade =CascadeType.ALL,mappedBy = "userDetails")
   QuizSchedule quizSchedule;
   
   public UserDetails() {}

    public UserDetails(int userId, String userName, String userPassword, String firstName, String lastName, long mobileNo,
		String email, QuizSchedule quizSchedule) {
	
	this.userId = userId;
	this.userName = userName;
	this.userPassword = userPassword;
	this.firstName = firstName;
	this.lastName = lastName;
	this.mobileNo = mobileNo;
	this.email = email;
	this.quizSchedule = quizSchedule;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public QuizSchedule getQuizSchedule() {
		return quizSchedule;
	}

	public void setQuizSchedule(QuizSchedule quizSchedule) {
		this.quizSchedule = quizSchedule;
	}
    
    
}
   
   

