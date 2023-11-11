package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.MediaDTO;
import com.youquiz.youquiz.Service.IMPL.MediaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/media")
public class Mediacontroller {
    @Autowired
    private MediaService mediaService;
    @PostMapping
    public ResponseEntity<Map<String, Object>> createMedia(@Valid @RequestBody MediaDTO mediaDTO){
        Map<String, Object> message = new HashMap<>();
        try{
            message.put("message", "media created");
            message.put("media", mediaService.create(mediaDTO));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }catch(Exception e){
            message.put("error", "cannot create the media for the question");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
