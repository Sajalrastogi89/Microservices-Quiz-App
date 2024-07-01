package com.Quiz.QuizService.Services;

import com.Quiz.QuizService.Entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@FeignClient(url="http://localhost:8082",value="Question-Client")
@FeignClient(name="QUESTIONSERVICE")
public interface QuestionClient {
   @PostMapping("/question/quizId/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
}
