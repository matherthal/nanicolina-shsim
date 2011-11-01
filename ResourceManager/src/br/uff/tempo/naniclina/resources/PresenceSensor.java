package br.uff.tempo.naniclina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.865CF04E-5235-4D0A-E3D0-2C2A211A39CA]
// </editor-fold> 
public class PresenceSensor extends Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1CD435B6-B23B-A7F2-AE26-5CF3E0AF8667]
    // </editor-fold> 
    private boolean presence;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CF492F79-7594-8F84-0EDE-3C807AE6AC71]
    // </editor-fold> 
    public PresenceSensor (String name, String id, int onOff, Local localization) {
    	super (name,id,onOff,localization);
    	presence = false;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C47BD0A5-BAAA-FB60-3B1D-EB0C97A7F7CE]
    // </editor-fold> 
    public boolean getPresence () {
        return presence;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.752ADD7A-F629-4BCB-F042-0FC310D8175F]
    // </editor-fold> 
    public void setPresence (boolean val) {
        this.presence = val;
    }

    public String toString()
    {
    	return super.toString();
    }
}

