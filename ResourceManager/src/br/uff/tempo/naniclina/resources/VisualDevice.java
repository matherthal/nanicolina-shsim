package br.uff.tempo.naniclina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3128E51D-2852-E916-3080-FFF727FE2820]
// </editor-fold> 
public class VisualDevice extends Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0CEC80BB-972C-D6E0-C688-CA245FD4391B]
    // </editor-fold> 
    public VisualDevice (String name, String id, int onOff, Local localization) {
    	super (name,id,onOff,localization);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.29B732B8-1B50-0004-CC50-BA4B6EBE1C16]
    // </editor-fold> 
    public void showMessage (String msg) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8FC7A86F-1A98-9289-82E9-2CE19AAE1AE7]
    // </editor-fold> 
    public void showVideo (String source) {
    }
    
    public String toString()
    {
    	return super.toString();
    }
}
