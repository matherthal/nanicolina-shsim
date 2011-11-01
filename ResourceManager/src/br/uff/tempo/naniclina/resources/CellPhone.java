package br.uff.tempo.naniclina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0D20ABC2-5B0F-6680-5E54-D592AA49892A]
// </editor-fold> 

public class CellPhone extends Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D1D1CD8E-95B5-AD0D-FF31-76E2E4DC7EFF]
    // </editor-fold> 
    private boolean silent;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.32AE9843-E819-78B0-1E4E-A46E3F04488E]
    // </editor-fold> 
    public CellPhone (String name, String id, int onOff, Local localization) {
    	super (name,id,onOff,localization);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.06226DC0-7059-B303-A9A7-809C1D309110]
    // </editor-fold> 
    public boolean getSilent () {
        return silent;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E01834BF-FCE3-507C-5BEF-872C13FF3653]
    // </editor-fold> 
    public void setSilent (boolean val) {
        this.silent = val;
    }

}
