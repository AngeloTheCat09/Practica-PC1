package com.example.pracitcapc1.servicies;
import com.example.pracitcapc1.entities.App;
import com.example.pracitcapc1.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    private final AppRepository appRepository;

    @Autowired
    public AppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Transactional(readOnly = true)
    public List<App> findAll() {
        return appRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<App> findById(Long id) {
        return appRepository.findById(id);
    }

    @Transactional
    public App save(App app) {
        return appRepository.save(app);
    }

    @Transactional
    public App update(Long id, App appDetails) {
        App app = appRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("App no encontrada con id: " + id));
        app.setNombre(appDetails.getNombre());
        app.setTiempoUsoMinutos(appDetails.getTiempoUsoMinutos());
        app.setCalificacion(appDetails.getCalificacion());
        app.setTipo(appDetails.getTipo());
        app.setMemoriaOcupada(appDetails.getMemoriaOcupada());
        return appRepository.save(app);
    }

    @Transactional
    public void delete(Long id) {
        appRepository.deleteById(id);
    }

}
