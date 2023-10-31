package com.youquiz.youquiz.DTO;

import com.youquiz.youquiz.Entity.Quiz;
import com.youquiz.youquiz.Entity.Student;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class AssignQuizDTO {
    private Long id;
    private double score;
    private int played;
    private double result;
    private Student student;
    private Quiz quiz;
}
