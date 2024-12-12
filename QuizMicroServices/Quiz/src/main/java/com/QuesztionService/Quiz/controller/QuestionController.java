package com.QuesztionService.Quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.QuesztionService.Quiz.Bean.SubmitforvalidationBean;
import com.QuesztionService.Quiz.Model.AddQuestionsmodel;
import com.QuesztionService.Quiz.Service.AddQuestionService;

@RestController
public class QuestionController {
	@Autowired
	AddQuestionService AddService;
	
	@RequestMapping("/AddQuestions")

	public ResponseEntity<?> AddQuestions(@RequestBody AddQuestionsmodel addquestions)
	
	{
		AddService.savequestions(addquestions);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
		
	}
	@RequestMapping("/getQuestionsforQuiz")
	public  String getQuestionsforQuiz()
	{
		/* List<AddQuestionsmodel> list=AddService.getquestions(); */
		System.out.println("In quiz");
		return "Connected to quiz";
		
	}
	@RequestMapping("/getquestions/{title}")
	public ResponseEntity<?> getquestions(@PathVariable String title)
	{
		System.out.println("In quiz getquestions:"+title);
		return new ResponseEntity<>(AddService.getquestionsbytitle(title), HttpStatus.ACCEPTED);
		
	}
	@RequestMapping("/Submit")
	public int validate(@RequestBody List<SubmitforvalidationBean> SubmitforvalidationBeanobj)
	{
		for (SubmitforvalidationBean submitforvalidationBean : SubmitforvalidationBeanobj) {
			System.out.println(submitforvalidationBean.getQuestion());
			System.out.println(submitforvalidationBean.getAnswer());
		}
		int result=AddService.validateService(SubmitforvalidationBeanobj, "java");
		
		return result;
	}
}
