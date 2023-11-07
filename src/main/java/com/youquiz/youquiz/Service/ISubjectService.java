package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.SubjectDTO;
import com.youquiz.youquiz.DTO.SubjectResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

public interface ISubjectService {
    SubjectDTO createSubject(SubjectDTO subjectDTO);
    SubjectResponseDTO findById(long id) throws NotFoundException;

    void removeById(long id) throws NotFoundException;
    SubjectDTO updateSubject(long id, SubjectDTO subjectDTO) throws NotFoundException;
}
