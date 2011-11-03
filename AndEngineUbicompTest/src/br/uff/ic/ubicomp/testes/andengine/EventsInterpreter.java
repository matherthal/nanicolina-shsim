package br.uff.ic.ubicomp.testes.andengine;

import java.util.ArrayList;
import java.util.Iterator;

import android.R.bool;
import android.provider.Browser.BookmarkColumns;

public class EventsInterpreter {
	private static ArrayList<Resource> contextRepository = new ArrayList<Resource>();
	
	private static ArrayList<Service> services = new ArrayList<Service>();
	
	EventsInterpreter(){
		//Creating resource Cooker
		Resource cooker = new Resource();
		cooker.name = "cooker";
		//Creating resource property of Cooker
		ResourceProperty rp = new ResourceProperty();
		rp.name = "on/off";
		rp.state = "on";
		//Associating resource property with the resource
		cooker.properties.add(rp);
		//Adding resource into the context repository
		contextRepository.add(cooker);
	}
	
	public static void onLocationChanged(String location) {
		//TODO: create methods to cover these repetitive codes
		if (location.equals("Quarto 1")) {
			//Find Resource Cooker on Context Repository
			Iterator<Resource> resIter = contextRepository.iterator();
			boolean found = false;
			Resource cookerRes;
			//Iterating over the context
			//Stop the search if found or if the list has ended
			while (!found & resIter.hasNext()) {
				cookerRes = resIter.next();
				if (cookerRes.name.equals("cooker")) //Resource found
					found = true;
			}
			
			if (found) { //If the resource was found
				//Find Service Cooker
				Iterator<Service> servIter = services.iterator();
				found = false;
				Service cookerServ = new Service(); //Inicialization is required to cookerServ be used next
				while (!found & servIter.hasNext()) {
					cookerServ = servIter.next();
					//Searching based on the name of the service
					if (cookerServ.name.equals("cooker"))
						found = true;
				}
				
				ServiceProperty modeProp = new ServiceProperty(); //Inicialization is required to modeProp be used next
				if (found) {
					Iterator<ServiceProperty> propIter = cookerServ.properties.iterator();
					found = false;					
					while (!found & propIter.hasNext()) {
						modeProp = propIter.next();
						//Searching based on the name of the service
						if (modeProp.name.equals("on/off"))
							found = true;
					}
				}
				
				if (found) {
					modeProp.state = "off"; //TODO: how CookerAgent can be a service and a resource at the same time?
					Main.SendMessage("Desligando fogão");
					System.out.println("Desligando fogão! Aeee!");
				//	if (modeProp.state.equals("on"))
				//		modePr
				}
			}
		}
	}
}
