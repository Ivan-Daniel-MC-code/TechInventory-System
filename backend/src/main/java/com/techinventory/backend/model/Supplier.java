package com.techinventory.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String companyName;
    @Column
    private String contactFirstName;
    @Column
    private String contactLastName;
    @Column
    private String contactPhone;
    @Column
    private String email;
}
