package br.uff.ic.ubicomp.testes.andengine;

import java.util.ArrayList;
import java.util.Iterator;

import br.uff.ic.ubicomp.testes.base.Resource;

import android.R.bool;
import android.os.Environment;
import android.provider.Browser.BookmarkColumns;

public class EventsInterpreter {
	private ArrayList<Resource> contextRepository = new ArrayList<Resource>();
	
	//private ArrayList<Service> services = new ArrayList<Service>();
	
	private Main environment;
	
	//Singleton
	private static EventsInterpreter instance = null;
	
	protected EventsInterpreter(){
		//Get reference to the environment representation
		//environment = Main.getInstance();
		
		//Creating resource Cooker
		CookerAgent cooker = new CookerAgent();
		cooker.setName("cooker");
		//Creating resource property of Cooker
		
		//Associating resource property with the resource
		cooker.setOnOff(1);
		//Adding resource into the context repository
		contextRepository.add(cooker);
	}

	public static EventsInterpreter getInstance() {
		if(instance == null) {
			instance = new EventsInterpreter();
		}
		return instance;
	}
	//////
	
	public String onLocationChanged(String location) {
		//TODO: create methods to cover these repetitive codes
		if (location.equals("Quarto 1")) {
			//Find Resource Cooker on Context Repository
			Iterator<Resource> resIter = contextRepository.iterator();
			boolean found = false;
			Resource res;
			CookerAgent cookerAgent = null;
			//Iterating over the context
			//Stop the search if found or if the list has ended
			while (!found & resIter.hasNext()) {
				res = resIter.next();
				if (res.getName().equals("cooker")) {//Resource found
					cookerAgent = (CookerAgent)res; 
					found = true;
				}
			}
			
			/*if (found) { //If the resource was found
				ResourceProperty prop = null;
				Iterator<ResourceProperty> propIter = cookerAgent.properties.iterator();
				found = false;					
				while (!found & propIter.hasNext()) {
					prop = propIter.next();
					//Searching based on the name of the service
					if (prop.name.equals("on/off"))						
						found = true;
				}*/
				
				//if (found) {
					if (cookerAgent.getOnOff()== 1) {//ECA condition attended
						cookerAgent.turnCookerOff(); //Action	
						return "Fogão desligado!";
					}
				//}
			}
		//}
		return "Nenhuma ação";
	}
}
