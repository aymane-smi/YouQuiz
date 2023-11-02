package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.Entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation, Long> {
}
