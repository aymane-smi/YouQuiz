package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.TempQuiz;
import com.youquiz.youquiz.Rename.TempID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TempQuizRepository extends JpaRepository<TempQuiz, TempID> {
    @Query("SELECT SUM(t.time) FROM TempQuiz t WHERE t.quiz = :id")
    Integer sumTimeByQuizId(@Param("id") long id);
}
