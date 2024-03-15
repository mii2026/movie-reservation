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
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger reservationId;
    private LocalDateTime reservationTime;
    private Integer cost;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "paytype_id")
    private PayType payType;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
    private List<ReservationSeat> reservationSeats;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
    private List<Refund> refunds;

    @Builder
    public Reservation(
            LocalDateTime reservationTime, Integer cost,
            User user, Schedule schedule, PayType payType
    ){
        this.reservationTime = reservationTime;
        this.cost = cost;
        this.user = user;
        this.schedule = schedule;
        this.payType = payType;
    }
}
