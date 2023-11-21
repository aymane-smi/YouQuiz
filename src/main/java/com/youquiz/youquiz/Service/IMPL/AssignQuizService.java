package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.AssignQuiz.AssignQuizDTO;
import com.youquiz.youquiz.DTO.AssignQuiz.AssignQuizResponseDTO;
import com.youquiz.youquiz.Entity.AssignQuiz;
import com.youquiz.youquiz.Entity.Quiz;
import com.youquiz.youquiz.Entity.Student;
import com.youquiz.youquiz.Exceptions.MaxAttemptsReachedException;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.AssignQuizRepository;
import com.youquiz.youquiz.Repository.QuizRepository;
import com.youquiz.youquiz.Repository.StudentRepository;
import com.youquiz.youquiz.Service.IAssignQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignQuizService implements IAssignQuizService {
    @Autowired
    private AssignQuizRepository assignQuizRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AssignQuizDTO> saveAll(List<AssignQuizDTO> assignQuizDtos) throws NotFoundException{
        return assignQuizDtos.stream()
                .map(assignQuizDto -> {
                    List<AssignQuiz> existingAssignQuizzes = assignQuizRepository.findByStudentIdAndQuizId(
                            assignQuizDto.getStudent_id(), assignQuizDto.getQuiz_id());

                    if (!existingAssignQuizzes.isEmpty()) {
                        AssignQuiz existingAssignQuiz = null;
                        try {
                            existingAssignQuiz = existingAssignQuizzes.stream()
                                    .max(Comparator.comparingInt(AssignQuiz::getPlayed))
                                    .orElseThrow(() -> new NotFoundException("No AssignQuiz found"));
                        } catch (NotFoundException e) {
                            throw new RuntimeException(e);
                        }

                        int chanceNum = existingAssignQuiz.getQuiz().getChanceNbr();
                        if (existingAssignQuiz.getPlayed() >= chanceNum) {
                            throw new MaxAttemptsReachedException("Max attempts reached for student id: "
                                    + assignQuizDto.getStudent_id() + ", quiz id: " + assignQuizDto.getQuiz_id());
                        }

                        AssignQuiz newAssignQuiz = new AssignQuiz();
                        newAssignQuiz.setPlayed(existingAssignQuiz.getPlayed() + 1);
                        newAssignQuiz.setQuiz(existingAssignQuiz.getQuiz());
                        newAssignQuiz.setStudent(existingAssignQuiz.getStudent());
                        newAssignQuiz.setReason(existingAssignQuiz.getReason());
                        newAssignQuiz.setResult(existingAssignQuiz.getResult());
                        newAssignQuiz.setEndDate(existingAssignQuiz.getEndDate());
                        newAssignQuiz.setDebutDate(existingAssignQuiz.getDebutDate());
                        return assignQuizRepository.save(newAssignQuiz);
                    } else {
                        AssignQuiz assignQuiz = modelMapper.map(assignQuizDto, AssignQuiz.class);

                        if (assignQuizDto.getQuiz_id() != null) {
                            Quiz quiz = null;
                            try {
                                quiz = quizRepository.findById(assignQuizDto.getQuiz_id())
                                        .orElseThrow(() -> new NotFoundException("The quiz with id " + assignQuizDto.getQuiz_id() + " is not found"));
                            } catch (NotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            assignQuiz.setQuiz(quiz);
                        }

                        if (assignQuizDto.getStudent_id() != null) {
                            Student student = null;
                            try {
                                student = studentRepository.findById(assignQuizDto.getStudent_id())
                                        .orElseThrow(() -> new NotFoundException("The student with id " + assignQuizDto.getStudent_id() + " is not found"));
                            } catch (NotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            assignQuiz.setStudent(student);
                        }

                        return assignQuizRepository.save(assignQuiz);
                    }
                })
                .map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Long id) throws NotFoundException{
        AssignQuiz assignQuiz = assignQuizRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        assignQuizRepository.delete(assignQuiz);
    }

    @Override
    public List<AssignQuizResponseDTO> getAll() {
        List<AssignQuiz> assignQuizzes = assignQuizRepository.findAll();
        return assignQuizzes.stream()
                .map(assignQuiz -> modelMapper.map(assignQuiz, AssignQuizResponseDTO.class))
                .toList();
    }

    @Override
    public AssignQuizResponseDTO findByID(Long id) throws NotFoundException{
        AssignQuiz assignQuiz = assignQuizRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        return modelMapper.map(assignQuiz, AssignQuizResponseDTO.class);
    }

    @Override
    public AssignQuizDTO update(Long id, AssignQuizDTO assignQuizDto) throws NotFoundException{
        AssignQuiz existingAssignQuiz = assignQuizRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        existingAssignQuiz.setPlayed(assignQuizDto.getPlayed());
        existingAssignQuiz.setReason(assignQuizDto.getReason());
        existingAssignQuiz.setResult(assignQuizDto.getResult());
        existingAssignQuiz.setEndDate(assignQuizDto.getEndDate());
        existingAssignQuiz.setDebutDate(assignQuizDto.getDebutDate());

        if (assignQuizDto.getQuiz_id() != null) {
            Quiz quiz = quizRepository.findById(assignQuizDto.getQuiz_id())
                    .orElseThrow(() -> new NotFoundException());
            existingAssignQuiz.setQuiz(quiz);
        }

        if (assignQuizDto.getStudent_id() != null) {
            Student student = studentRepository.findById(assignQuizDto.getStudent_id())
                    .orElseThrow(() -> new NotFoundException());
            existingAssignQuiz.setStudent(student);
        }
        existingAssignQuiz = assignQuizRepository.save(existingAssignQuiz);
        return modelMapper.map(existingAssignQuiz, AssignQuizDTO.class);
    }
}
