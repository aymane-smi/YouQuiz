package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.LevelDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
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
    public ResponseEntity<Map<String, Object>> createLevel(@Valid @RequestBody LevelDTO level) throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "created");
            message.put("level", levelService.save(level));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            throw new Exception("cannot create a new level");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> editLevel(@PathVariable long id, @Valid @RequestBody LevelDTO level) throws NotFoundException, Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "updated");
            message.put("level", levelService.update(id, level));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("cannot update the level");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findLevelById(@PathVariable long id) throws NotFoundException{
        Map<String, Object> message = new HashMap<>();
        try {
            message.put("level", levelService.findById(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException(e.getMessage());
        }
    }

    @GetMapping("/{id}/questions")
    public ResponseEntity<Map<String, Object>> findLevelQuestionById(@PathVariable long id)throws Exception, NotFoundException{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("questions", levelService.findLevelQuestionById(id));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(NotFoundException e){
            throw new NotFoundException(e.getMessage());
        }catch (Exception e){
            throw new Exception("cannot find the level");
        }
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> findLevels() throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("levels", levelService.findAll());
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception("cannot find all the levels");
        }
    }
}
