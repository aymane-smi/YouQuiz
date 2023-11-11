package com.youquiz.youquiz.Repository;

import com.youquiz.youquiz.DTO.ResponseDTO;
import com.youquiz.youquiz.Entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}
