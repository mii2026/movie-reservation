package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;
    private Integer cost;

    @OneToMany(mappedBy = "seatType", fetch = FetchType.LAZY)
    private List<ReservationSeat> reservationSeats;
}
