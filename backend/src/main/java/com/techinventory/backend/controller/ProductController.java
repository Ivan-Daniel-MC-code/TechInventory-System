package com.techinventory.backend.controller;

import com.techinventory.backend.model.Product;
import com.techinventory.backend.repository.BrandRepository;
import com.techinventory.backend.repository.CategoryRepository;
import com.techinventory.backend.repository.ProductRepository;
import com.techinventory.backend.repository.SupplierRepository;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    //Para todos los productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok) // Forzamos el tipo genérico aquí
                .orElse(ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se pudo encontrar el producto con id: " + id));
    }

    @PostMapping
    public Product createProduct(@Nonnull @RequestBody Product product) {
        // 1. Validar que la categoría exista antes de seguir
        if (!categoryRepository.existsById(product.getCategory().getId())) {
            throw new RuntimeException("Error: La categoría no existe");
        }

        // 2. Validar que la marca exista
        if (!brandRepository.existsById(product.getBrand().getId())) {
            throw new RuntimeException("Error: La marca no existe");
        }

        if (!supplierRepository.existsById(product.getSupplier().getId())) {
            throw new RuntimeException("Error: El proveedor no existe");
        }

        return productRepository.save(product);
    }

    // El Delete es igual al que ya perfeccionaste
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return "Producto " + product.getName() + " eliminado correctamente.";
                }).orElse("No se encontró el producto con ID: " + id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product productdetails) {
        return productRepository.findById(id)
                .map(product -> {
                    // 1. Actualizamos datos básicos
                    product.setSku(productdetails.getSku());
                    product.setName(productdetails.getName());
                    product.setDescription(productdetails.getDescription());
                    product.setPrice(productdetails.getPrice());
                    product.setStock(productdetails.getStock());
                    product.setMinStock(productdetails.getMinStock());
                    product.setImageUrl(productdetails.getImageUrl());

                    if(!categoryRepository.existsById(productdetails.getCategory().getId())) {
                        throw new RuntimeException("Error: La Categoria con ID: "  + productdetails.getCategory().getId()+ " no existe");
                    }
                    product.setCategory(productdetails.getCategory());

                    if(!brandRepository.existsById(productdetails.getBrand().getId())) {
                        throw new RuntimeException("Error: La marca con ID: "  + productdetails.getBrand().getId()+ " no existe");
                    }
                    product.setBrand(productdetails.getBrand());

                    if(!supplierRepository.existsById(productdetails.getSupplier().getId())) {
                        throw new RuntimeException("Error: El Proveedor con ID: "  + productdetails.getBrand().getId()+ " no existe");
                    }
                    product.setSupplier(productdetails.getSupplier());

                    return productRepository.save(product);
                }).orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

}
