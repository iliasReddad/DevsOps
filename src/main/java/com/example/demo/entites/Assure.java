package com.example.demo.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Assure {
	@Id
	private String codeAssure;
	private String nomComplet_a;
	private String sexe_a;
	private String DateNaissance_a;
	private String adresse_a;
	private String codePostal_a;
	private String Ville_a;
	private String NaturePiece_a;
	private String ReferencePiece_a;
	private String LienParente_a;
	private String Telephone_a;
	private String SituationFamiliale_a;
	private String Profession_a;
	private String email_a;
	@ManyToOne
	@JoinColumn(name = "CD_COMPTE")
	private Compte_A compte;
	@OneToMany(mappedBy = "assure", fetch = FetchType.LAZY)
	Collection<Contrat> contrats;

	public Assure(String codeAssure, String nomComplet_a, String sexe_a, String dateNaissance_a, String adresse_a,
			String codePostal_a, String ville_a, String naturePiece_a, String referencePiece_a, String lienParente_a,
			String telephone_a, String situationFamiliale_a, String profession_a, String email_a, Compte_A compte) {
		super();
		this.codeAssure = codeAssure;
		this.nomComplet_a = nomComplet_a;
		this.sexe_a = sexe_a;
		DateNaissance_a = dateNaissance_a;
		this.adresse_a = adresse_a;
		this.codePostal_a = codePostal_a;
		Ville_a = ville_a;
		NaturePiece_a = naturePiece_a;
		ReferencePiece_a = referencePiece_a;
		LienParente_a = lienParente_a;
		Telephone_a = telephone_a;
		SituationFamiliale_a = situationFamiliale_a;
		Profession_a = profession_a;
		this.email_a = email_a;
		this.compte = compte;
	}

	public String getCodeAssure() {
		return codeAssure;
	}

	public void setCodeAssure(String codeAssure) {
		this.codeAssure = codeAssure;
	}

	public String getNomComplet_a() {
		return nomComplet_a;
	}

	public void setNomComplet_a(String nomComplet_a) {
		this.nomComplet_a = nomComplet_a;
	}

	public String getSexe_a() {
		return sexe_a;
	}

	public void setSexe_a(String sexe_a) {
		this.sexe_a = sexe_a;
	}

	public String getDateNaissance_a() {
		return DateNaissance_a;
	}

	public void setDateNaissance_a(String dateNaissance_a) {
		DateNaissance_a = dateNaissance_a;
	}

	public String getAdresse_a() {
		return adresse_a;
	}

	public void setAdresse_a(String adresse_a) {
		this.adresse_a = adresse_a;
	}

	public String getCodePostal_a() {
		return codePostal_a;
	}

	public void setCodePostal_a(String codePostal_a) {
		this.codePostal_a = codePostal_a;
	}

	public String getVille_a() {
		return Ville_a;
	}

	public void setVille_a(String ville_a) {
		Ville_a = ville_a;
	}

	public String getNaturePiece_a() {
		return NaturePiece_a;
	}

	public void setNaturePiece_a(String naturePiece_a) {
		NaturePiece_a = naturePiece_a;
	}

	public String getReferencePiece_a() {
		return ReferencePiece_a;
	}

	public void setReferencePiece_a(String referencePiece_a) {
		ReferencePiece_a = referencePiece_a;
	}

	public String getLienParente_a() {
		return LienParente_a;
	}

	public void setLienParente_a(String lienParente_a) {
		LienParente_a = lienParente_a;
	}

	public String getTelephone_a() {
		return Telephone_a;
	}

	public void setTelephone_a(String telephone_a) {
		Telephone_a = telephone_a;
	}

	public String getSituationFamiliale_a() {
		return SituationFamiliale_a;
	}

	public void setSituationFamiliale_a(String situationFamiliale_a) {
		SituationFamiliale_a = situationFamiliale_a;
	}

	public String getProfession_a() {
		return Profession_a;
	}

	public void setProfession_a(String profession_a) {
		Profession_a = profession_a;
	}

	public String getEmail_a() {
		return email_a;
	}

	public void setEmail_a(String email_a) {
		this.email_a = email_a;
	}

	public Compte_A getCompte() {
		return compte;
	}

	public void setCompte(Compte_A compte) {
		this.compte = compte;
	}

	public Assure() {
		super();
	}

}
