package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
