package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/motocicletas")
public class MotocicletaController {
    private final MotocicletaService motocicletaService;
    @Autowired
    public MotocicletaController(MotocicletaService motocicletaService) {
        this.motocicletaService = motocicletaService;
    }

    @GetMapping
    public ResponseEntity<List<Motocicleta>> getAllMotocicletas() {
        List<Motocicleta> motocicletas = motocicletaService.findAll();
        return new ResponseEntity<>(motocicletas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Motocicleta> getMotocicletaById(@PathVariable String id) {
        Motocicleta motocicleta = motocicletaService.findById(id);
        if (motocicleta != null) {
            return new ResponseEntity<>(motocicleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Motocicleta> createMotocicleta(@RequestBody Motocicleta motocicleta) {
        Motocicleta newMotocicleta = motocicletaService.save(motocicleta);
        return new ResponseEntity<>(newMotocicleta, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Motocicleta> updateMotocicleta(@PathVariable String id,
                                                         @RequestBody Motocicleta motocicleta) {
        Motocicleta existingMotocicleta = motocicletaService.findById(id);
        if (existingMotocicleta != null) {
            motocicleta.setId(id);
            Motocicleta updatedMotocicleta = motocicletaService.update(motocicleta);
            return new ResponseEntity<>(updatedMotocicleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotocicleta(@PathVariable String id) {
        Motocicleta existingMotocicleta = motocicletaService.findById(id);
        if (existingMotocicleta != null) {
            motocicletaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/buscar")
    public ResponseEntity<List<Motocicleta>> buscarProductos(
            @RequestParam(required = false) String placaMotocicleta, @RequestParam(required = false) String cilindrajeMotocicleta)
    {
        List<Motocicleta> motocicletas = motocicletaService.buscarPorFiltros(placaMotocicleta, cilindrajeMotocicleta);
        return new ResponseEntity<>(motocicletas, HttpStatus.OK);
    }

}
