package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entites.Compte_A;

public interface CompteRepository extends JpaRepository<Compte_A, String> {
	@Query(value = "CALL SYSTEM.GETID(:postId);", nativeQuery = true)
	String GETID(@Param("postId") String postId);

	@Query("select o from Compte_A  o  where o.numCompte=:x ")
	public Compte_A getCompte(@Param("x") String cdeCpt);

	/*
	 * @Query("select o from Compte o  where o.client.nom =:x order by o.solde desc"
	 * ) public List<Compte> listcompte(@Param("x") String cdeCpt);
	 */

	/* public Compte_A findBycodeCompteContains(@Param("codeCompte") String mc); */

}
