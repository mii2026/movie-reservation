package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger scheduleId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="room_id")
    private Room room;

    @Builder
    public Schedule(
            LocalDateTime startTime, LocalDateTime endTime, Movie movie, Room room
    ){
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.room = room;
    }
}
