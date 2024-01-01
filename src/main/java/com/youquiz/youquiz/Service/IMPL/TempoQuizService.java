package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.tempoQuiz.TempoQuizDTO;
import com.youquiz.youquiz.Entity.TempQuiz;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Rename.TempID;
import com.youquiz.youquiz.Repository.QuestionRepository;
import com.youquiz.youquiz.Repository.QuizRepository;
import com.youquiz.youquiz.Repository.TempQuizRepository;
import com.youquiz.youquiz.Service.ITempoQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempoQuizService implements ITempoQuizService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private TempQuizRepository tempQuizRepository;
    @Override
    public void create(TempoQuizDTO tempQuiz) throws NotFoundException, Exception {
        if(tempQuizRepository.sumTimeByQuizId(tempQuiz.getQuiz_id())+tempQuiz.getDuration() < quizRepository.findDurationInMinutesByQuizId(tempQuiz.getQuiz_id())*60){
            if(quizRepository.existsById(tempQuiz.getQuiz_id()) == false || questionRepository.existsById(tempQuiz.getQuestion_id()) == false)
                throw new NotFoundException();
            TempID tempID = new TempID(tempQuiz.getQuiz_id(), tempQuiz.getQuestion_id());
            if (tempQuizRepository.existsById(tempID) == true)
                throw new Exception("question already assigned to the quiz");
            tempQuizRepository.save(new TempQuiz(
                    tempID,
                    tempQuiz.getDuration(),
                    quizRepository.findById(tempQuiz.getQuiz_id()).get(),
                    questionRepository.findById(tempQuiz.getQuestion_id()).get()
            ));
        }else{
            throw new RuntimeException("the question duration have a big duration to the quiz");
        }

    }
}
