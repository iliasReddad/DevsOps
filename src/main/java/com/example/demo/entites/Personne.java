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
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int identifiantPersonne;
	private String Prenom;
	private String Nom_P;
	private String sexe;
	private String DateNaissance;
	private String adresse;
	private String codePostal;
	private String Ville;
	private String NaturePiece;
	private String ReferencePiece;
	private String email;
	@ManyToOne
	@JoinColumn(name = "CD_CLIENT")
	private Client_A client;

	public Personne(String Nom, String Prenom, String sexe, String dateNaissance, String adresse, String codePostal,
			String ville, String naturePiece, String referencePiece, String email, Client_A c) {
		super();
		this.Nom_P = Nom;
		this.Prenom = Prenom;
		this.sexe = sexe;
		DateNaissance = dateNaissance;
		this.adresse = adresse;
		this.codePostal = codePostal;
		Ville = ville;
		NaturePiece = naturePiece;
		ReferencePiece = referencePiece;
		this.email = email;
		this.client = c;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		DateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getNaturePiece() {
		return NaturePiece;
	}

	public void setNaturePiece(String naturePiece) {
		NaturePiece = naturePiece;
	}

	public String getReferencePiece() {
		return ReferencePiece;
	}

	public void setReferencePiece(String referencePiece) {
		ReferencePiece = referencePiece;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client_A getClient() {
		return client;
	}

	public void setClient(Client_A client) {
		this.client = client;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getNom() {
		return Nom_P;
	}

	public void setNom(String nom) {
		Nom_P = nom;
	}

}
