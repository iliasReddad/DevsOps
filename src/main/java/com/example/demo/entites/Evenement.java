package com.example.demo.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idEvenement;
	public String nomEvenement;
	public Long montant;
	public String dateEvenement;
	public String statut;
	public String motifAnnulation;
	public String DateAnnulation;
	@OneToOne(mappedBy = "evenement", cascade = CascadeType.ALL)
	Contrat contrat;

	public Evenement(String nomEvenement, Long cotisation, String dateEvenement, String statut, String motifAnnulation,
			String dateAnnulation) {
		super();
		this.nomEvenement = nomEvenement;
		this.montant = cotisation;
		this.dateEvenement = dateEvenement;
		this.statut = statut;
		this.motifAnnulation = motifAnnulation;
		DateAnnulation = dateAnnulation;
	}

	public Evenement() {
		super();
	}

}
