package com.example.pracitcapc1.repository;

import com.example.pracitcapc1.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    // Los métodos básicos como save(), findOne(), findById(), findAll(), count(), delete(), deleteById() ya están disponibles.
    List<Dispositivo> findByTipo(String tipo);
}
