package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.Answer.AnswerDTO;
import com.youquiz.youquiz.DTO.Response.CostumeResponseDTO;
import com.youquiz.youquiz.DTO.Response.ResponseDTO;
import com.youquiz.youquiz.Entity.Answer;
import com.youquiz.youquiz.Entity.AssignQuiz;
import com.youquiz.youquiz.Entity.Response;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.AnswerRepository;
import com.youquiz.youquiz.Repository.AssignQuizRepository;
import com.youquiz.youquiz.Repository.ValidationRepository;
import com.youquiz.youquiz.Service.IAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private AssignQuizRepository assignQuizRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(AnswerDTO answerDTO) throws NotFoundException,Exception {
        System.out.println(answerDTO.getAssignQuiz_id()+"//"+ answerDTO.getValidation_id());
        if(
                assignQuizRepository.existsById(answerDTO.getAssignQuiz_id()) == false ||
                validationRepository.existsById(answerDTO.getValidation_id()) == false
        )
            throw new NotFoundException();
        if(answerRepository.countAnswerByValidationIdAndAndAssignQuiz_Id(answerDTO.getValidation_id(), answerDTO.getAssignQuiz_id()) > 0)
            throw new Exception("answer exist");
        answerRepository.save(
                new Answer(
                        assignQuizRepository.findById(answerDTO.getAssignQuiz_id()).get(),
                        validationRepository.findById(answerDTO.getValidation_id()).get()
                )
        );
    }
    @Override
    public List<CostumeResponseDTO> findResponseofUserQuiz(long assignQuiz_id)throws NotFoundException, Exception{
     if(!assignQuizRepository.existsById(assignQuiz_id))
         throw new NotFoundException();
     List<Double> points = new ArrayList<>();

     List<Response> responses = assignQuizRepository.findById(assignQuiz_id).get().getAnswers().
             stream().map(answer -> {
                 points.add(answer.getValidation().getPoint());
                 return answer.getValidation().getResponse();
             }).toList();
     List<CostumeResponseDTO> costumes = Arrays.asList(modelMapper.map(responses, CostumeResponseDTO[].class));
     for (int i=0;i<points.size();i++){
         CostumeResponseDTO costume = costumes.get(i);
         costume.setPoint(points.get(i));
         costumes.set(i, costume);
     }
     return costumes;
    }
}
