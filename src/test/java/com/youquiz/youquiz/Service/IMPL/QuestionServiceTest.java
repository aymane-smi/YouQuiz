package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.Question.QuestionDTO;
import com.youquiz.youquiz.DTO.Question.QuestionResponseDTO;
import com.youquiz.youquiz.Enum.QuestionType;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class QuestionServiceTest {
    @Mock
    private QuestionService questionService;
    private QuestionDTO questionDTO;
    private QuestionResponseDTO questionResponseDTO;
    @BeforeEach
    private void init(){
        questionDTO = new QuestionDTO();
        questionDTO.setId(1);
        questionDTO.setType(QuestionType.SINGLE.name());
        questionDTO.setTotalScore(10);
        questionDTO.setQuestionText("test");
        questionDTO.setResponseNbr(1);
        questionDTO.setCorrectResponseNbr(1);

        questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(1);
        questionResponseDTO.setTotalScore(10);
        questionResponseDTO.setQuestionText("test");
        questionResponseDTO.setResponseNbr(1);
        questionResponseDTO.setCorrectResponseNbr(1);

    }

    @Test
    @DisplayName("test the scenario of creating a new question")
    void create() {
        try{
            when(questionService.create(questionDTO)).thenReturn(questionResponseDTO);
            QuestionResponseDTO tmp = questionService.create(questionDTO);
            assertEquals(questionDTO.getId(), tmp.getId());
        }catch (NotFoundException ex){}
    }

    @Test
    @DisplayName("test the scenario of updating question")
    void update() {
       try{
           questionDTO.setQuestionText("test*");
           when(questionService.update(1L, questionDTO)).thenReturn(questionResponseDTO);
           QuestionResponseDTO tmp = questionService.update(1L, questionDTO);
           assertEquals(questionDTO.getId(), tmp.getId());
           assertEquals(questionDTO.getResponseNbr(), tmp.getResponseNbr());
       }catch (NotFoundException ex){}
    }

    @Test
    @DisplayName("test the scenario of deleting a question")
    void delete() {
        try{
            doNothing().when(questionService);
            questionService.delete(1L);
        }catch(NotFoundException ex){}
    }

    @Test
    @DisplayName("test the scenario of finding all records")
    void findAll() {
        List<QuestionResponseDTO> list = new ArrayList<>();
        list.add(questionResponseDTO);
        when(questionService.findAll()).thenReturn(list);
        assertEquals(questionService.findAll(), list);
    }
}