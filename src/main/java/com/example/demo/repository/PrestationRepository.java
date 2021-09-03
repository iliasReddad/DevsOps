package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Prestation;

public interface PrestationRepository extends JpaRepository<Prestation, Integer> {

	@Query("select o from Prestation o where o.type =:x and o.contrat.NumeroPolice =:y  ")
	public Prestation getPrest(@Param("x") String type, @Param("y") String numPolice);

}
