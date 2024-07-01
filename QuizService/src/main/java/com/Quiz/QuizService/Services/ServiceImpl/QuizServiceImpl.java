package com.Quiz.QuizService.Services.ServiceImpl;

import com.Quiz.QuizService.Entities.Quiz;
import com.Quiz.QuizService.Repositories.QuizRepository;
import com.Quiz.QuizService.Services.QuestionClient;
import com.Quiz.QuizService.Services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {
private final QuizRepository quizRepository;
private final QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public void createQuiz(Quiz quiz) {
quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> Quizzes= quizRepository.findAll();
      return Quizzes.stream().map(quiz -> {
            quiz.setQuestionList(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).toList();
    }

    @Override
    public Optional<Quiz> findById(Long id) {
       Optional<Quiz> quiz=quizRepository.findById(id);
//      if(quiz.isPresent()){
//         quiz.get().setQuestionList(questionClient.getQuestionOfQuiz(id));
//        }
//        quiz.ifPresent(value -> value.setQuestionList(questionClient.getQuestionOfQuiz(id)));
       quiz.ifPresent(q->q.setQuestionList(questionClient.getQuestionOfQuiz(id)));
      return quiz;
    }
}
