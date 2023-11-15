package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.MediaDTO;
import com.youquiz.youquiz.DTO.Question.QuestionDTO;
import com.youquiz.youquiz.DTO.QuestionResponseDTO;
import com.youquiz.youquiz.DTO.ResponseDTO;
import com.youquiz.youquiz.DTO.TempoQuizDTO;
import com.youquiz.youquiz.Entity.Media;
import com.youquiz.youquiz.Entity.Question;
import com.youquiz.youquiz.Entity.Quiz;
import com.youquiz.youquiz.Entity.TempQuiz;
import com.youquiz.youquiz.Enum.QuestionType;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Rename.TempID;
import com.youquiz.youquiz.Repository.*;
import com.youquiz.youquiz.Service.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private TempQuizRepository tempQuizRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public QuestionResponseDTO create(QuestionDTO questionDTO)throws NotFoundException {
        Question question = modelMapper.map(questionDTO, Question.class);
        question.setSubject(
                subjectRepository.findById(questionDTO.getSubject_id()).get()
        );
        question.setLevel(
                levelRepository.findById(questionDTO.getLevel_id()).get()
        );
        question.setType(
                QuestionType.valueOf(questionDTO.getType())
        );
        if(questionDTO.getMedias().size() > 0){
            List<Media> medias = Arrays.asList(modelMapper.map(questionDTO.getMedias(), Media[].class));
            for(int i=0;i<medias.size();i++){
                Media media = medias.get(i);
                media.setQuestion(question);
                medias.set(i, media);
            }
            question.setMedias(medias);
        }
        Question afterSave = questionRepository.save(question);
        if(questionDTO.getId() <= -1 || quizRepository.existsById(questionDTO.getQuiz_id()) == false)
            throw new NotFoundException("quiz id doesn't existe");
        Quiz quiz = quizRepository.findById(questionDTO.getQuiz_id()).get();
        tempQuizRepository.save(new TempQuiz(
                new TempID(quiz.getId(), afterSave.getId()),
                questionDTO.getDuration(),
                quiz,
                question
        ));
        return modelMapper.map(
                afterSave, QuestionResponseDTO.class
        );
    }

    @Override
    public QuestionResponseDTO update(long id, QuestionDTO questionDTO) throws NotFoundException {
        if(id <= 0)
            throw new NotFoundException();
        Question question = questionRepository.findById(id).get();
        if(questionDTO.getQuestionText().isEmpty() == false)
            question.setQuestionText(
                    questionDTO.getQuestionText()
            );
        if(questionDTO.getCorrectResponseNbr() != 0)
            question.setCorrectResponseNbr(
                    questionDTO.getCorrectResponseNbr()
            );
        if(questionDTO.getResponseNbr() != 0)
            question.setResponseNbr(
                    questionDTO.getResponseNbr()
            );
        if(questionDTO.getTotalScore() != 0)
            question.setTotalScore(
                    questionDTO.getTotalScore()
            );
        if(questionDTO.getSubject_id() != 0)
            question.setSubject(
                    subjectRepository.findById(questionDTO.getSubject_id()).get()
            );
        if(questionDTO.getLevel_id() != 0)
            question.setLevel(
                    levelRepository.findById(questionDTO.getLevel_id()).get()
            );
        question.setType(
                QuestionType.valueOf(questionDTO.getType())
        );
        return modelMapper.map(questionRepository.save(question), QuestionResponseDTO.class);
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if(id <= 0 || questionRepository.existsById(id) == false)
            throw new NotFoundException();
        questionRepository.deleteById(id);
    }

    @Override
    public List<MediaDTO> findQuestionMedia(long id) throws NotFoundException{
        Question question = questionRepository.findById(id).get();
        if(id <= 0 || question == null)
            throw new NotFoundException();
        return Arrays.asList(modelMapper.map(question.getMedias(), MediaDTO[].class));
    }

    @Override
    public List<QuestionResponseDTO> findAll() {
        return Arrays.asList(modelMapper.map(questionRepository.findAll(), QuestionResponseDTO[].class));
    }

    @Override
    public List<ResponseDTO> findResponses(long id) throws NotFoundException {
        Question question = questionRepository.findById(id).get();
        if(id <= 0 || question == null)
            throw new NotFoundException();
        List<ResponseDTO> responses = new ArrayList<>();
        question.getValidations().forEach((v)->{
            responses.add(modelMapper.map(v.getResponse(), ResponseDTO.class));
        });
        return responses;
    }

    @Override
    public void detachQuiz(long id, long quiz_id)throws NotFoundException, Exception{
        TempID tempId= new TempID(quiz_id, id);
        if(!tempQuizRepository.existsById(tempId))
            throw new NotFoundException();
        tempQuizRepository.deleteById(tempId);
    }
    @Override
    public TempoQuizDTO PatchQuiz(long id, TempoQuizDTO tempoQuizDTO)throws NotFoundException, Exception{
        TempID tempId= new TempID(tempoQuizDTO.getQuiz_id(), id);
        if(!tempQuizRepository.existsById(tempId))
            throw new NotFoundException();
        TempQuiz tempQuiz = tempQuizRepository.findById(tempId).get();
        tempQuiz.setTime(tempoQuizDTO.getDuration());
        tempoQuizDTO.setQuestion_id(id);
        tempQuizRepository.save(tempQuiz);
        return tempoQuizDTO;
    }

}
