package com.mtec.philosopher_api.repository;

import com.mtec.philosopher_api.model.Philosopher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhilosopherRepository extends JpaRepository<Philosopher, Long> {
}
