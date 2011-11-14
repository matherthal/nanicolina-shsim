package br.uff.ic.ubicomp.testes.base;

import java.util.ArrayList;

public class Local {
	
	private String name;
	
	private ArrayList<User> users;
	private ArrayList<Resource> resources;
	
	//espa�o � retratado em termo de retangulos
	private Position vertex0; //v�rtice inferior esquerda
	private Position vertexF; //v�rtice superior direita
	
	public Local (Position vertex0, Position vertexF)
	{
		this.vertex0= vertex0;
		this.vertexF= vertexF;
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
	}
	
	public ArrayList<Resource> getResources()
	{
		return resources;
	}
	
	public boolean isInner(Position position) {
		if ((position.getX()>vertex0.getX()) && (position.getX()<vertexF.getX()))
			return (position.getY()>vertex0.getY()) && (position.getY()<vertexF.getY());
		return false;
	}
	
}
