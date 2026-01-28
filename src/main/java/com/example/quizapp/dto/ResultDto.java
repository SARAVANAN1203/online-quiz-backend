package com.example.quizapp.dto;

public class ResultDto {

	 private Long quizId;
	    private int score;
	    private int totalQuestions;

	    public ResultDto() {
	    	
	    }

		/**
		 * @param quizId
		 * @param score
		 * @param totalQuestions
		 */
		public ResultDto(Long quizId, int score, int totalQuestions) {
			super();
			this.quizId = quizId;
			this.score = score;
			this.totalQuestions = totalQuestions;
		}

		public Long getQuizId() {
			return quizId;
		}

		public void setQuizId(Long quizId) {
			this.quizId = quizId;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public int getTotalQuestions() {
			return totalQuestions;
		}

		public void setTotalQuestions(int totalQuestions) {
			this.totalQuestions = totalQuestions;
		}
	    
	    
}
