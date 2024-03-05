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
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String  addressName;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Cinema> cinemas;
}
