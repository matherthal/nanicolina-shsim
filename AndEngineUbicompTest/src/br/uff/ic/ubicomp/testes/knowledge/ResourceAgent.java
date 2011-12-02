package br.uff.ic.ubicomp.testes.knowledge;

import java.util.Observable;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3B43457E-FE38-E94B-0356-9BBB1C1AB3D1]
// </editor-fold> 
public abstract class ResourceAgent extends Observable {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A42CDC22-7ED9-1576-2DFB-6DBB34416F92]
    // </editor-fold> 
    private String URN;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B72006E3-E487-8381-6134-93FE97F32C8A]
    // </editor-fold> 
    private String URL;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1EE574A6-E1DA-B82B-D26D-13A0B02ADB52]
    // </editor-fold> 
    public ResourceAgent (String URN, String URL) {
        this.URN = URN;
        this.URL = URL;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3EC980A0-81B9-1DDF-1AE5-0D9124BD87EE]
    // </editor-fold> 
    public String getURL () {
        return URL;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.506FB533-4530-684B-BC31-91BDE8EBA492]
    // </editor-fold> 
    public void setURL (String val) {
        this.URL = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B2D81DB0-2537-E388-D8C8-30F88146D4B8]
    // </editor-fold> 
    public String getURN () {
        return URN;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.85FE0B6D-7917-87D5-BB73-53A7C335A2EC]
    // </editor-fold> 
    public void setURN (String val) {
        this.URN = val;
    }

}

