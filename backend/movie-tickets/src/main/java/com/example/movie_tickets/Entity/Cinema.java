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
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="address_id")
    private Address address;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
    private List<Room> rooms;
}
