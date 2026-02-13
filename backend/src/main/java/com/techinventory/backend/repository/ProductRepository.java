package com.techinventory.backend.repository;

import com.techinventory.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Al poner "BrandId", Spring entiende: "Entra al objeto brand y busca por su atributo id"
    List<Product> findByBrandId(Integer brandId);

    // Lo mismo para la categoría
    List<Product> findByCategoryId(Integer categoryId);

    List<Product>findBySupplierId(Integer spuplierId);

    // Este ya lo tenías bien
    Optional<Product> findBySku(String sku);
}
