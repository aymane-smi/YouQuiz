package com.youquiz.youquiz.Controller;

import com.youquiz.youquiz.DTO.StudentDTO;
import com.youquiz.youquiz.DTO.TrainerDTO;
import com.youquiz.youquiz.Exceptions.NotFoundException;
import com.youquiz.youquiz.Service.IMPL.TrainerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/trainers", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<TrainerDTO>> getTrainers() {
        List<TrainerDTO> trainers = trainerService.getAll();
        return ResponseEntity.ok(trainers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrainerDTO> findTrainerByID(@PathVariable Long id) throws NotFoundException {
        TrainerDTO trainer = trainerService.findByID(id);
        return ResponseEntity.ok(trainer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable Long id) throws NotFoundException {
        trainerService.delete(id);
        return new ResponseEntity<>("Trainer deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainerDTO> updateTrainer(@PathVariable Long id, @Valid @RequestBody TrainerDTO trainerDto) throws NotFoundException {
        TrainerDTO updatedTrainer = trainerService.update(id, trainerDto);
        return ResponseEntity.ok(updatedTrainer);
    }

    @PostMapping
    public ResponseEntity<TrainerDTO> saveTrainer(@Valid @RequestBody TrainerDTO trainerDto) throws NotFoundException {
        TrainerDTO updatedTrainer = trainerService.save(trainerDto);
        return ResponseEntity.ok(updatedTrainer);
    }

    @GetMapping("/find/{page}")
    public ResponseEntity<List<TrainerDTO>> findTrainerByLimit(@PathVariable int page) throws NotFoundException{
        List<TrainerDTO> trainers = trainerService.findByLimit(page);
        return ResponseEntity.ok(trainers);
    }
}