package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.QuestionDTO;
import com.youquiz.youquiz.DTO.QuestionResponseDTO;
import com.youquiz.youquiz.Entity.Question;
import com.youquiz.youquiz.Enum.QuestionType;
import com.youquiz.youquiz.Repository.LevelRepository;
import com.youquiz.youquiz.Repository.QuestionRepository;
import com.youquiz.youquiz.Repository.SubjectRepository;
import com.youquiz.youquiz.Service.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public QuestionResponseDTO create(QuestionDTO questionDTO) {
        Question question = modelMapper.map(questionDTO, Question.class);
        question.setSubject(
                subjectRepository.findById(questionDTO.getSubject_id()).get()
        );
        question.setLevel(
                levelRepository.findById(questionDTO.getLevel_id()).get()
        );
        question.setType(
                QuestionType.valueOf(questionDTO.getType())
        );
        return modelMapper.map(
                questionRepository.save(question), QuestionResponseDTO.class
        );
    }
}
