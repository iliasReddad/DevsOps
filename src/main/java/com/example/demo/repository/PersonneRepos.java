package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Personne;;

public interface PersonneRepos extends JpaRepository<Personne, Integer> {

}
