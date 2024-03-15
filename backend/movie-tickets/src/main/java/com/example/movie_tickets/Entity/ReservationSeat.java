package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationSeat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger reservationSeatId;
    private Integer row;
    private Integer column;
    private String state;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "seat_id")
    private SeatType seatType;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "refund_id")
    private Refund refund;

    @Builder
    public ReservationSeat(
            Integer row, Integer column, String state,
            Reservation reservation, SeatType seatType
    ){
        this.row = row;
        this.column = column;
        this.state = state;
        this.reservation = reservation;
        this.seatType = seatType;
    }
}
