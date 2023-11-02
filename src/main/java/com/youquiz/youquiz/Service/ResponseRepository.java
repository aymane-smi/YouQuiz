package com.youquiz.youquiz.Service;

import com.youquiz.youquiz.Entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
