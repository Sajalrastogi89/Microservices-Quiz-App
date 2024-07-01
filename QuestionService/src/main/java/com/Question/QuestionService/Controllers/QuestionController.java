package com.Question.QuestionService.Controllers;

import com.Question.QuestionService.Entities.Question;
import com.Question.QuestionService.Services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;


    public QuestionController(@RequestBody QuestionService questionService) {
        this.questionService = questionService;
    }
    //create
    @PostMapping
    public Question create(@RequestBody Question question){
       return questionService.create(question);
    }

    //getAll
    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.get();
    }

    //getById
    @PostMapping("/questionId/{id}")
    public Optional<Question> getById(@PathVariable Long id){
        return questionService.getOne(id);
    }

    //get question of specific quiz
    @PostMapping("/quizId/{quizId}")
    public List<Question> getQuestionByQuizId(@PathVariable("quizId") Long id){
        return questionService.getQuestions(id);
    }
}
