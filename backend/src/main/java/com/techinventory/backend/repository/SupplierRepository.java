package com.techinventory.backend.repository;

import com.techinventory.backend.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
