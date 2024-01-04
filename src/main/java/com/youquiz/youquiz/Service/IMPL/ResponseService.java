package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.Response.ResponseDTO;
import com.youquiz.youquiz.DTO.ValidationDTO;
import com.youquiz.youquiz.Entity.Response;
import com.youquiz.youquiz.Entity.Validation;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.QuestionRepository;
import com.youquiz.youquiz.Repository.ResponseRepository;
import com.youquiz.youquiz.Repository.ValidationRepository;
import com.youquiz.youquiz.Service.IResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService implements IResponseService {
    @Autowired
    private ResponseRepository responseRepository;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseDTO create(ResponseDTO responseDTO) {
        if(validationRepository.sumOfResponseByQuestion(responseDTO.getQuestion_id())+responseDTO.getPoint() <= questionRepository.findTotalScoreByQuestionId(responseDTO.getQuestion_id())){
            Response response = modelMapper.map(responseDTO, Response.class);
            if(responseDTO.getPoint() == 0)
                responseDTO.setPosition(0);
            response = responseRepository.save(response);
            ValidationDTO validatoinDTO = validationService.create(
                    response,
                    questionRepository.findById(
                            responseDTO.getQuestion_id()
                    ).get(),
                    responseDTO.getPoint()
            );
            ResponseDTO result = modelMapper.map(response, ResponseDTO.class);
            result.setQuestion_id(responseDTO.getQuestion_id());
            result.setPoint(validatoinDTO.getPoint());
            return modelMapper.map(response, ResponseDTO.class);
        }else
            throw new RuntimeException("the response score maybe greater then the available question score.");

    }

    @Override
    public ResponseDTO update(long id, ResponseDTO responseDTO) throws NotFoundException {
        if(id <= 0 || !responseRepository.existsById(id))
            throw new NotFoundException();
        Response response = responseRepository.findById(id).get();
        response.setResponse(
                responseDTO.getResponse()
        );
        return modelMapper.map(responseRepository.save(response), ResponseDTO.class);
    }

    @Override
    public ResponseDTO findById(long id) throws NotFoundException{
        if(id <= 0 || !responseRepository.existsById(id))
            throw new NotFoundException();
        ResponseDTO response = modelMapper.map(responseRepository.findById(id).get(), ResponseDTO.class);;
        Validation validation = validationRepository.findValidationsByResponseId(id);
        response.setPoint(validation.getPoint());
        response.setQuestion_id(validation.getQuestion().getId());
        return response;
    }
}
