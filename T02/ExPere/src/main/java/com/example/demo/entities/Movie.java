package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movies")
public class Movie {

    @Id @GeneratedValue
    private long id;

    private String title;

    @Column(name="description")
    private String synopsis;

    private int year;

//    @ManyToOne
//    private Genre genre;

//    public Movie(long id, String title, String synopsis, int year) {
//        this.id = id;
//        this.title = title;
//        this.synopsis = synopsis;
//        this.year = year;
//    }
}
