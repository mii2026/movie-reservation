package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String name;
    private String posterUrl;
    private Float reservationRate;
    private LocalDate releaseDate;
    private Boolean canBook;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="rating_id")
    private MovieRating movieRating;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Schedule> schedules;

    @Builder
    private Movie(
            String name, String posterUrl, Float reservationRate,
            LocalDate releaseDate, MovieRating movieRating, Boolean canBook
    ){
        this.name = name;
        this.posterUrl = posterUrl;
        this.reservationRate = reservationRate;
        this.releaseDate = releaseDate;
        this.movieRating = movieRating;
        this.canBook = canBook;
    }
}
