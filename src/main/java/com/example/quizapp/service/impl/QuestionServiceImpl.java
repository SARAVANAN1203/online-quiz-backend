package com.example.quizapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	 private final QuestionRepository questionRepository;
	    private final QuizRepository quizRepository;

	    public QuestionServiceImpl(QuestionRepository questionRepository,
	                               QuizRepository quizRepository) {
	        this.questionRepository = questionRepository;
	        this.quizRepository = quizRepository;
	    }
	    
	    @Override
	    public Question addQuestion(Long quizId, Question question) {
	        Quiz quiz = quizRepository.findById(quizId)
	                .orElseThrow(() -> new RuntimeException("Quiz not found"));

	        question.setQuiz(quiz);
	        return questionRepository.save(question);
	    }

	    @Override
	    public List<Question> getQuestionsByQuiz(Long quizId) {
	        return questionRepository.findByQuizId(quizId);
	    }
}
