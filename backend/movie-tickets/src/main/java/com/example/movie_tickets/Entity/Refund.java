package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Refund {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger refundId;
    private LocalDateTime refundTime;
    private Integer cost;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToMany(mappedBy = "refund", fetch = FetchType.LAZY)
    private List<ReservationSeat> reservationSeats;

    @Builder
    public Refund(
            LocalDateTime refundTime, Integer cost, Reservation reservation
    ){
        this.refundTime = refundTime;
        this.cost = cost;
        this.reservation = reservation;
    }
}

