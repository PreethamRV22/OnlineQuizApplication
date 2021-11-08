package com.cg.onlineQuiz.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
@Entity
@Table(name="questions")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="questionId")
public class Question 
{
	@Id
	@Column(name="question_id")
	int questionId;
	
	
	@Column(name="quiz_id")
	int quizId;
	
	
	@Column(name="question_description")
	String questionDescription;
	
	
	@Column(name="option1")
	String option1;
	
	
	@Column(name="option2")
	String option2;
	
	
	@Column(name="option3")
	String option3;
	
	
	@Column(name="answer_option")
	String option4;

	
	public Question() {}


	public Question(int questionId, int quizId, String questionDescription, String option1, String option2,
			String option3, String option4) {
		
		this.questionId = questionId;
		this.quizId = quizId;
		this.questionDescription = questionDescription;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}


	public int getQuestionId() {
		return questionId;
	}


	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}


	public int getQuizId() {
		return quizId;
	}


	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}


	public String getQuestionDescription() {
		return questionDescription;
	}


	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}


	public String getOption1() {
		return option1;
	}


	public void setOption1(String option1) {
		this.option1 = option1;
	}


	public String getOption2() {
		return option2;
	}


	public void setOption2(String option2) {
		this.option2 = option2;
	}


	public String getOption3() {
		return option3;
	}


	public void setOption3(String option3) {
		this.option3 = option3;
	}


	public String getOption4() {
		return option4;
	}


	public void setOption4(String option4) {
		this.option4 = option4;
	}

}

	