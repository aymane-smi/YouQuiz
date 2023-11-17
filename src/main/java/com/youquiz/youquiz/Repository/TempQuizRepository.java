package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.TempQuiz;
import com.youquiz.youquiz.Rename.TempID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempQuizRepository extends JpaRepository<TempQuiz, TempID> {
}
