package com.example.pracitcapc1.servicies;

import com.example.pracitcapc1.entities.Dispositivo;
import com.example.pracitcapc1.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    private final DispositivoRepository dispositivoRepository;

    @Autowired
    public DispositivoService(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }

    @Transactional(readOnly = true)
    public List<Dispositivo> findAll() {
        return dispositivoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Dispositivo> findById(Long id) {
        return dispositivoRepository.findById(id);
    }

    @Transactional
    public Dispositivo save(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    @Transactional
    public Dispositivo update(Long id, Dispositivo dispositivoDetails) {
        Dispositivo dispositivo = dispositivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo no encontrado"));
        dispositivo.setNombre(dispositivoDetails.getNombre());
        dispositivo.setTipo(dispositivoDetails.getTipo());
        dispositivo.setSo(dispositivoDetails.getSo());
        dispositivo.setFechaCompra(dispositivoDetails.getFechaCompra());
        return dispositivoRepository.save(dispositivo);
    }

    @Transactional
    public void delete(Long id) {
        dispositivoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Dispositivo> findByTipo(String tipo) {
        return dispositivoRepository.findByTipo(tipo);
    }
}
