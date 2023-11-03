package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
