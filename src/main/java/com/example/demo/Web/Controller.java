package com.example.demo.Web;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entites.Assure;
import com.example.demo.entites.Benificaire;
import com.example.demo.entites.Compte_A;
import com.example.demo.entites.Contrat;
import com.example.demo.entites.Evenement;
import com.example.demo.entites.Prestation;
import com.example.demo.repository.AssureRepository;
import com.example.demo.repository.BenificiaireRepository;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.EvenementRepository;
import com.example.demo.repository.PrestationRepository;
import com.example.demo.services.BanqueMetierImple;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private BanqueMetierImple banqueMetierImple;
	@Autowired
	private PrestationRepository prestationRepository;
	@Autowired
	private AssureRepository assureRepository;
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private EvenementRepository evenementRepository;
	@Autowired
	private BenificiaireRepository benificiaireRepository;
	@Autowired
	private static Compte_A conectedCompte;
	@Autowired
	private static Assure conectedAssr;

	private Benificaire benificiaire;

	public Benificaire getBenificiaire() {
		return benificiaire;
	}

	public void setBenificiaire(Benificaire benificiaire) {
		this.benificiaire = benificiaire;
	}

	@RequestMapping("/operation")
	public String index() {
		conectedCompte = null;
		return "comptes";
	}

	@RequestMapping("/demandePrestation")
	public String prest(Model model, String codeCompte, String NPolice) {
		System.out.println(NPolice);

		try {
			model.addAttribute("codeCompte", codeCompte);
			if (codeCompte != "") {
				List<Contrat> ctr = banqueMetierImple.getContrat2(codeCompte);
				model.addAttribute("contrat", ctr);
				conectedCompte = banqueMetierImple.ConsulterCompte(codeCompte);
				model.addAttribute("compte", conectedCompte);

			}
			Contrat contrat = banqueMetierImple.getContrat3(NPolice);
			model.addAttribute("contratL", contrat);

		} catch (RuntimeException e) {
			model.addAttribute("exeption", e);
			System.out.println(e.getMessage());
		}
		return "prestation";
	}

	@RequestMapping("/test")
	public String index4(Model model) {
		try {
			model.addAttribute("codeCompte", conectedCompte.getCodeCompte());
			conectedCompte = banqueMetierImple.ConsulterCompte(conectedCompte.getNumCompte());
			model.addAttribute("compte", conectedCompte);
			// String id = conectedCompte.getClient().getIdentifiantClient();
			// System.out.println(id);
			List<Assure> asr = banqueMetierImple.ConsulterAssure(conectedCompte.getCodeCompte());
			model.addAttribute("assure", asr);

		} catch (RuntimeException e) {
			model.addAttribute("exeption", e);
			System.out.println(e.getMessage());
		}
		return "souscription";
	}

	@RequestMapping("/prest")
	public String prestationCtrl(Model model) {

		return "prestation";
	}

	@RequestMapping("/printfpdf")
	public String index9(Model model, String id, String id2) throws SQLException {

		String path = "E:\\Telechargement";
		File file;
		try {

			file = ResourceUtils.getFile("classpath:report18.jrxml");
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUsername("SYSTEM");
			dataSource.setPassword("0000");
			Connection connection = dataSource.getConnection();
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("id", id);

			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					path + "\\ficheContrat" + id + "Assure N°" + id2 + ".pdf");
		} catch (FileNotFoundException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/test2?id=" + id2;

	}

	@RequestMapping("/test2")
	public String index5(Model model, String id) {
		try {
			model.addAttribute("codeCompte", conectedCompte.getCodeCompte());
			conectedCompte = banqueMetierImple.ConsulterCompte(conectedCompte.getNumCompte());
			model.addAttribute("compte", conectedCompte);
			conectedAssr = assureRepository.findById(id).orElse(null);
			model.addAttribute("assure", conectedAssr);
			List<Contrat> ctr = banqueMetierImple.getContrat(id);
			model.addAttribute("contrat", ctr);

		}

		catch (RuntimeException e) {
			model.addAttribute("exeption", e);
			System.out.println(e.getMessage());
		}
		return "contrat";
	}

	@RequestMapping("/test3")
	public String index6(Model model, String id) {
		model.addAttribute("codeAssure", id);
		conectedAssr = assureRepository.findById(id).orElse(null);
		return "saveContrat";
	}

	@RequestMapping("/test5")
	public String index6(Model model, int id, String numP) {
		model.addAttribute("numPolice", numP);
		model.addAttribute("codeAss", conectedAssr.getCodeAssure());

		try {
			List<Evenement> list = banqueMetierImple.getEvenements(id);
			model.addAttribute("evts", list);
		} catch (RuntimeException e) {
			model.addAttribute("exeption", e);
			System.out.println(e.getMessage());
		}
		return "Events";
	}

	@RequestMapping("/test6")
	public String index7(Model model, int id) {
		model.addAttribute("codeAss", conectedAssr.getCodeAssure());

		try {
			List<Benificaire> list = banqueMetierImple.getBenifi(id);
			model.addAttribute("beni", list);
		} catch (RuntimeException e) {
			model.addAttribute("exeption", e);
			System.out.println(e.getMessage());
		}
		return "Events";
	}

	@RequestMapping("/saveData")
	public String index3(Model model) {

		if (assureRepository.getAssure("Lui meme", conectedCompte.getCodeCompte()).isEmpty() == false) {
			System.out.println("test");
			model.addAttribute("check", "null");

		}
		return "saveData";
	}

	@RequestMapping("/saveAssure")
	public String SaveAssure(Model model, String codeCompte, String nomComplet, String sexe, String DateNaissance,
			String adresse, String codePostal, String Ville, String NaturePiece, String ReferencePiece,
			String LienParente, String Telephone, String SituationFamiliale, String Profession, String email) {

		String id = banqueMetierImple.getRandom();

		assureRepository.save(new Assure(id, nomComplet, sexe, DateNaissance, adresse, codePostal, Ville, NaturePiece,
				ReferencePiece, LienParente, Telephone, SituationFamiliale, Profession, email, conectedCompte));

		return "redirect:/consultercompte?codeCompte=" + conectedCompte.getNumCompte();

	}

	@RequestMapping("/saveBenifi")
	public String SaveBenif(Model model) {

//		Benificaire ben = new Benificaire( param1, Prenom, Pourcentage, null);
//		benificiaireRepository.save(ben);

		return "test";
	}

	@RequestMapping("/savePrestation")
	public String SavePrest(Model model, String Somme, String Duree, String TYPE, String Police) {

		try {
			Prestation prs = banqueMetierImple.getPrestation(TYPE, Police);
			if (prs != null) {
				model.addAttribute("error", "prestation deja ajouter ");
				System.out.println("prestation deja ajouter");
			}
		} catch (Exception e) {
			// TODO: handle exception
			Prestation prest = new Prestation(Somme, TYPE, banqueMetierImple.getContrat3(Police));
			prestationRepository.save(prest);
			model.addAttribute("succes", "prestation ajt avec succes");
		}

		if (TYPE.equals("rachat total") || TYPE.equals("liquidation")) {
			Contrat ctr = null;
			Contrat ctr2 = null;
			ctr = contratRepository.getContratByNumPolice(Police, "valide");
			ctr2 = contratRepository.getContratByNumPolice(Police, "valide");
			contratRepository.delete(ctr);
			ctr2.setEtat("RT");
			contratRepository.save(ctr2);
		}

		return "prestation";
	}

	@RequestMapping("/saveContrat")
	public String SaveContrat(Model model, Long Cotisation, String Periodicite, String Benificiare, String Nom,
			String Prenom, String Pourcentage) throws ParseException {
		String strDate = "2021-03-19";
		String numerodePolice = "C" + banqueMetierImple.getRandom2();
		Evenement evt = new Evenement("suscription", Cotisation, strDate, "en cours", "pas encor annuler", "-");
		evenementRepository.save(evt);

		Contrat contrat = new Contrat(conectedAssr, strDate, "-", Cotisation, Periodicite, numerodePolice, "valide",
				conectedCompte.getNumCompte().toString(), evt);
		contratRepository.save(contrat);
		System.err.println(contrat.MontantAccumule);

		if (Benificiare.equals("autres")) {
			Benificaire ben = new Benificaire(Nom, Prenom, Pourcentage, contrat);
			benificiaireRepository.save(ben);

		}

		return "redirect:/test2?id=" + conectedAssr.getCodeAssure();

	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String index2(Assure account, Model model) {
		model.addAttribute("account", account);

		return "saveData";
	}

	@RequestMapping("/consultercompte")
	public String index(Model model, String codeCompte) {
		model.addAttribute("codeCompte", codeCompte);
		try {
			model.addAttribute("codeCompte", codeCompte);
			conectedCompte = banqueMetierImple.ConsulterCompte(codeCompte);
			model.addAttribute("compte", conectedCompte);
			// String id = conectedCompte.getClient().getIdentifiantClient();
			// System.out.println(id);
			List<Assure> asr = banqueMetierImple.ConsulterAssure(conectedCompte.getCodeCompte());
			model.addAttribute("assure", asr);

		} catch (RuntimeException e) {
			model.addAttribute("exeption", e);
			System.out.println(e.getMessage());
		}
		return "comptes";

	}

}
