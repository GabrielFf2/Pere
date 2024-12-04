package org.example.vetplus.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Column
    private String numRegistre;
    @ManyToMany
    private Tipus tipus;
}
