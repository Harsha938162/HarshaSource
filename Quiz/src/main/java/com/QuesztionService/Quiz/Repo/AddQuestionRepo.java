package com.QuesztionService.Quiz.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QuesztionService.Quiz.Bean.AddQuestionsBean;
import com.QuesztionService.Quiz.Model.AddQuestionsmodel;

public interface AddQuestionRepo extends JpaRepository<AddQuestionsmodel, Integer>{
	@Query(value = "select * from ADD_QUESTIONSMODEL s where s.Tittle = :title",nativeQuery =true)
	public Optional<List<AddQuestionsmodel >> getquestions(String title);

}
