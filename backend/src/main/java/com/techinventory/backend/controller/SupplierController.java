package com.techinventory.backend.controller;

import com.techinventory.backend.model.Supplier;
import com.techinventory.backend.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "*")
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;
    @GetMapping
    public List<Supplier> getSuppliers()
    {
        return supplierRepository.findAll();
    }
    @PostMapping
    public Supplier saveSupplier(@RequestBody Supplier supplier)
    {
        return supplierRepository.save(supplier);
    }
    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable Integer id)
    {
        return supplierRepository.findById(id)
                .map( supplier -> {
                    supplierRepository.delete(supplier);
                    return "Supplier con id: "+ id +" fue eliminado exitosamente";
                }).orElse("No se encontro el supplier");
    }
    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplierDetails)
    {
        return supplierRepository.findById(id)
                .map(supplier ->  {
                    supplier.setCompanyName(supplierDetails.getCompanyName());
                    supplier.setContactFirstName(supplierDetails.getContactFirstName());
                    supplier.setContactLastName(supplierDetails.getContactLastName());
                    supplier.setContactPhone(supplierDetails.getContactPhone());
                    supplier.setEmail(supplierDetails.getEmail());
                    return supplierRepository.save(supplier);
                })
                .orElseThrow(() -> new RuntimeException("Supplier no encontrado con id: " + id));
    }
}
