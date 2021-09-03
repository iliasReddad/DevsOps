package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Benificaire;

public interface BenificiaireRepository extends JpaRepository<Benificaire, Integer> {
	@Query("select o from Benificaire o where o.contrat.idContrat =:x ")
	public List<Benificaire> getList(@Param("x") int cdeCtr);
}
