package com.cg.onlineQuiz.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.onlineQuiz.entity.Question;
import com.cg.onlineQuiz.repository.QuestionRepository;

@Service
public class QuestionService 
{
	@Autowired
	QuestionRepository questionRepository;
	
	@Transactional(readOnly = true)
	public Question getQuestion(int questionId)
	{
		Optional<Question> d = questionRepository.findById(questionId);
		if(d.isPresent())
			return d.get();
		throw new RuntimeException("Question Not found");
		
	}
 	
	 @Transactional(readOnly=true)
	 public List<Question> getQuestions()
	 {
	  List<Question> qlist = questionRepository.findAll();
	  if(qlist.size() > 0)
	   return qlist;
	  throw new RuntimeException("Not Found");
	 }
	 
	 @Transactional
	 public boolean addOrModifyQuestion(Question question)
	 {
	  Question que =questionRepository.save(question);
	  return que !=null;
	 }
	
	 @Transactional
	 public void removeQuestion(int questionId)
	 {
	  questionRepository.deleteById(questionId);
	 }
	 
	}



