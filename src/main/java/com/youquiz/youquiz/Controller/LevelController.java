package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.Service.IMPL.LevelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/level", produces = MediaType.APPLICATION_JSON_VALUE)
public class LevelController {
    @Autowired
    private LevelService levelService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> createLevel(@Valid @RequestBody LevelDTO level){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "created");
            message.put("level", levelService.save(level));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("message", "cannot create a new level");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> editLevel(@PathVariable long id, @Valid @RequestBody LevelDTO level){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "updated");
            message.put("level", levelService.update(id, level));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            message.put("message", "cannot update the leve level");
            return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
