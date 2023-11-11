package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.DTO.ResponseDTO;
import com.youquiz.youquiz.DTO.ValidationDTO;
import com.youquiz.youquiz.Entity.Response;
import com.youquiz.youquiz.Entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Long> {
    //List<ValidationDTO> findValidationsByQuestion(long id);
}
