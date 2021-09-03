
package com.example.demo.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NamedStoredProcedureQuery(name = "SYSTEM.GETID", procedureName = "SYSTEM.GETID" ,parameters = { 
//		@StoredProcedureParameter(type = String.class , name = "POSTID" , mode = ParameterMode.IN),
//@StoredProcedureParameter(type = String.class ,  name = "CODE" ,mode = ParameterMode.OUT)
//		
//		
//}
//		)
@Entity
@Data
public class Compte_A {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String codeCompte;
	private Date dateOuverture;
	private String RIB;
	private String numCompte;
	private double solde;
	private String statut;
	@ManyToOne
	@JoinColumn(name = "CODE_CLIENT")
	private Client_A client;

	public Compte_A(String codeCompte, Date dateOuverture, String rIB, String numCompte, double solde, String statut,
			Client_A client) {
		super();
		this.codeCompte = codeCompte;
		this.dateOuverture = dateOuverture;
		RIB = rIB;
		this.numCompte = numCompte;
		this.solde = solde;
		this.statut = statut;
		this.client = client;
	}

	public Compte_A() {
		super();
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Client_A getClient() {
		return client;
	}

	public void setClient(Client_A client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Compte_A orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
