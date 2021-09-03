package com.example.demo.services;

import java.util.List;

import com.example.demo.entites.*;

public interface BanqueMetier {

	public Compte_A ConsulterCompte(String cptd);

	public List<Assure> ConsulterAssure(String codeCompte);

	public List<Contrat> getContrat(String codeAssure);

	public List<Contrat> getContrat2(String codeCompte);

	public Contrat getContrat3(String NumPolice);

	public List<Benificaire> getBenifi(int codeContrat);

	public List<Evenement> getEvenements(int codeContrat);

	public String getRandom();

	public String getRandom2();

	public Prestation getPrestation(String type, String numPolice);

}
