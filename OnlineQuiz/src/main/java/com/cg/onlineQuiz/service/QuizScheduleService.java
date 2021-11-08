package com.cg.onlineQuiz.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlineQuiz.entity.QuizSchedule;
import com.cg.onlineQuiz.repository.QuizScheduleRepository;


@Service
public class QuizScheduleService 
{
	
	@Autowired
	QuizScheduleRepository quizScheduleRepository;
	
	@Transactional(readOnly = true)
	public QuizSchedule getQuizSchedule(int scheduleId)
	{
		Optional<QuizSchedule> quizSchedule = quizScheduleRepository.findById(scheduleId);
		if(quizSchedule.isPresent()) 
			return quizSchedule.get();
		throw new RuntimeException("QuizSchedule Not found");
	}
	
	@Transactional(readOnly=true)
	 public List<QuizSchedule> getQuizScheduleDetails()
	 {
	  List<QuizSchedule> quizScheduleList = quizScheduleRepository.findAll();
	  if(quizScheduleList.size() > 0)
	   return quizScheduleList;
	  throw new RuntimeException("QuizSchedule List Not Found");
	 }
	
	 @Transactional
	 public boolean addOrModifyQuizSchedule(QuizSchedule quizSchedule)
	 {
	  QuizSchedule quizSchedule1 =quizScheduleRepository.save(quizSchedule);
	  return quizSchedule1 !=null;
	 }

	 @Transactional
	 public void removeQuizSchedule(int scheduleId)
	 {
		  quizScheduleRepository.deleteById(scheduleId);
	 }
	 
	 @ExceptionHandler(RuntimeException.class)
		public HttpStatus noDataFound() {
			return HttpStatus.NO_CONTENT;
		}
}
