package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.DTO.StudentDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;

import java.util.List;

public interface IStudentService {

    public abstract StudentDTO save(StudentDTO studentDto);

    public abstract void delete(Long id) throws NotFoundException;

    public abstract StudentDTO findByID(Long id) throws NotFoundException;

    public abstract List<StudentDTO> getAll();


    public StudentDTO update(Long id, StudentDTO studentDto) throws NotFoundException;
}
