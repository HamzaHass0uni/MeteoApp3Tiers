package poo.metier;

import java.util.List;
import java.util.Set;

import poo.dao.DaoJSONFile;
import poo.dao.IDao;
import poo.entities.Agent;
import poo.entities.MeteoData;

public class Metier implements IMetier {
	private IDao dao = new DaoJSONFile("data\\meteo.json");

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	//Passage des méthodes d'accès aux données
	@Override
	public Set<Agent> getAllData() {
		return dao.getAllData();
	}
	
	@Override
	public List<MeteoData> getMeteoDataFromAgent(Set<Agent> agents, Agent agent) {
		return dao.getMeteoDataFromAgent(agents, agent);
	}

	//Méthodes business
	@Override
	public double computeAverage(List<MeteoData> data) {
		double total = 0;
		
		for(MeteoData d : data) {
			total += d.getDegre();
		}
		
		return total/data.size();
	}

	@Override
	public double computeAverageByAgent(Agent agent) {
		return computeAverage(agent.getListe());
	}

}
