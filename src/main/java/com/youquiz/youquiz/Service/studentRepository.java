package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student, Long> {
}
