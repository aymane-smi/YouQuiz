package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.Entity.TempQuiz;
import com.youquiz.youquiz.Rename.TempID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempQuizRepository extends JpaRepository<TempQuiz, TempID> {
}
