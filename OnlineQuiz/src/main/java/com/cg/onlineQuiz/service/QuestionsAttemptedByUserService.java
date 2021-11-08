package com.cg.onlineQuiz.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.onlineQuiz.entity.QuestionsAttemptedByUser;
import com.cg.onlineQuiz.repository.QuestionsAttemptedByUserRepository;

@Service
public class QuestionsAttemptedByUserService 
{
	@Autowired
	QuestionsAttemptedByUserRepository questionsAttemptedByUserRepository;
	
	@Transactional(readOnly = true)
	public QuestionsAttemptedByUser getQuestionsAttemptedByUser(int  questionUserId)
	{
		Optional<QuestionsAttemptedByUser> d =   questionsAttemptedByUserRepository.findById(questionUserId);
		if(d.isPresent())
			return d.get();
		throw new RuntimeException("Question Not found");
		
	}
 	
	 @Transactional(readOnly=true)
	 public List<QuestionsAttemptedByUser> getQuestionsAttemptedByUserDetails()
	 {
	  List<QuestionsAttemptedByUser> qlist = questionsAttemptedByUserRepository.findAll();
	  if(qlist.size() > 0)
	   return qlist;
	  throw new RuntimeException("Not Found");
	 }
	 
	 @Transactional
	 public boolean addOrModifyQuestionsAttemptedByUser(QuestionsAttemptedByUser questionsAttemptedByUser)
	 {
	  QuestionsAttemptedByUser que =questionsAttemptedByUserRepository.save(questionsAttemptedByUser);
	  return que !=null;
	 }
	
	 @Transactional
	 public void removeQuestionsAttemptedByUser(int questionUserId )
	 {
	  questionsAttemptedByUserRepository.deleteById(questionUserId);
	 }
	 
	}