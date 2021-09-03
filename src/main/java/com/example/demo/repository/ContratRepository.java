package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, String> {
	@Query("select o from Contrat o where o.assure.codeAssure =:x order by o.idContrat desc  ")
	public List<Contrat> getList(@Param("x") String cdeCpt);

	@Query("select o from Contrat o where o.assure.compte.numCompte =:x and o.MontantAccumule > 0 and o.etat=:v order by o.idContrat desc  ")
	public List<Contrat> getListByNumPolice(@Param("x") String cdeCpt, @Param("v") String etat);

	@Query("select o from Contrat o where o.NumeroPolice =:x  and o.etat=:v  order by o.idContrat desc  ")
	public Contrat getContratByNumPolice(@Param("x") String cdeCpt, @Param("v") String etat);

}
