package com.example.quizapp.dto;

import java.util.Map;

public class SubmitAnswerDto {

	private Long quizId;
    private Long userId;

    // questionId -> selectedAnswer
    private Map<Long, String> answers;

    public SubmitAnswerDto() {
    	
    }

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Map<Long, String> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<Long, String> answers) {
		this.answers = answers;
	}
    
    

}
