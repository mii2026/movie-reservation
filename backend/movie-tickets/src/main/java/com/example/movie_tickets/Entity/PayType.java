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
public class PayType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paytypeId;
    private String name;

    @OneToMany(mappedBy = "payType", fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}
