package com.cg.onlineQuiz.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name="quiz")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="quizId")
public class Quiz
{
	@Id
	@Column(name = "quiz_id")
	int quizId;
 
	@Column(name = "quiz_name")
	String quizName;
 
	@Column(name = "subject_name")
	String subjectName;
 
	@Column(name = "quiz_description")
	String quizDescription;
 
	@Column(name = "no_of_questions")
	int noOfQuestions;
 
	@Column(name = "max_marks")
	int maxMarks ;
 
	@Column(name = "time_limit")
	LocalTime timeLimit;
	
	@OneToMany
	@JoinColumn(name ="quiz_id")
	List<Question> questions; 
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy = "quiz")
	QuizSchedule quizSchedule;
	
	public Quiz() {}
	
	public Quiz(int quizId)
		{
			this.quizId = quizId;
		}
	

	public Quiz(int quizId, String quizName, String subjectName, String quizDescription, int noOfQuestions, int maxMarks,
		LocalTime timeLimit,List<Question> questions) 
	{
		this.quizId = quizId;
		this.quizName = quizName;
		this.subjectName = subjectName;
		this.quizDescription = quizDescription;
		this.noOfQuestions = noOfQuestions;
		this.maxMarks = maxMarks;
		this.timeLimit = timeLimit;
		this.questions = questions;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getQuizDescription() {
		return quizDescription;
	}

	public void setQuizDescription(String quizDescription) {
		this.quizDescription = quizDescription;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public LocalTime getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(LocalTime timeLimit) {
		this.timeLimit = timeLimit;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizName=" + quizName + ", subjectName=" + subjectName
				+ ", quizDescription=" + quizDescription + ", noOfQuestions=" + noOfQuestions + ", maxMarks=" + maxMarks
				+ ", timeLimit=" + timeLimit + ", questions=" + questions + "]";
	}
	
	
	
	
}