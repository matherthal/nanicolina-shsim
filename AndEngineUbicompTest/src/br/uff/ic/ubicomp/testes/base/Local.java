package br.uff.ic.ubicomp.testes.base;

import java.util.ArrayList;

public class Local {
	
	private String name;
	
	private ArrayList<User> users;
	private ArrayList<Resource> resources;
	
	//espaço é retratado em termo de retangulos
	private Position vertex0; //vértice inferior esquerda
	private Position vertexF; //vértice superior direita
	
	public Local (String name, Position vertex0, Position vertexF)
	{
		this.name = name;
		this.vertex0= vertex0;
		this.vertexF= vertexF;
		users = new ArrayList<User>();
		resources = new ArrayList<Resource>();
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	public void setUsers(ArrayList<User> users)
	{
		this.users = users; 
	}
	
	public ArrayList<Resource> getResources()
	{
		return resources;
	}
	
	public void setResources(ArrayList<Resource> resources)
	{
		this.resources = resources; 
	}
	
	public boolean isInner(Position position) {
		if ((position.getX()>vertex0.getX()) && (position.getX()<vertexF.getX()))
			return (position.getY()>vertex0.getY()) && (position.getY()<vertexF.getY());
		return false;
	}
	
}
