package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Client_A;

public interface ClientRepository extends JpaRepository<Client_A, Long> {

}
