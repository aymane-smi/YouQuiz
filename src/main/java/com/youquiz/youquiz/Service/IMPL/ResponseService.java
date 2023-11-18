package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.Response.ResponseDTO;
import com.youquiz.youquiz.DTO.ValidationDTO;
import com.youquiz.youquiz.Entity.Response;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.QuestionRepository;
import com.youquiz.youquiz.Repository.ResponseRepository;
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
    private QuestionRepository questionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseDTO create(ResponseDTO responseDTO) {
        Response response = modelMapper.map(responseDTO, Response.class);
        response = responseRepository.save(response);
        ValidationDTO validatoinDTO = validationService.create(
                response,
                questionRepository.findById(
                        responseDTO.getQuestion_id()
                ).get(),
                responseDTO.getPoint()
        );
        return modelMapper.map(response, ResponseDTO.class);
    }

    @Override
    public ResponseDTO update(long id, ResponseDTO responseDTO) throws NotFoundException {
        if(id <= 0)
            throw new NotFoundException();
        Response response = responseRepository.findById(id).get();
        response.setResponse(
                responseDTO.getResponse()
        );
        return modelMapper.map(responseRepository.save(response), ResponseDTO.class);
    }
}
