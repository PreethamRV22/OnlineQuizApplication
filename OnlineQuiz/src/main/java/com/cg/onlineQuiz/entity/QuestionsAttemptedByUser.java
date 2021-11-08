package com.cg.onlineQuiz.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "questions_attemptedby_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="questionUserId")
public class QuestionsAttemptedByUser 
{
	@Id
	@Column(name="question_user_id")
	int questionUserId;
	
	
	@Column(name = "schedule_id")
	int scheduleId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	Question question;
	
	@Column(name = "selected_option")
	String selectedOption;
	
	public QuestionsAttemptedByUser() {}

	public QuestionsAttemptedByUser(int questionUserId, int scheduleId, Question question, String selectedOption) {
		super();
		this.questionUserId = questionUserId;
		this.scheduleId = scheduleId;
		this.question = question;
		this.selectedOption = selectedOption;
	}

	public int getQuestionUserId() {
		return questionUserId;
	}

	public void setQuestionUserId(int questionUserId) {
		this.questionUserId = questionUserId;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}

	
}
	
	