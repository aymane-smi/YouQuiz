package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.Question.QuestionResponseDTO;
import com.youquiz.youquiz.DTO.Quiz.QuizDTO;
import com.youquiz.youquiz.Entity.*;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.QuizRepository;
import com.youquiz.youquiz.Repository.SubjectRepository;
import com.youquiz.youquiz.Repository.TrainerRepository;
import com.youquiz.youquiz.Service.IQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizService implements IQuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public QuizDTO save(QuizDTO quizDto) throws Exception {
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        if (quizDto.getTrainer_id() != null) {
            Trainer trainer = trainerRepository.findById(quizDto.getTrainer_id())
                    .orElseThrow(() -> new Exception("The trainer with id " + quizDto.getTrainer_id() + " is not found"));
            quiz.setTrainer(trainer);
        }
        if(quizDto.getSubject_id() != null){
            Subject subject = subjectRepository.findById(quizDto.getSubject_id()).orElseThrow(()->new NotFoundException("subject id doesn't exist"));
            quiz.setSubject(subject);
        }
        quiz = quizRepository.save(quiz);
        return modelMapper.map(quiz, QuizDTO.class);
    }

    @Override
    public void delete(long id) throws Exception{
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The quiz with id " + id + " is not found"));
        quizRepository.delete(quiz);
    }

    @Override
    public QuizDTO findByID(long id) throws Exception {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new Exception("The quiz with id " + id + " is not found"));
        return modelMapper.map(quiz, QuizDTO.class);
    }

    @Override
    public List<QuizDTO> getAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream()
                .map(quiz -> modelMapper.map(quiz, QuizDTO.class))
                .toList();
    }

    @Override
    public QuizDTO update(long id, QuizDTO quizDto) throws Exception {
        Quiz existingQuiz = quizRepository.findById(id)
                .orElseThrow(() -> new Exception("The quiz with id " + id + " is not found"));
        existingQuiz.setScore(quizDto.getScore());
        existingQuiz.setChanceNbr(quizDto.getChanceNbr());
        existingQuiz.setRemark(quizDto.getRemark());
        existingQuiz.setShowAnswers(quizDto.getShowAnswers());
        existingQuiz.setShowFinalResults(quizDto.getShowFinalResults());
        existingQuiz.setDurationInMinutes(quizDto.getDurationInMinutes());
        if (quizDto.getTrainer_id() != null) {
            Trainer trainer = trainerRepository.findById(quizDto.getTrainer_id())
                    .orElseThrow(() -> new Exception("The trainer with id " + quizDto.getTrainer_id() + " is not found"));
            existingQuiz.setTrainer(trainer);
        }else {
            existingQuiz.setTrainer(null);
        }
        if (quizDto.getSubject_id() != null) {
            Subject subject = subjectRepository.findById(quizDto.getTrainer_id())
                    .orElseThrow(() -> new Exception("The subject with id " + quizDto.getSubject_id() + " is not found"));
            existingQuiz.setSubject(subject);
        }else {
            existingQuiz.setSubject(null);
        }
        Quiz updatedQuiz = quizRepository.save(existingQuiz);
        return modelMapper.map(updatedQuiz, QuizDTO.class);
    }

    @Override
    public List<QuestionResponseDTO> getQuizResponse(long id)throws Exception{
        Quiz existingQuiz = quizRepository.findById(id)
                .orElseThrow(() -> new Exception("The quiz with id " + id + " is not found"));
        List<QuestionResponseDTO> questions = new ArrayList<>();
        for(TempQuiz tempQuiz:existingQuiz.getTempoQuiz()){
            var question = modelMapper.map(tempQuiz.getQuestion(), QuestionResponseDTO.class);
            question.setDuration(tempQuiz.getTime());
            questions.add(question);
        }
        return Arrays.asList(modelMapper.map(questions, QuestionResponseDTO[].class));
    }
}
