package com.techinventory.backend.repository;

import com.techinventory.backend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
