package com.example.demo.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Client_A implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String IdentifiantClient;
	private String nom;

	private String agence;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Compte_A> comptes;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Personne> tiers;

	public Client_A(String identifiantClient, String nom, String agence) {
		super();
		IdentifiantClient = identifiantClient;
		this.nom = nom;
		this.agence = agence;
	}

	public Client_A() {
		super();
	}

	public String getIdentifiantClient() {
		return IdentifiantClient;
	}

	public void setIdentifiantClient(String identifiantClient) {
		IdentifiantClient = identifiantClient;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Compte_A> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte_A> comptes) {
		this.comptes = comptes;
	}

	public Collection<Personne> getTiers() {
		return tiers;
	}

	public void setTiers(Collection<Personne> tiers) {
		this.tiers = tiers;
	}

}
