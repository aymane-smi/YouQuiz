package com.youquiz.youquiz.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chat> chats;
}
