package com.example.demo.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Prestation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int identifiant_Prestation;
	public String montant;
	public String type; // ( rachat total / partiel , liquidation, avance )
	@ManyToOne
	@JoinColumn(name = "CODE_CONTRAT")
	public Contrat contrat;

	public Prestation(String montant, String type, Contrat contrat) {
		super();
		this.montant = montant;
		this.type = type;
		this.contrat = contrat;
	}

	public Prestation() {
		super();
	}

}
