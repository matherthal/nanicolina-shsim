package br.uff.ic.ubicomp.testes.andengine;

import java.util.ArrayList;

public abstract class Resource extends Service{
	public String name;
	public String id;
	public String local;
	public ArrayList<ResourceProperty> properties = new ArrayList<ResourceProperty>();
}
