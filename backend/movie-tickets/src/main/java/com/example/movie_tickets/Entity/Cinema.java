package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cinema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cinemaId;
    private String cinemaName;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="address_id")
    private Address address;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
    private List<Room> rooms;

    @Builder
    private Cinema(Integer cinemaId, String cinemaName, Address address){
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.address = address;
    }
}
