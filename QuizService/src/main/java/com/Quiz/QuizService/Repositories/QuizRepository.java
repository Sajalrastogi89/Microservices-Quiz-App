package com.Quiz.QuizService.Repositories;

import com.Quiz.QuizService.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
