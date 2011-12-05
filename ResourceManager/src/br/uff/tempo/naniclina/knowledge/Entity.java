/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uff.tempo.naniclina.knowledge;

/**
 *
 * @author Mareli
 */
public class Entity extends ResourceAgent{
    private Position position;
    public Entity (String URN, String URL, Position position)
    {
        super(URN,URL);
        this.position = position;
    }

    public void setPosition(Position position)
    {

    }

    public Position getPosition()
    {
        return position;
    }
}
