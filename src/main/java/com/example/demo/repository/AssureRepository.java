package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Assure;

public interface AssureRepository extends JpaRepository<Assure, String> {
	@Query("select codeAssure from Assure where CD_COMPTE =:x ")
	public String getId(@Param("x") String cdeCpt);

	@Query("select o from Assure o  where o.compte.codeCompte=:x ")
	public List<Assure> getList(@Param("x") String cdeCpt);

	@Query("select o from Assure o  where o.LienParente_a=:x  and  o.compte.codeCompte=:y ")
	public List<Assure> getAssure(@Param("x") String LienParente, @Param("y") String codeAssr);

	@Query("select o from Assure o  where o.compte.codeCompte=:x ")
	public List<Assure> findAllById(@Param("x") String cdeCpt);

}
