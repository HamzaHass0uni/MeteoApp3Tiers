package poo.entities;

import java.util.ArrayList;

public class Agent implements Comparable<Agent> {
	private String nom;
	private String lieu;
	private ArrayList<MeteoData> liste;
	
	public Agent() {
	}

	public Agent(String nom, String lieu) {
		super();
		this.nom = nom;
		this.lieu = lieu;
		this.liste = new ArrayList<MeteoData>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public ArrayList<MeteoData> getListe() {
		return liste;
	}

	public void setListe(ArrayList<MeteoData> liste) {
		this.liste = liste;
	}
	
	@Override
	public String toString() {
		return "Agent [nom=" + nom + ", lieu=" + lieu + ", liste=" + liste + "]";
	}

	@Override
	public int compareTo(Agent agent) {
		return nom.compareTo(agent.getNom());
	}
	
}
