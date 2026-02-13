package com.techinventory.backend.controller;

import com.techinventory.backend.model.User;
import com.techinventory.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController // Dice que esta clase es una API
@RequestMapping("/api/users") // La URL será http://localhost:8080/api/users
@CrossOrigin(origins = "*") // Para que Angular no tenga problemas de permisos

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    @PostMapping
    public User saveUser(@RequestBody User user)
    {
        // El método .save() de JpaRepository es inteligente:
        // Si el objeto no tiene ID, hace un INSERT en SQL Server.
        // Si el objeto tiene ID, hace un UPDATE.
        return userRepository.save(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User userDetails)
    {
        return userRepository.findById(id)
                .map(user ->  {
                    user.setFirstName(userDetails.getFirstName());
                    user.setLastName(userDetails.getLastName());
                    user.setEmail(userDetails.getEmail());
                    user.setPasswordHash(userDetails.getPasswordHash());
                    user.setPhone(userDetails.getPhone());
                    user.setRole(userDetails.getRole());
                    user.setStatus(userDetails.getStatus());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id)
    {
    return userRepository.findById(id)
            .map(user -> {
                userRepository.delete(user);
                return "Usuario eliminado con id: " + id + " eliminado con éxito";
            }).orElse("No se encontro el usuario con ID: " + id);
    /*if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return ("Usuario eliminado");
        }
        else{
            return("No existe el usuario");
        }*/
    }
}
