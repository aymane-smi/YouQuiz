package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query("SELECT q.durationInMinutes FROM Quiz q WHERE q.id = :id")
    Integer findDurationInMinutesByQuizId(@Param("id") long id);

}
