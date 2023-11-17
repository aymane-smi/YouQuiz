package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.StudentDTO;
import com.youquiz.youquiz.Entity.Student;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.StudentRepository;
import com.youquiz.youquiz.Service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public StudentDTO save(StudentDTO studentDto) {
        Student studentRequest = modelMapper.map(studentDto, Student.class);
        Student student = studentRepository.save(studentRequest);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void delete(Long id) throws NotFoundException{
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        studentRepository.delete(student);
    }

    @Override
    public StudentDTO findByID(Long id) throws NotFoundException{
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .toList();
    }

    @Override
    public StudentDTO update(Long id, StudentDTO studentDto) throws NotFoundException{
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        existingStudent.setFirstName(studentDto.getFirstName());
        existingStudent.setLastName(studentDto.getLastName());
        existingStudent.setBirthDay(studentDto.getBirthDay());
        existingStudent.setAddress(studentDto.getAddress());
        existingStudent.setDateOfInscription(studentDto.getDateOfInscription());
        Student updatedStudent = studentRepository.save(existingStudent);
        return modelMapper.map(updatedStudent, StudentDTO.class);
    }
}