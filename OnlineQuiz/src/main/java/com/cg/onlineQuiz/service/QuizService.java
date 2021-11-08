package com.cg.onlineQuiz.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineQuiz.entity.Quiz;
import com.cg.onlineQuiz.entity.QuizSchedule;
import com.cg.onlineQuiz.entity.UserDetails;
import com.cg.onlineQuiz.repository.QuizRepository;



@Service
public class QuizService 
{
	
	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	QuizScheduleService quizScheduleService;
	
	@Transactional(readOnly = true)
	public Quiz getQuiz(int quizId,int userId)
	{
		Optional<Quiz> quiz = quizRepository.findById(quizId);
		if(quiz.isPresent()) 
		{
			UserDetails userDetails = userDetailsService.getUserDetails(userId);
			quizScheduleService.addOrModifyQuizSchedule(new QuizSchedule(new Quiz(quiz.get().getQuizId()),userDetails,LocalDate.now(),LocalTime.now()));
			return quiz.get();
		}
		throw new RuntimeException("Quiz No : "+quizId+"  Not found");
	}
	
	@Transactional(readOnly=true)
	 public List<Quiz> getQuizDetails()
	 {
	  List<Quiz> quizList = quizRepository.findAll();
	  if(quizList.size() > 0)
	   return quizList;
	  throw new RuntimeException("Quiz List Not Found");
	 }
	
	@Transactional(readOnly = true)
	public Quiz  getQuizDetailsByQuizId(int quizId)
	{
		Quiz q = quizRepository.findQuizDetailsByQuizId(quizId);
		if(q != null)
			return q;
		throw new RuntimeException("Quiz Not Found");
				
	}
	

	@Transactional(readOnly = true)
	public List<Quiz>  getQuizDetailsBySubjectName(String subjectName)
	{
		return quizRepository.findQuizDetailsBySubjectName(subjectName);
	}
	
	@Transactional(readOnly = true)
	public List<Quiz> getAllQuizDetails()
	{
		return quizRepository.findAllQuizDetails();
	}
	
	 @Transactional
	 public boolean addOrModifyQuiz(Quiz quiz)
	 {
	  Quiz quiz1 =quizRepository.save(quiz);
	  return quiz1 !=null;
	 }
	 
	 
	 @Transactional
	 public void removeQuiz(int quizId)
	 {
		  quizRepository.deleteById(quizId);
	 }
}