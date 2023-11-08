package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    void deleteById(long id);
}
