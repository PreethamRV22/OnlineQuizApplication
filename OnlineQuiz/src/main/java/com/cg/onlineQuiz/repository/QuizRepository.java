package com.cg.onlineQuiz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.onlineQuiz.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Integer>
{
 
	@Query("select quizName,subjectName,quizDescription,maxMarks,timeLimit from Quiz q where q.quizId=:qid")
	Quiz findQuizDetailsByQuizId(@Param("qid")int quizId);
		
	
	@Query("select quizId,quizName,subjectName,quizDescription,maxMarks,timeLimit from Quiz q where q.subjectName=:subName")
	List<Quiz> findQuizDetailsBySubjectName(@Param("subName")String subjectName);
	
	@Query("select quizId,quizName,subjectName,quizDescription,maxMarks,timeLimit from Quiz ")
	List<Quiz> findAllQuizDetails();
}