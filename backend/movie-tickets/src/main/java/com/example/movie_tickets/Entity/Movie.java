package com.example.movie_tickets.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {
    @Id
    private String movieId;
    private String movieName;
    private String posterUrl;
    private Integer cumViewers;
    private Float reservRate;
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="rating_id")
    private MovieRating movieRating;

    @Builder
    private Movie(String movieId, String movieName, String posterUrl, Integer cumViewers,
                  Float reservRate, LocalDate releaseDate, MovieRating movieRating
    ){
        this.movieId = movieId;
        this.movieName = movieName;
        this.posterUrl = posterUrl;
        this.cumViewers = cumViewers;
        this.reservRate = reservRate;
        this.releaseDate = releaseDate;
        this.movieRating = movieRating;
    }
}
