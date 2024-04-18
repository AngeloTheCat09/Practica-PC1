package com.example.pracitcapc1.controller;

import com.example.pracitcapc1.entities.App;
import com.example.pracitcapc1.servicies.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app")
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping
    public ResponseEntity<List<App>> getAllApps() {
        List<App> apps = appService.findAll();
        return new ResponseEntity<>(apps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<App> getAppById(@PathVariable Long id) {
        return appService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<App> createApp(@RequestBody App app) {
        App newApp = appService.save(app);
        return new ResponseEntity<>(newApp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<App> updateApp(@PathVariable Long id, @RequestBody App appDetails) {
        try {
            App updatedApp = appService.update(id, appDetails);
            return new ResponseEntity<>(updatedApp, HttpStatus.OK);
        } catch (RuntimeException ex) {
            // RuntimeException es genérico, podrías manejar excepciones más específicas si fuera necesario.
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteApp(@PathVariable Long id) {
        try {
            appService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException ex) {
            // Aquí también podrías manejar excepciones más específicas y proporcionar diferentes respuestas HTTP en función de ellas.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
