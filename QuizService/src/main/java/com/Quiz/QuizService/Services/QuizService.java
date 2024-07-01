package com.Quiz.QuizService.Services;

import com.Quiz.QuizService.Entities.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    void createQuiz(Quiz quiz);
    List<Quiz> getAllQuiz();
    Optional<Quiz> findById(Long id);
}
