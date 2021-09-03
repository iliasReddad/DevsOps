package com.example.demo;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entites.Client_A;
import com.example.demo.entites.Compte_A;
import com.example.demo.entites.Personne;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.CompteRepository;
import com.example.demo.repository.PersonneRepos;

@SpringBootApplication
public class AssuranceProjectApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private PersonneRepos personneRepository;
	public static void main(String[] args) {
		SpringApplication.run(AssuranceProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(compteRepository.count());

		Client_A c = new Client_A("XDS", "Ilias", "Credit Agricole Rabat");
		Client_A c2 = new Client_A("CUx", "Youssef", "Credit Agricole Hay Ryad");
		clientRepository.save(c);
		clientRepository.save(c2);
		Personne p1 = new Personne("ilias", "reddad", "M", "06/04/2000", "rabat ville", "10000", "rabat", "CIN",
				"AE12851", "iliass.reddadàuir.ac.ma", c);
		personneRepository.save(p1);

		Compte_A cpt = new Compte_A("AE122", new Date(), "225810038900485601010153", "0389004856010101", 10000, "actif",
				c);
		Compte_A cpt2 = new Compte_A("AE000", new Date(), "225810038902291601010441", "0389022916010104", 90000,
				"actif", c);
		Compte_A cpt3 = new Compte_A("XE000", new Date(), "225810035902093641012445", "0359020936410124", 0, "actif",
				c2);

//		 System.out.println(compteRepository.GETID("xVwFSyJd"));  

//		 SimpleDateFormat sdf = new SimpleDateFormat(
//             "dd-MM-yyyy HH:mm:ss");
//		 Date d1 = sdf.parse("10-01-2018 01:10:20");
//            Date d2 = new Date();
//            long difference_In_Time =d2.getTime()-d1.getTime() ;
//            System.out.println(difference_In_Time);
//            long difference_In_Days
//            = TimeUnit
//                  .MILLISECONDS
//                  .toDays(difference_In_Time)
//              % 365;
//            long difference_In_Years
//            = TimeUnit
//                  .MILLISECONDS
//                  .toDays(difference_In_Time)
//              / 365l;
//

		compteRepository.save(cpt);
		compteRepository.save(cpt2);
		compteRepository.save(cpt3);

//		 String path = "C:\\Users\\memam\\Desktop\\Ireport";
//	        File file = ResourceUtils.getFile("classpath:report18.jrxml");
//	        
//	        
//	        
//	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//	        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//	        dataSource.setUsername("SYSTEM"); 
//	        dataSource.setPassword("0000"); 
//	       Connection connection =  dataSource.getConnection();        
//	       Map<String, Object> parameters = new HashMap<>();
//	       parameters.put("id", "x6");
//	       	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters ,(java.sql.Connection) connection);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\ficheContrat.pdf");

		/* System.out.println(compteRepository.getPeopleData("test")); */

	}

}
