package poo.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import poo.entities.Agent;
import poo.entities.MeteoData;

public class DaoJSONFile implements IDao {
	private String filename;

	public DaoJSONFile(String filename) {
		this.filename = filename;
	}

	@Override
	public Set<Agent> getAllData() {
		File f = new File(filename);
		Set<Agent> agents = null;
		
		XStream xs = new XStream(new JettisonMappedXmlDriver());
		
		//XStream Security
		// clear out existing permissions and set own ones
		xs.addPermission(NoTypePermission.NONE);
		// allow some basics
		xs.addPermission(NullPermission.NULL);
		xs.addPermission(PrimitiveTypePermission.PRIMITIVES);
		xs.allowTypeHierarchy(Collection.class);
		// allow any type from the same package
		xs.allowTypesByWildcard(new String[] {
		    Agent.class.getPackage().getName()+".*"
		});
		
		xs.setMode(XStream.NO_REFERENCES);
		xs.alias("agent", Agent.class);
		xs.alias("meteo-data", MeteoData.class);
		
		//Lecture du fichier JSON
		Object oJson = xs.fromXML(f);
		
		//Conversion de Object vers ArrayList<Agent>
		ArrayList<ArrayList<Agent>> list = (ArrayList<ArrayList<Agent>>) oJson;
		//System.out.println(list.size());
		ArrayList<Agent> listFinale = new ArrayList<Agent>(list.get(0));
		
		//Conversion de ArrayList<Agent> vers TreeSet<Agent>
		agents = new TreeSet<Agent>(listFinale);
		
		return agents;
	}
	
	@Override
	public List<MeteoData> getMeteoDataFromAgent(Set<Agent> agents, Agent agent) {
		for(Agent a : agents) {
			if(a.getNom().equals(agent.getNom())) {
				return a.getListe();
			}
		}
		
		return null;
	}

}
