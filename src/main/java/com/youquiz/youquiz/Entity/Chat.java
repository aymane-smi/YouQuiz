package com.youquiz.youquiz.Entity;

import com.youquiz.youquiz.Enum.Sender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NonNull
    @Column(length = 200, nullable = false)
    private String message;
    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = true)
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = true)
    private Student student;
    @NonNull
    @Column(name = "message_time", nullable = false)
    private LocalDateTime messageTime;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Sender sender;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
