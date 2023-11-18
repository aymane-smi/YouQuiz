package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.Response.ResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

public interface IResponseService {
    ResponseDTO create(ResponseDTO responseDTO);
    ResponseDTO update(long id, ResponseDTO responseDTO) throws NotFoundException;
}
