package com.cg.onlineQuiz.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineQuiz.entity.QuestionsAttemptedByUser;
public interface QuestionsAttemptedByUserRepository extends JpaRepository<QuestionsAttemptedByUser, Integer>
{

}