package com.example.quizapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.service.QuestionService;
import com.example.quizapp.service.QuizService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	 private final QuizService quizService;
	    private final QuestionService questionService;

	    public AdminController(QuizService quizService,
	                           QuestionService questionService) {
	        this.quizService = quizService;
	        this.questionService = questionService;
	    }

	    @PostMapping("/quiz")
	    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
	        return ResponseEntity.ok(quizService.createQuiz(quiz));
	    }

	    // Add question to quiz
	    @PostMapping("/quiz/{quizId}/question")
	    public ResponseEntity<Question> addQuestion(
	            @PathVariable Long quizId,
	            @RequestBody Question question) {

	        return ResponseEntity.ok(
	                questionService.addQuestion(quizId, question)
	        );
	    }
	    
	    @DeleteMapping("/quiz/{id}")
	    public ResponseEntity<String> deleteQuiz(@PathVariable Long id) {
	        quizService.deleteQuiz(id);
	        return ResponseEntity.ok("Quiz deleted successfully");
	    }
}
