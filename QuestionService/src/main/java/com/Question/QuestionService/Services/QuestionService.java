package com.Question.QuestionService.Services;

import com.Question.QuestionService.Entities.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question create(Question question);
    List<Question> get();
    Optional<Question> getOne(Long id);
    List<Question> getQuestions(Long id);
}
