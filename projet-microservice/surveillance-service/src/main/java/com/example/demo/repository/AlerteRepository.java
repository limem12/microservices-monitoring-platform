package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Alerte;

public interface AlerteRepository extends JpaRepository<Alerte, Long> {
}
