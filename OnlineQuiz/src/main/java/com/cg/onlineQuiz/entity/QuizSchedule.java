package com.cg.onlineQuiz.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "quiz_schedule")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="scheduleId")
public class QuizSchedule 
{
	@Id
	@Column(name = "schedule_id")
	int scheduleId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quiz_id")
	Quiz quiz;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	UserDetails userDetails;
	
	@Column(name = "schedule_date")
	LocalDate scheduleDate; 
	
	@Column(name = "schedule_time")
	LocalTime scheduleTime;
	
	@OneToMany
    @JoinColumn(name = "schedule_id")
	List<QuestionsAttemptedByUser> questionsAttemptedByUser;
	
	public QuizSchedule() {}

	public QuizSchedule(int scheduleId, Quiz quiz, UserDetails userDetails, LocalDate scheduleDate, LocalTime scheduleTime, List<QuestionsAttemptedByUser> questionsAttemptedByUser) {
		
		this.scheduleId = scheduleId;
		this.quiz = quiz;
		this.userDetails = userDetails;
		this.scheduleDate = scheduleDate;
		this.scheduleTime = scheduleTime;
		this.questionsAttemptedByUser = questionsAttemptedByUser;
	}
	
public QuizSchedule( Quiz quiz, UserDetails userDetails, LocalDate scheduleDate, LocalTime scheduleTime) 
{
		this.quiz = quiz;
		this.userDetails = userDetails;
		this.scheduleDate = scheduleDate;
		this.scheduleTime = scheduleTime;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public LocalDate getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public LocalTime getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(LocalTime scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public List<QuestionsAttemptedByUser> getQuestionsAttemptedByUser() {
		return questionsAttemptedByUser;
	}

	public void setQuestionsAttemptedByUser(List<QuestionsAttemptedByUser> questionsAttemptedByUser) {
		this.questionsAttemptedByUser = questionsAttemptedByUser;
	}
	
	
	
	
	

}