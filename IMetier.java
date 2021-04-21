package poo.metier;

import java.util.List;
import java.util.Set;

import poo.entities.Agent;
import poo.entities.MeteoData;

public interface IMetier {
	//Méthodes d'accès aux données de dao
	public Set<Agent> getAllData();
	public List<MeteoData> getMeteoDataFromAgent(Set<Agent> agents, Agent agent);
	
	//Méthode business
	public double computeAverage(List<MeteoData> data);
	public double computeAverageByAgent(Agent agent);
}
