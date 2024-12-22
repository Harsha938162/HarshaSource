package com.QuesztionService.Quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.QuesztionService.Quiz.Bean.SubmitforvalidationBean;
import com.QuesztionService.Quiz.Exception.ExceptionHandling;
import com.QuesztionService.Quiz.Model.AddQuestionsmodel;
import com.QuesztionService.Quiz.Service.AddQuestionService;

@RestController
public class QuestionController {
	@Autowired
	AddQuestionService AddService;
	
	@RequestMapping("/AddQuestions")

	public ResponseEntity<?> AddQuestions(@RequestBody List<AddQuestionsmodel> addquestions)
	{
	
		
		AddService.savequestions(addquestions);
	
	
		return new ResponseEntity<>("Saved Successfully",HttpStatus.CREATED);
		
		
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
		Optional<List<AddQuestionsmodel>> Addquestionsmodellist=AddService.getquestionsbytitle(title);
		if(Addquestionsmodellist.get().size()==0)
		{
			throw new ExceptionHandling("No question Found Based on "+title);
		}
		else
		{
		return new ResponseEntity<>(AddService.getquestionsbytitle(title), HttpStatus.ACCEPTED);
		}
		
	}
	@RequestMapping("/Submit/{Title}")
	public String  validate(@RequestBody List<SubmitforvalidationBean> SubmitforvalidationBeanobj,@PathVariable String Title)
	{
		for (SubmitforvalidationBean submitforvalidationBean : SubmitforvalidationBeanobj) {
			System.out.println(submitforvalidationBean.getQuestion());
			System.out.println(submitforvalidationBean.getAnswer());
		}
		String result=AddService.validateService(SubmitforvalidationBeanobj, Title);
		
		return result;
	}
	@ExceptionHandler(ExceptionHandling.class)
	public  String HandleQuestionControllerException(ExceptionHandling exceptionhandlingobj)
	
	{
		System.out.println("In Exception handling");
		String errormsg=exceptionhandlingobj.ErrorMsg;
		
		return errormsg;
	}
}
