package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger roomId;
    private String name;
    private String layout_url;
    private Integer seatNumber;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<Schedule> schedules;
}
