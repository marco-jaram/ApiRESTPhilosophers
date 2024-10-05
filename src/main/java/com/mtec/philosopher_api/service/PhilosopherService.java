package com.mtec.philosopher_api.service;

import com.mtec.philosopher_api.model.Philosopher;
import com.mtec.philosopher_api.repository.PhilosopherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhilosopherService {

    @Autowired
    private PhilosopherRepository repository;

    public List<Philosopher> getAllPhilosophers() {
        return repository.findAll();
    }

    public Optional<Philosopher> getPhilosopherById(Long id) {
        return repository.findById(id);
    }

    public Philosopher savePhilosopher(Philosopher philosopher) {
        return repository.save(philosopher);
    }

    public void deletePhilosopher(Long id) {
        repository.deleteById(id);
    }
}

