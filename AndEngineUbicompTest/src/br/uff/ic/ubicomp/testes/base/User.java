package br.uff.ic.ubicomp.testes.base;

public class User {

	private String name;
	private String id;
	private Local location;
	private Resource resource;
	
	public User(String name, String id, Local location)
	{
		this.name = name;
		this.id = id;
		this.location = location;
		
	}
	public String getId()
	{
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Local getLocation() {
		return location;
	}

	public void setLocation(Local location) {
		this.location = location;
	}


	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
