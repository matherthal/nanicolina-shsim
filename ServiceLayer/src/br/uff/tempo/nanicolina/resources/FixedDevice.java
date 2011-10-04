package br.uff.tempo.nanicolina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1FBC02C8-8226-3AA5-A2FC-EB6E13114FAC]
// </editor-fold> 
public class FixedDevice extends Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A7F04112-080B-A1CA-8162-452FB5E3CB17]
    // </editor-fold> 
    private boolean open;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AF5DB2ED-381C-D23D-4C6F-428779B98E65]
    // </editor-fold> 
    public FixedDevice (String name, String id, int onOff, Local localization) {
    	super (name,id,onOff,localization);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.67E6CA6B-CAE0-B34B-A349-011599B9DA4A]
    // </editor-fold> 
    public boolean getOpen () {
        return open;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.37A6584B-8C9D-9409-7D77-BB6BCE5B4263]
    // </editor-fold> 
    public void setOpen (boolean val) {
        this.open = val;
    }

}
