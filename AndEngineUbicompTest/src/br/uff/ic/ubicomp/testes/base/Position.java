package br.uff.ic.ubicomp.testes.base;

import java.util.ArrayList;

public class Position {
	
	private int x;
	private int y;
	
	public Position(int x, int y)
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

	public static Position convert(String format)
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
		return new Position(Integer.valueOf(format.substring(xBegin, xEnd)),Integer.valueOf(format.substring(yBegin)));
	}
}
