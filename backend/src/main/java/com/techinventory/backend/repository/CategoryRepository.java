package com.techinventory.backend.repository;

import com.techinventory.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Aquí no escribes código, Spring Data JPA hace toda la magia de los SELECT y INSERT
}