package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.ValidationDTO;
import com.youquiz.youquiz.Entity.Question;
import com.youquiz.youquiz.Entity.Response;

public interface IValidationService {
    ValidationDTO create(Response response, Question question, double point);
}
