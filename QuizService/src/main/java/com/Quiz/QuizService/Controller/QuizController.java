package com.Quiz.QuizService.Controller;


import com.Quiz.QuizService.Entities.Quiz;
import com.Quiz.QuizService.Services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(@RequestBody QuizService quizService) {
        this.quizService = quizService;
    }

    //create
    @PostMapping("/create")
    void createQuiz(@RequestBody Quiz quiz){
        quizService.createQuiz(quiz);
    }
    //findAllQuiz
    @GetMapping("/")
    List<Quiz> getAllQuiz(){
       return quizService.getAllQuiz();
    }

    //find quiz by id
    @PostMapping("/{id}")
    Optional<Quiz> getQuizById(@PathVariable Long id){
        return quizService.findById(id);
    }
}
