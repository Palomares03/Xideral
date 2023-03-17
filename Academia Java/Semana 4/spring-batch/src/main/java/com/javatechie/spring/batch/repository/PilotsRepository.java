package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Pilots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotsRepository  extends JpaRepository<Pilots,Integer> {
}
