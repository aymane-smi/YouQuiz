package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LevelServiceTest {

    @Mock
    private LevelService levelService;
    private LevelDTO levelDTO;

    @BeforeEach
    private void init(){
        levelDTO = new LevelDTO();
        levelDTO.setDescription("description");
        levelDTO.setMaxScore(1000);
        levelDTO.setMinScore(10);
        levelDTO.setId(1L);
    }

    @Test
    @DisplayName("test the scenario of creation of a new level")
    void save() {
        when(levelService.save(levelDTO)).thenReturn(levelDTO);
        LevelDTO tmp = levelService.save(levelDTO);
        assertSame(tmp, levelDTO);
    }

    @Test
    @DisplayName("test the scenario of updating of a level")
    void update() {
        levelDTO.setDescription("description*");
        when(levelService.update(1L, levelDTO)).thenReturn(levelDTO);
        LevelDTO tmp = levelService.update(1L, levelDTO);
        assertEquals(tmp.getDescription(), levelDTO.getDescription());
    }

    @Test
    @DisplayName("test the scenario of finding a level by id")
    void findById() {
        try{
            when(levelService.findById(1L)).thenReturn(levelDTO);
            LevelDTO tmp = levelService.findById(1L);
            assertSame(tmp, levelDTO);
        }catch (NotFoundException ex){}
    }

    @Test
    @DisplayName("test the scenario of finding all the records")
    void findAll() {
        List<LevelDTO> list = new ArrayList<>();
        list.add(levelDTO);
        when(levelService.findAll()).thenReturn(list);
        List<LevelDTO> tmp = levelService.findAll();
        assertSame(tmp.size(), list.size());
    }
}