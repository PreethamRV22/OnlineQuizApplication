package com.cg.onlineQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineQuiz.entity.Question;



public interface QuestionRepository extends JpaRepository<Question, Integer>
{

}
