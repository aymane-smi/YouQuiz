package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.Entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
