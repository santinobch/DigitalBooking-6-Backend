package com.example.DigitalBookingBEG6.controller;

import com.example.DigitalBookingBEG6.model.Categoria;
import com.example.DigitalBookingBEG6.model.dto.CategoriaDTO;
import com.example.DigitalBookingBEG6.service.impl.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoriaController {
    @Autowired
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoriaDTO>> listAll(Model model) {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<CategoriaDTO> nuevo(@Valid @RequestBody CategoriaDTO categoriaDTO){
        return ResponseEntity.status(201).body(service.save(categoriaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id){
        return ResponseEntity.status(204).body(service.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO){
        return ResponseEntity.ok(service.modify(id, categoriaDTO));
    }
}
