package com.example.quizapp.controller.thymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.quizapp.dto.ResultDto;
import com.example.quizapp.entity.Question;
import com.example.quizapp.entity.Quiz;
import com.example.quizapp.entity.Result;
import com.example.quizapp.entity.User;
import com.example.quizapp.exception.ResourceNotFoundException;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.repository.UserRepository;
import com.example.quizapp.service.ResultService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/quiz")
public class QuizThymeleafController {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final ResultService resultService;
    private final UserRepository userRepository;

    public QuizThymeleafController(QuizRepository quizRepository,
                                   QuestionRepository questionRepository,
                                   ResultService resultService,
                                   UserRepository userRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.resultService = resultService;
        this.userRepository = userRepository;
    }

    // Show quiz questions
    @GetMapping("/{id}")
    public String startQuiz(@PathVariable Long id, Model model) {

        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        List<Question> questions = questionRepository.findByQuizId(id);

        model.addAttribute("quiz", quiz);
        model.addAttribute("questions", questions);

        return "quiz";
    }

    // Submit quiz
    @PostMapping("/submit")
    public String submitQuiz(HttpServletRequest request, Model model) {

        Long quizId = Long.valueOf(request.getParameter("quizId"));
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        List<Question> questions = questionRepository.findByQuizId(quizId);

        int score = 0;

        for (Question q : questions) {
            String userAnswer = request.getParameter(String.valueOf(q.getId()));
            if (userAnswer != null &&
                userAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                score++;
            }
        }

        // TEMP user (replace with logged-in user later)
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Result result = new Result(quizId, score, null, user, quiz);
        resultService.saveResult(result);

        ResultDto resultDto = new ResultDto(
                quiz.getId(),
                score,
                questions.size()
        );

        model.addAttribute("result", resultDto);

        return "result";
    }
}
