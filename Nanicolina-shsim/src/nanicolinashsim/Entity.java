/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim;

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
}
