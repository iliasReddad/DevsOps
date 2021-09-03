package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.*;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {

	@Query("select o from Evenement o where o.contrat.idContrat =:x ")
	public List<Evenement> getList(@Param("x") int cdeCtr);

}
