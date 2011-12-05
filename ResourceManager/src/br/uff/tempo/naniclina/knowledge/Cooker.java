/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uff.tempo.naniclina.knowledge;

/**
 *
 * @author dbarreto
 */
public class Cooker extends Widget {

    private boolean turnedOn = false;

    public Cooker(String urn, String url, Position pos) {
        super(urn, url, pos);
    }

    public boolean getTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    void turnOff() {
        //TODO: implement turning off the cooker
        turnedOn = false;
    }
}
