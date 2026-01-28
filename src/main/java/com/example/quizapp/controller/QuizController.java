package com.example.quizapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.Result;
import com.example.quizapp.service.QuestionService;
import com.example.quizapp.service.QuizService;
import com.example.quizapp.service.ResultService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {


    private final QuizService quizService;
    private final QuestionService questionService;
    private final ResultService resultService;

    public QuizController(QuizService quizService,
                          QuestionService questionService,
                          ResultService resultService) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.resultService = resultService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    // Get questions for quiz
    @GetMapping("/{quizId}/questions")
    public ResponseEntity<List<Question>> getQuestions(
            @PathVariable Long quizId) {

        return ResponseEntity.ok(
                questionService.getQuestionsByQuiz(quizId)
        );
    }
    
    // Submit result
    @PostMapping("/submit")
    public ResponseEntity<Result> submitResult(
            @RequestBody Result result) {

        return ResponseEntity.ok(resultService.saveResult(result));
    }
}
