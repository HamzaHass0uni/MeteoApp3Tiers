package poo.dao;

import java.util.List;
import java.util.Set;

import poo.entities.Agent;
import poo.entities.MeteoData;

public interface IDao {
	/**
	 * Renvoie tous les relevés groupés par Agent
	 * 
	 * @return
	 */
	public Set<Agent> getAllData();
	public List<MeteoData> getMeteoDataFromAgent(Set<Agent> agents, Agent agent);	
}
