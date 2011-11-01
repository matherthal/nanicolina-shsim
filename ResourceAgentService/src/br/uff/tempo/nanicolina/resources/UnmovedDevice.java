package br.uff.tempo.nanicolina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.03B49950-F409-A3AF-AAF9-9EDA5BB50F99]
// </editor-fold> 
public class UnmovedDevice extends Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E428FBBD-9935-8410-EF96-892BF875A085]
    // </editor-fold> 
    private boolean locked;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0ED35015-FBFB-45F1-2CA3-42F8AE747171]
    // </editor-fold> 
    public UnmovedDevice (String name, String id, int onOff, Local localization) {
    	super (name,id,onOff,localization);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FF79555B-EBAC-086B-4EE4-7C969439CA7B]
    // </editor-fold> 
    public boolean getLocked () {
        return locked;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5AC35C43-F1AA-4B97-53CA-D649A6E720C0]
    // </editor-fold> 
    public void setLocked (boolean val) {
        this.locked = val;
    }

}
