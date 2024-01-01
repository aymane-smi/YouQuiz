package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Long> {
    //List<ValidationDTO> findValidationsByQuestion(long id);
    @Query("SELECT SUM (v.point) FROM Validation v WHERE v.question = :id")
    Double sumOfResponseByQuestion(@Param("id") long id);
}
