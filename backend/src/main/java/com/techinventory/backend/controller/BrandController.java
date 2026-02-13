package com.techinventory.backend.controller;

import com.techinventory.backend.model.Brand;
import com.techinventory.backend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController // Dice que esta clase es una API
@RequestMapping("/api/brands") // La URL será http://localhost:8080/api/brands
@CrossOrigin(origins = "*") // Para que Angular no tenga problemas de permisos
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public List<Brand> getBrand()
    {
        return brandRepository.findAll();
    }
    @PostMapping
    public Brand saveBrand(@RequestBody Brand brand)
    {
        return brandRepository.save(brand);
    }

    @DeleteMapping("/{id}")
    public String deleteBrand(@PathVariable Integer id)
    {
        return brandRepository.findById(id).map(
                brand -> {
                    brandRepository.delete(brand);
                    return "Brand con id: "+ id+" fue eliminado exitosamente";
                }
        ).orElse("No se encontro el brand con el id: "+ id);
    }
    @PutMapping("/{id}")
    public Brand updateBrand(@PathVariable Integer id, @RequestBody Brand brandDetails)
    {
        return brandRepository.findById(id)
                .map(brand -> {
                    brand.setName(brandDetails.getName());
                    brand.setCountryOrigin(brandDetails.getCountryOrigin());
                    return brandRepository.save(brand);
                })
                .orElseThrow(() -> new RuntimeException("Brand no encontrado con id: " + id));
    }
}
