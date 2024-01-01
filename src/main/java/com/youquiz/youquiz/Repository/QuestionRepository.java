package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    void deleteById(long id);
    @Query("SELECT q.totalScore FROM Question q WHERE q.id = :id")
    Double findTotalScoreByQuestionId(@Param("id") long id);
}
