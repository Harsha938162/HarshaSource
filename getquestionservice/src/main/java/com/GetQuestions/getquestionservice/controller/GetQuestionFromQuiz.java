package com.GetQuestions.getquestionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class GetQuestionFromQuiz {

	@RequestMapping("/GetQuestions/{title}")
	public ResponseEntity<?> getQuestionsFromQuiz(@PathVariable String title)
	{
		RestTemplate rest=new RestTemplate();
		String respose=rest.getForObject("http://localhost:8011/getquestions/"+title,String.class);
		
		
		
		return new ResponseEntity<>(respose,HttpStatus.ACCEPTED);
	}
	
}
