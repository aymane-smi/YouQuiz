package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.ValidationDTO;
import com.youquiz.youquiz.Entity.Question;
import com.youquiz.youquiz.Entity.Response;
import com.youquiz.youquiz.Entity.Validation;
import com.youquiz.youquiz.Repository.ValidationRepository;
import com.youquiz.youquiz.Service.IValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService implements IValidationService {
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ValidationDTO create(Response response, Question question, double point) {
        Validation validation = validationRepository.save(
                new Validation(
                        response,
                        question,
                        point
                )
        );
        return modelMapper.map(validation, ValidationDTO.class);
    }
}
