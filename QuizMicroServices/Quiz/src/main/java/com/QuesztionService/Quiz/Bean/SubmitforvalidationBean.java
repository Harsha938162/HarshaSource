package com.QuesztionService.Quiz.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmitforvalidationBean {
@JsonProperty("Question")
private String Question;
@JsonProperty("Answer")
private String Answer;

public String getQuestion() {
	return Question;
}
public void setQuestion(String question) {
	Question = question;
}
public String getAnswer() {
	return Answer;
}
public void setAnswer(String answer) {
	Answer = answer;
}

}
