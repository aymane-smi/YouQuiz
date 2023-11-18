package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.Quiz.QuizDTO;
import com.youquiz.youquiz.DTO.Quiz.QuizResponseDTO;
import com.youquiz.youquiz.Entity.Quiz;
import com.youquiz.youquiz.Entity.Trainer;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Repository.QuizRepository;
import com.youquiz.youquiz.Repository.TrainerRepository;
import com.youquiz.youquiz.Service.IQuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService implements IQuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public QuizDTO save(QuizDTO quizDto) throws Exception {
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        if (quizDto.getTrainer_id() != null) {
            Trainer trainer = trainerRepository.findById(quizDto.getTrainer_id())
                    .orElseThrow(() -> new Exception("The trainer with id " + quizDto.getTrainer_id() + " is not found"));
            quiz.setTrainer(trainer);
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
    public QuizResponseDTO findByID(long id) throws Exception {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new Exception("The quiz with id " + id + " is not found"));
        return modelMapper.map(quiz, QuizResponseDTO.class);
    }

    @Override
    public List<QuizResponseDTO> getAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream()
                .map(quiz -> modelMapper.map(quiz, QuizResponseDTO.class))
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
        /*if (quizDto.getTrainer_id() != null) {
            Trainer trainer = trainerRepository.findById(quizDto.getTrainer_id())
                    .orElseThrow(() -> new Exception("The trainer with id " + quizDto.getTrainer_id() + " is not found"));
            existingQuiz.setTrainer(trainer);
        }else {*/
            //existingQuiz.setTrainer(null);
        //}
        Quiz updatedQuiz = quizRepository.save(existingQuiz);
        return modelMapper.map(updatedQuiz, QuizDTO.class);
    }
}
