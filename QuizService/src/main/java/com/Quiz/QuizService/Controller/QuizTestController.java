package com.Quiz.QuizService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz-test")
public class QuizTestController {
    @GetMapping
    public String quizTest(){
        return "Test Controller";
    }
}
