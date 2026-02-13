package com.techinventory.backend.controller;

import com.techinventory.backend.model.Category;
import com.techinventory.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController // Dice que esta clase es una API
@RequestMapping("/api/categories") // La URL será http://localhost:8080/api/categories
@CrossOrigin(origins = "*") // Para que Angular no tenga problemas de permisos
public class  CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // Este método devuelve todas las categorías que insertamos en SQL
    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryRepository.delete(category);
                    return ("Se elimino el categori con id: "+id+"exitosamente");
                }).orElse("No se encontro el catergory con id: "+id);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category categoryDetails) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(categoryDetails.getName());
                    category.setDescription(categoryDetails.getDescription());
                    return categoryRepository.save(category);
                }).orElseThrow(() -> new RuntimeException("Category no encontrado con id: " + id));
    }

}