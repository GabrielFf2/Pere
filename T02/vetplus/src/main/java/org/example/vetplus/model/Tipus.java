package org.example.vetplus.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "tipus")
public class Tipus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "tipus")
    private Set<Tipus> animals;

}
