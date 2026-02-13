package com.techinventory.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Users")

public class User   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    private String phone;

    @Enumerated(EnumType.STRING) // Importante: Guarda el texto ('ADMIN') y no la posición (0, 1)
    @Column(nullable = false, length = 20)
    private Role role;

    @Column(nullable = false)
    private Boolean status = true; // El valor por defecto en la base de datos es 'true' por ende (1 en SQL)


    @Column(name = "created_at", nullable = false, updatable = false) // El nullbale enfatisa que si o si tiene que estar
    // lleno el campo si no, no lo recibe, y el updatable no acepta cambio alguno, se ve interesante
    private LocalDateTime createdAt = LocalDateTime.now();
}
