package poo.ui;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import poo.entities.Agent;
import poo.entities.MeteoData;
import poo.metier.IMetier;
import poo.metier.Metier;

public class UiConsole implements IUi {
	private IMetier metier;
	
	public UiConsole() {
		this.metier = new Metier();
	}
	
	public UiConsole(IMetier metier) {
		this.metier = metier;
	}

	public IMetier getMetier() {
		return metier;
	}

	public void setMetier(IMetier metier) {
		this.metier = metier;
	}

	@Override
	public void run() {
		//Lecture des donn�es
		Set<Agent> agents = metier.getAllData();	//En r�alit�, c'est dao qui le fera
		
		//Traitement des donn�es: recherche sp�cifique
		Agent agent = new Agent("Bob", "Bruxelles");
		List<MeteoData> dataBob = metier.getMeteoDataFromAgent(agents, agent);
		
		//Traitement des donn�es: calcul sp�cifique		
		double moyenne = metier.computeAverage(dataBob);
		
		//Affichage du r�sultat
		System.out.println("La moyenne des relev�s de "
				+ agent.getNom() + " est de "
				+ (new DecimalFormat("#.00")).format(moyenne) +".");
		
		//
		
		//Traitement des donn�es: recherche sp�cifique
		agent = new Agent("Fred", "");
		
		//Traitement des donn�es: calcul sp�cifique		
		moyenne = metier.computeAverage(metier.getMeteoDataFromAgent(agents, agent));
		
		//Affichage du r�sultat
		System.out.println("La moyenne des relev�s de "
				+ agent.getNom() + " est de "
				+ (new DecimalFormat("#.00")).format(moyenne) +".");

	}

}
