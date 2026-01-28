package com.example.quizapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
    
    @Override
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    @Override
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
