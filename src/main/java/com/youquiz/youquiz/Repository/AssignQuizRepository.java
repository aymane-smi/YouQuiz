package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.AssignQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignQuizRepository extends JpaRepository<AssignQuiz, Long> {
    List<AssignQuiz> findByStudentIdAndQuizId(long student_id, long quiz_id);
}
