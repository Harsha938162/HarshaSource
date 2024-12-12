package com.QuesztionService.Quiz.Bean;

import com.QuesztionService.Quiz.Model.AddQuestionsmodel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddQuestionsBean {
	private int id;
	
	
	private String Question;
	

	private String Option1;
	

	private String Option2;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestion() {
		return Question;
	}


	public void setQuestion(String question) {
		Question = question;
	}


	public String getOption1() {
		return Option1;
	}


	public void setOption1(String option1) {
		Option1 = option1;
	}


	public String getOption2() {
		return Option2;
	}


	public void setOption2(String option2) {
		Option2 = option2;
	}


	public String getOption3() {
		return Option3;
	}


	public void setOption3(String option3) {
		Option3 = option3;
	}


	public String getTittle() {
		return Tittle;
	}


	public void setTittle(String tittle) {
		Tittle = tittle;
	}


	private String Option3;
	

	private String Tittle;

	public AddQuestionsBean(AddQuestionsmodel model) {
		
		setId(model.getId());
		setTittle(model.getTittle());
		setQuestion(model.getQuestion());
		setOption1(model.getOption1());
		setOption2(model.getOption2());
		setOption3(model.getOption3());
		
	}
}
