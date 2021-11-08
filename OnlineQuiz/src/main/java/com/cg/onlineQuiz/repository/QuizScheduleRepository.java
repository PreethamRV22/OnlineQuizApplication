package com.cg.onlineQuiz.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineQuiz.entity.QuizSchedule;
public interface QuizScheduleRepository extends JpaRepository<QuizSchedule, Integer>
{
	
	
}