package com.project.nasaweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ROL_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role", length = 50, nullable = false)
    private String role;
}
