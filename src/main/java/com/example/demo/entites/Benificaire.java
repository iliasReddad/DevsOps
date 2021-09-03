package com.example.demo.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Benificaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idBenifi;
	@NotBlank
	public String nom_beni;
	@NotBlank
	public String prenom_beni;
	@NotBlank
	@Size(min = 0, max = 100)
	public String pourcentage;

	@ManyToOne
	@JoinColumn(name = "codeContrat")
	Contrat contrat;

	public Benificaire(String nom, String prenom, String pourcentage, Contrat contrat) {
		super();
		this.nom_beni = nom;
		this.prenom_beni = prenom;
		this.pourcentage = pourcentage;
		this.contrat = contrat;
	}

	public Benificaire() {
		super();
	}

}
