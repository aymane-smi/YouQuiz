package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.ResponseDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Service.IMPL.ResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/response")
public class ResponseController {
    @Autowired
    private ResponseService responseService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> createResponse(@Valid @RequestBody ResponseDTO responseDTO)throws Exception{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "response created");
            message.put("response", responseService.create(responseDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch (Exception e){
            throw new Exception("cannot create a response");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateResponse(@PathVariable long id, @Valid @RequestBody ResponseDTO responseDTO)throws Exception, NotFoundException{
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "response updated");
            message.put("response", responseService.update(id, responseDTO));
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        }catch (Exception e){
            throw new Exception("cannot create a response");
        }
    }
}
