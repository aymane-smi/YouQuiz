package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
