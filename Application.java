package poo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import poo.entities.Agent;
import poo.entities.MeteoData;
import poo.ui.IUi;
import poo.ui.UiConsole;

public class Application {

	public static void main(String[] args) {
		//createJsonfile()	//Recréer le fichier JSON si nécessaire
		
		IUi uiConsole = new UiConsole();
		
		uiConsole.run();
		
/*	*** Code de départ que nous transformons en application 3 tiers ***
		//Définition/Chargement/Lecture des données
		Agent bob = new Agent("Bob");
		MeteoData md1 = new MeteoData(LocalDate.parse("2020-04-01"), 18.5);
		MeteoData md2 = new MeteoData(LocalDate.parse("2020-04-02"), 20);
		MeteoData md3 = new MeteoData(LocalDate.parse("2020-04-03"), 16);
		
		bob.getListe().add(md1);
		bob.getListe().add(md2);
		bob.getListe().add(md3);
		
		//Traitement des données		
		double moyenne = computeAverage(bob.getListe);
		
		//Affichage
		System.out.println("La moyenne des relevés de "
				+ bob.getNom() + " est de "
				+ moyenne +".");
**************** */
	}
	
	/**
	 * Méthode du code de départ (ne sera plus utilisée)
	 * 
	 * @param data
	 * @return
	 */
	private double computeAverage(List<MeteoData> data) {
		double total = 0;
		
		for(MeteoData d : data) {
			total += d.getDegre();
		}
		
		return total/data.size();
	}
	
	/**
	 * Code pour créer le fichier JSON
	 * Modifiez les données pour tester
	 */
	private void createJsonfile() {
		//Définition des données ----------
		Set<Agent> ts = new TreeSet<Agent>();
		Agent bob = new Agent("Bob","Bruxelles");
		MeteoData md1 = new MeteoData(LocalDate.parse("2020-04-01"), 18.5);
		MeteoData md2 = new MeteoData(LocalDate.parse("2020-04-02"), 20);
		MeteoData md3 = new MeteoData(LocalDate.parse("2020-04-03"), 16);
		
		bob.getListe().add(md1);
		bob.getListe().add(md2);
		bob.getListe().add(md3);
		ts.add(bob);
		
		Agent fred = new Agent("Fred","Anvers");
		MeteoData md4 = new MeteoData(LocalDate.parse("2020-04-01"), 12);
		MeteoData md5 = new MeteoData(LocalDate.parse("2020-04-02"), 24);
		MeteoData md6 = new MeteoData(LocalDate.parse("2020-04-03"), 18);
		
		fred.getListe().add(md4);
		fred.getListe().add(md5);
		fred.getListe().add(md6);
		ts.add(fred);
		//-----------------
		
		//Sérialisation des données en JSON
		//Il faut convertir le TreeSet en ArrayList avant de le sérialiser!
		ArrayList<Agent> list = new ArrayList<Agent>();
		ts.stream().forEach((agent)->list.add(agent));
		
		File f = new File("data\\meteo.json");
		try {
			FileWriter fr = new FileWriter(f);
			BufferedWriter br = new BufferedWriter(fr);
			
			XStream xs = new XStream(new JettisonMappedXmlDriver());
			xs.setMode(XStream.NO_REFERENCES);
			xs.alias("agent", Agent.class);
			xs.alias("meteo-data", MeteoData.class);
			
			xs.toXML(list, br);
		} catch(IOException e) {
			System.out.println("Erreur");
		}
	}

}
