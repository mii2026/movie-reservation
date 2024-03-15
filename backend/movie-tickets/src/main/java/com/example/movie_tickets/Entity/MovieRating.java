package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieRating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RatingId;
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "movieRating", fetch = FetchType.LAZY)
    private List<Movie> movies;
}
