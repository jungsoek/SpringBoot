package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
    
    private final QuestionRepository questionRepository;

    public List<Question> getList() {

        return this.questionRepository.findAll();

    }

    public Question getQuestion(Long id) {
        Optional<Question> question = this.questionRepository.findById(id);

        System.out.println("question : " + question);

        if(question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

}
