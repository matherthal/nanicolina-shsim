/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uff.tempo.naniclina.knowledge;

public class Tuple<X, Y> {

    private X x;
    private Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return this.x;
    }

    public Y getY() {
        return this.y;
    }
}
