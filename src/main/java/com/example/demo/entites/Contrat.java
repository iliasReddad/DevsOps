package com.example.demo.entites;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Contrat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idContrat;
	@ManyToOne
	@JoinColumn(name = "CD_ASSURE")
	public Assure assure;
	public String dateCreation;
	public String dateResiliation;
	public long MontantAccumule;
	// @NotBlank
	public long montant;
//	@NotBlank
	public String periodicite;
	public String etat;
	public String NumeroPolice;
	public String numeroCompteBancaire;
	public final int duree_contrat = 60;
	@OneToMany(mappedBy = "contrat", fetch = FetchType.LAZY)
	Collection<Benificaire> benificaire;
	@OneToMany(mappedBy = "contrat", fetch = FetchType.LAZY)
	Collection<Prestation> prestation;
	@OneToOne
	@JoinColumn(name = "Evene_id")
	Evenement evenement;

	public Contrat(Assure assure, String dateCreation, String dateResiliation, long montant, String periodicite,
			String NumeroPolice, String etat, String numeroCompteBancaire, Evenement evenement) {
		super();
		long monthsBetween = 0;
		this.assure = assure;
		this.NumeroPolice = NumeroPolice;
		this.dateCreation = dateCreation;
		this.dateResiliation = dateResiliation;
		this.montant = montant;
		this.periodicite = periodicite;
		this.etat = etat;
		this.numeroCompteBancaire = numeroCompteBancaire;
		this.evenement = evenement;
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		LocalDate date1 = LocalDate.parse("2021-03-19");
		LocalDate date2 = LocalDate.parse(timeStamp);
		if (periodicite.equals("Mensuelle")) {
			monthsBetween = ChronoUnit.MONTHS.between(YearMonth.from(date1), YearMonth.from(date2));
			if (date1.isBefore(date2) && date1.getDayOfMonth() > date2.getDayOfMonth() && monthsBetween != 0) {
				monthsBetween -= 1;
			}
		} else if (periodicite.equals("Annuelle")) {
			monthsBetween = ChronoUnit.YEARS.between(YearMonth.from(date1), YearMonth.from(date2));
			if (date1.isBefore(date2) && date1.getDayOfMonth() > date2.getDayOfMonth() && monthsBetween != 0) {
				monthsBetween -= 1;
			}
		} else if (periodicite.equals("Semestrielle")) {
			monthsBetween = ChronoUnit.MONTHS.between(YearMonth.from(date1), YearMonth.from(date2));
			monthsBetween = (monthsBetween - 1) / 6;
		} else if (periodicite.equals("Trimestrielle")) {
			monthsBetween = ChronoUnit.MONTHS.between(YearMonth.from(date1), YearMonth.from(date2));
			monthsBetween = (monthsBetween - 1) / 3;
		}

		this.MontantAccumule = this.montant * monthsBetween;
		System.err.println(monthsBetween);
		System.err.println(MontantAccumule);

	}

	public Contrat() {
		super();
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
