package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomName;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="cinema_id")
    private Cinema cinema;
}
