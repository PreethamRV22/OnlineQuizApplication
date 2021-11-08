package com.cg.onlineQuiz.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineQuiz.entity.Quiz;
import com.cg.onlineQuiz.service.QuizService;



@RestController
@RequestMapping("/quiz")
public class QuizController
{
	@Autowired
	QuizService quizService;
	
	@GetMapping(value="/quiz/{quizId}/{userId}",produces="application/json")
	public ResponseEntity<Quiz> getQuiz(@PathVariable int quizId,@PathVariable int userId)
	{
		Quiz q = quizService.getQuiz(quizId, userId);
		return new ResponseEntity<Quiz>(q,HttpStatus.OK);
	}
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Quiz>> getQuizDetails(){
		return new ResponseEntity<List<Quiz>>(quizService.getQuizDetails(),HttpStatus.OK);
	}
	
	@GetMapping(value="/quizbyid/{quizId}",produces="application/json")
	public ResponseEntity<Quiz> getQuizById(@PathVariable int quizId)
	{
		Quiz q = quizService.getQuizDetailsByQuizId(quizId);
		return new ResponseEntity<Quiz>(q,HttpStatus.OK);
	}
	

	@GetMapping(value="/quizbysubjectname/subject/{subjectName}",produces="application/json")
	public ResponseEntity<List<Quiz>> getQuizDetailsBySubjectName(@PathVariable String subjectName)
	{
		return new ResponseEntity<List<Quiz>>(quizService.getQuizDetailsBySubjectName(subjectName),HttpStatus.OK);
	}
	
	@GetMapping(value="/quiz",produces="application/json")
	public ResponseEntity<List<Quiz>> getAllQuizDetails()
	{
		return new ResponseEntity<List<Quiz>>(quizService.getAllQuizDetails(),HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public HttpStatus addQuizDetails(@RequestBody Quiz quiz) {
		if(quizService.addOrModifyQuiz(quiz))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(consumes="application/json")
	public HttpStatus modifyQuizDetails(@RequestBody Quiz quiz) {
		if(quizService.addOrModifyQuiz(quiz))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/removequiz/{quizId}")
	public HttpStatus removeQuiz(@PathVariable int quizId)
	{
	quizService.removeQuiz(quizId);
	return HttpStatus.OK;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
	
	
}
