package br.uff.tempo.naniclina.resources;

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

	public static Local convert(String format)
	{
		int xBegin = 0;
		int xEnd =0;
		int yBegin = 0;

		
		int i = 0;
		while(format.charAt(i) != ':')
			i++;
		i++;
		xBegin=i;
		while(format.charAt(i) != ',')
			i++;
		xEnd = i;
		i++;
		while(format.charAt(i) != ':')
			i++;
		i++;
		yBegin=i;
		return new Local(Integer.valueOf(format.substring(xBegin, xEnd)),Integer.valueOf(format.substring(yBegin)));
	}
}
