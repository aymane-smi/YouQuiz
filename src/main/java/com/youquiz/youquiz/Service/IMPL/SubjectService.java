package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.DTO.SubjectDTO;
import com.youquiz.youquiz.DTO.SubjectResponseDTO;
import com.youquiz.youquiz.Entity.Level;
import com.youquiz.youquiz.Entity.Subject;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.SubjectRepository;
import com.youquiz.youquiz.Service.ISubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public SubjectResponseDTO findById(Long id) throws NotFoundException {
        if(id <= 0)
            throw new NotFoundException();
        Subject subject = subjectRepository.findById(id).get();
        if(subject == null)
            throw new NotFoundException("subject doesn't exist");
        return modelMapper.map(subject, SubjectResponseDTO.class);
    }
}
