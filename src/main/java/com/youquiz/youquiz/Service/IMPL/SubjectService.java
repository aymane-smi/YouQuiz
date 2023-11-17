package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.DTO.QuestionResponseDTO;
import com.youquiz.youquiz.DTO.Subject.SubjectDTO;
import com.youquiz.youquiz.DTO.Subject.SubjectResponseDTO;
import com.youquiz.youquiz.Entity.Subject;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.SubjectRepository;
import com.youquiz.youquiz.Service.ISubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        Subject subject = modelMapper.map(subjectDTO, Subject.class);
        if(subjectDTO.getParent_id() != 0)
            subject.setParent(subjectRepository.findById(
                    subjectDTO.getParent_id()
            ).get());
        return modelMapper.map(subjectRepository.save(subject), SubjectDTO.class);
    }

    @Override
    public SubjectResponseDTO findById(long id) throws NotFoundException {
        if(id <= 0)
            throw new NotFoundException();
        Subject subject = subjectRepository.findById(id).get();
        if(subject == null)
            throw new NotFoundException("subject doesn't exist");
        return modelMapper.map(subject, SubjectResponseDTO.class);
    }
    @Override
    public void removeById(long id) throws NotFoundException {
        if(id <= 0 || subjectRepository.findById(id).get() == null)
            throw new NotFoundException();
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectDTO updateSubject(long id, SubjectDTO subjectDTO) throws NotFoundException {
        boolean key = false;
        if(id <= 0 || subjectRepository.findById(id).get() == null)
            throw new NotFoundException();
        Subject subject = subjectRepository.findById(id).get();
        if(subjectDTO.getParent_id() != 0){
            subject.setParent(
                    subjectRepository.findById(subjectDTO.getParent_id()).get()
            );
            key = true;
        }
        if(subjectDTO.getTitle().isEmpty() == false){
            subject.setTitle(
                    subjectDTO.getTitle()
            );
            key = true;
        }
        if(key == true)
            return modelMapper.map(subjectRepository.save(subject), SubjectDTO.class);
        else
            return null;
    }

    @Override
    public List<QuestionResponseDTO> findSubjectQuestionById(long id) throws NotFoundException {
        Subject subject = subjectRepository.findById(id).get();
        if(id <= 0|| subject == null)
            throw new NotFoundException();
        return Arrays.asList(modelMapper.map(subject.getQuestions(), QuestionResponseDTO[].class));
    }

    @Override
    public List<SubjectDTO> findAll() {
        return Arrays.asList(modelMapper.map(subjectRepository.findAll(), SubjectDTO[].class));
    }
}
