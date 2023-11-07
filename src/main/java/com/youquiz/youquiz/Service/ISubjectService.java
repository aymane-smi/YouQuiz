package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.SubjectDTO;
import com.youquiz.youquiz.DTO.SubjectResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

public interface ISubjectService {
    SubjectDTO createSubject(SubjectDTO subjectDTO);
    SubjectResponseDTO findById(Long id) throws NotFoundException;
}
