package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.AssignQuiz.AssignQuizDTO;
import com.youquiz.youquiz.DTO.AssignQuiz.AssignQuizResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

import java.util.List;

public interface IAssignQuizService {
    List<AssignQuizDTO> saveAll(List<AssignQuizDTO> assignQuizDtos) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    List<AssignQuizResponseDTO> getAll();

    AssignQuizResponseDTO findByID(Long id) throws NotFoundException;

    AssignQuizDTO update(Long id, AssignQuizDTO assignQuizDto) throws NotFoundException;
}