/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uff.tempo.naniclina.knowledge;

/**
 *
 * @author matheus
 */
public class Bed extends Widget {

    private boolean used = false;

    public Bed(String urn, String url, Position pos) {
        super(urn, url, pos);
    }

    public boolean getUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
