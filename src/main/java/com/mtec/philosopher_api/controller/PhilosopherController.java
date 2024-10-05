package com.mtec.philosopher_api.controller;


import com.mtec.philosopher_api.model.Philosopher;
import com.mtec.philosopher_api.service.PhilosopherService;
import com.mtec.philosopher_api.util.CsvExporter;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/philosophers")
public class PhilosopherController {

    @Autowired
    private PhilosopherService service;
    @Resource
    private CsvExporter csvExporter;
    @GetMapping
    public List<Philosopher> getAllPhilosophers() {
        return service.getAllPhilosophers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Philosopher> getPhilosopherById(@PathVariable Long id) {
        return service.getPhilosopherById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Philosopher createPhilosopher(@RequestBody Philosopher philosopher) {
        return service.savePhilosopher(philosopher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Philosopher> updatePhilosopher(@PathVariable Long id, @RequestBody Philosopher philosopher) {
        return service.getPhilosopherById(id)
                .map(existingPhilosopher -> {
                    existingPhilosopher.setName(philosopher.getName());
                    existingPhilosopher.setCountry(philosopher.getCountry());
                    existingPhilosopher.setPhilosophicalCurrent(philosopher.getPhilosophicalCurrent());
                    return ResponseEntity.ok(service.savePhilosopher(existingPhilosopher));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhilosopher(@PathVariable Long id) {
        return service.getPhilosopherById(id)
                .map(philosopher -> {
                    service.deletePhilosopher(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/export-csv")
    public void exportToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"philosophers.csv\"");

        List<Philosopher> philosophers = service.getAllPhilosophers();

        csvExporter.exportPhilosophers(response.getWriter(), philosophers);
    }
}
