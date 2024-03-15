package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger userId;
    private String id;
    private String pw;
    private String email;
    private LocalDate birthday;
    private Boolean deleted;
    private LocalDateTime deletedTime;
    private LocalDateTime createdTime;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    @Builder
    public User(
            String id, String pw, String email, LocalDate birthday, LocalDateTime createdTime
    ){
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.birthday = birthday;
        this.createdTime = createdTime;
    }
}
