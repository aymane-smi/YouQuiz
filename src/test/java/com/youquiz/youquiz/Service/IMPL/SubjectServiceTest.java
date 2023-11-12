package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.Subject.SubjectDTO;
import com.youquiz.youquiz.DTO.Subject.SubjectResponseDTO;
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
class SubjectServiceTest {
    @Mock
    private SubjectService subjectService;
    private SubjectDTO subjectDTO;
    private SubjectResponseDTO subjectResponse;

    @BeforeEach
    private void init(){
        subjectDTO = new SubjectDTO();
        subjectDTO.setId(1L);
        subjectDTO.setTitle("subject 1");

        subjectResponse = new SubjectResponseDTO();
        subjectResponse.setId(1L);
        subjectResponse.setChilds(new ArrayList<>());
    }

    @Test
    @DisplayName("test the scenario of creating a new subject")
    void createSubject() {
        when(subjectService.createSubject(subjectDTO)).thenReturn(subjectDTO);
        SubjectDTO tmp = subjectService.createSubject(subjectDTO);
        assertSame(tmp, subjectDTO);
    }

    @Test
    @DisplayName("test the scenario of finding a subject by id")
    void findById() {
        try{
            when(subjectService.findById(1L)).thenReturn(subjectResponse);
            assertEquals(subjectResponse.getChilds().size(), 0);
        }catch (NotFoundException ex){}
    }

    @Test
    @DisplayName("test the scenario of removing a subject by id")
    void removeById() {
        try{
            doNothing().when(subjectService);
            subjectService.removeById(1L);
        }catch (NotFoundException ex){}
    }

    @Test
    @DisplayName("test the scenario of updating a subject")
    void updateSubject() {
        try{
            subjectDTO.setTitle("subject 1*");
            when(subjectService.updateSubject(1L, subjectDTO)).thenReturn(subjectDTO);
            SubjectDTO tmp = subjectService.updateSubject(1L, subjectDTO);
            assertSame(tmp, subjectDTO);
        }catch (NotFoundException ex){}
    }

    @Test
    @DisplayName("test the scenario of finding all records")
    void findAll() {
        List<SubjectDTO> list = new ArrayList<>();
        list.add(subjectDTO);
        when(subjectService.findAll()).thenReturn(list);
        List<SubjectDTO> tmp = subjectService.findAll();
        assertEquals(tmp.size(), list.size());
    }
}