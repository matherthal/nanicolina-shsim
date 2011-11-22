/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim;

/**
 *
 * @author Mareli
 */
public class Position {

	private float x;
	private float y;

	public Position(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
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
		return new Position(Float.valueOf(format.substring(xBegin, xEnd)),Float.valueOf(format.substring(yBegin)));
	}
}

