package br.uff.tempo.nanicolina.resources;

public class Local {
	
	private int x;
	private int y;
	
	public Local(int x, int y)
	{
		this.x = x;
		this.y = y;		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String toString()
	{
		return "x: "+x +", y: "+ y;
	}

}
