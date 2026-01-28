package com.example.quizapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.entity.Result;
import com.example.quizapp.service.ResultService;

@RestController
@RequestMapping("/api/results")
public class ResultController {

	private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    // View results by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Result>> getResults(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                resultService.getResultsByUser(userId)
        );
    }
}
