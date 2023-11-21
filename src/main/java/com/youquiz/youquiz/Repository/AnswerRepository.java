package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    public int countAnswerByValidationIdAndAndAssignQuiz_Id(long validation_id, long assign_id);
}
