package com.example.pracitcapc1.controller;

import com.example.pracitcapc1.entities.Dispositivo;
import com.example.pracitcapc1.servicies.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dispositivos")
public class DispositivoController {

    private final DispositivoService dispositivoService;

    @Autowired
    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    @GetMapping
    public ResponseEntity<List<Dispositivo>> getAllDispositivos() {
        List<Dispositivo> dispositivos = dispositivoService.findAll();
        return new ResponseEntity<>(dispositivos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id) {
        return dispositivoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo) {
        Dispositivo newDispositivo = dispositivoService.save(dispositivo);
        return new ResponseEntity<>(newDispositivo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivoDetails) {
        try {
            Dispositivo updatedDispositivo = dispositivoService.update(id, dispositivoDetails);
            return new ResponseEntity<>(updatedDispositivo, HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDispositivo(@PathVariable Long id) {
        try {
            dispositivoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Dispositivo>> getDispositivosByTipo(@PathVariable String tipo) {
        List<Dispositivo> dispositivos = dispositivoService.findByTipo(tipo);
        return new ResponseEntity<>(dispositivos, HttpStatus.OK);
    }
}