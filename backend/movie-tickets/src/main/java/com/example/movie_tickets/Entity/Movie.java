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
    @Id
    private String movieId;
    private String movieName;
    private String posterUrl;
    private Float reservRate;
    private LocalDate releaseDate;
    private Boolean canBook;
    private Boolean boxOffice = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="rating_id")
    private MovieRating movieRating;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Schedule> schedules;

    @Builder
    private Movie(String movieId, String movieName, String posterUrl, Float reservRate,
                  LocalDate releaseDate, MovieRating movieRating, Boolean canBook
    ){
        this.movieId = movieId;
        this.movieName = movieName;
        this.posterUrl = posterUrl;
        this.reservRate = reservRate;
        this.releaseDate = releaseDate;
        this.movieRating = movieRating;
        this.canBook = canBook;
    }
}
