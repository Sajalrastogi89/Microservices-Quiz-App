package com.Question.QuestionService.Services.ServiceImpl;

import com.Question.QuestionService.Entities.Question;
import com.Question.QuestionService.Repositories.QuestionRepository;
import com.Question.QuestionService.Services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) {
       return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> getOne(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getQuestions(Long id) {
        return questionRepository.findByQuizId(id);
    }
}
