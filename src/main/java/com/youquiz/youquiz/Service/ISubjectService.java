package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.Question.QuestionResponseDTO;
import com.youquiz.youquiz.DTO.Subject.SubjectDTO;
import com.youquiz.youquiz.DTO.Subject.SubjectResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

import java.util.List;

public interface ISubjectService {
    SubjectDTO createSubject(SubjectDTO subjectDTO);
    SubjectResponseDTO findById(long id) throws NotFoundException;

    void removeById(long id) throws NotFoundException;
    SubjectDTO updateSubject(long id, SubjectDTO subjectDTO) throws NotFoundException;

    List<QuestionResponseDTO> findSubjectQuestionById(long id) throws NotFoundException;
    List<SubjectDTO> findAll();
}
