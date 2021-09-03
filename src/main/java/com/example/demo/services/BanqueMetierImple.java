package com.example.demo.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entites.Assure;
import com.example.demo.entites.Benificaire;
import com.example.demo.entites.Compte_A;
import com.example.demo.entites.Contrat;
import com.example.demo.entites.Evenement;
import com.example.demo.entites.Prestation;
import com.example.demo.repository.AssureRepository;
import com.example.demo.repository.BenificiaireRepository;
import com.example.demo.repository.CompteRepository;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.EvenementRepository;
import com.example.demo.repository.PrestationRepository;

@Service
@Transactional
public class BanqueMetierImple implements BanqueMetier {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private AssureRepository assureRepository;
	@Autowired
	private PrestationRepository prestationRepository;
	@Autowired
	private BenificiaireRepository benificiaireRepository;
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private EvenementRepository evenementRepository;

	@Override
	public Compte_A ConsulterCompte(String codeCpte) {

		Compte_A cp = compteRepository.getCompte(codeCpte);
		if (cp == null)
			throw new RuntimeException("compte Introuvable");
		return cp;
	}

	@Override
	public List<Assure> ConsulterAssure(String codeCompte) {
		// TODO Auto-generated method stub
		List<Assure> asr = null;
		asr = assureRepository.findAllById(codeCompte);
		if (asr.isEmpty())
			throw new RuntimeException("assr Introuvable");
		return asr;
	}

	@Override
	public List<Contrat> getContrat(String codeAssure) {
		// TODO Auto-generated method stub
		List<Contrat> ctr = null;
		ctr = contratRepository.getList(codeAssure);
		if (ctr.isEmpty())
			throw new RuntimeException("contrat Introuvable");
		return ctr;
	}

	@Override
	public Prestation getPrestation(String type, String numPolice) {
		// TODO Auto-generated method stub
		Prestation prst = null;
		prst = prestationRepository.getPrest(type, numPolice);
		if (prst == null)
			throw new RuntimeException("Prestation Introuvable");
		return prst;
	}

	@Override
	public List<Contrat> getContrat2(String codeCompte) {
		// TODO Auto-generated method stub
		List<Contrat> ctr = null;
		ctr = contratRepository.getListByNumPolice(codeCompte, "valide");
		if (ctr.isEmpty())
			throw new RuntimeException("contrat Introuvable");
		return ctr;
	}

	@Override
	public Contrat getContrat3(String NumPolice) {
		// TODO Auto-generated method stub
		Contrat ctr = null;
		ctr = contratRepository.getContratByNumPolice(NumPolice, "valide");
		if (ctr == null)
			throw new RuntimeException("contrat by N° police Introuvable");
		return ctr;
	}

	@Override
	public List<Benificaire> getBenifi(int codeContrat) {
		// TODO Auto-generated method stub
		List<Benificaire> bn = null;
		bn = benificiaireRepository.getList(codeContrat);
		if (bn.isEmpty())
			throw new RuntimeException("benificiaires Introuvable");
		return bn;
	}

	@Override
	public List<Evenement> getEvenements(int codeContrat) {
		// TODO Auto-generated method stub
		List<Evenement> evt = null;
		evt = evenementRepository.getList(codeContrat);
		if (evt.isEmpty())
			throw new RuntimeException("evt Introuvable");
		return evt;
	}

	public String getId(String id) {
		return assureRepository.getId(id);

	}

	@Override
	public String getRandom() {
		// create a string of uppercase and lowercase characters and numbers
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		// combine all strings
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 8;

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphaNumeric.length());

			// get character specified by index
			// from the string
			char randomChar = alphaNumeric.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		return randomString;
	}

	@Override
	public String getRandom2() {
		String numbers = "0123456789";
		// combine all strings
		String alphaNumeric = numbers;

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 10;

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphaNumeric.length());

			// get character specified by index
			// from the string
			char randomChar = alphaNumeric.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		return randomString;
	}

}
