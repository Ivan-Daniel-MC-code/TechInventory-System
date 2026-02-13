package com.techinventory.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok genera Getters y Setters automáticamente
@Entity // Le dice a Spring que esto es una tabla de SQL
@Table(name = "Categories") // Nombre exacto que pusiste en el script SQL
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}