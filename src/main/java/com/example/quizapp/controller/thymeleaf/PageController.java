package com.example.quizapp.controller.thymeleaf;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.service.QuizService;

@Controller
public class PageController {

	private final QuizService quizService;

    public PageController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new com.example.quizapp.entity.User());
        return "register";
    }
    
    @GetMapping("/quiz/all")
    public String quizList(Model model) {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        model.addAttribute("quizzes", quizzes);
        return "quiz-list";
    }
}
