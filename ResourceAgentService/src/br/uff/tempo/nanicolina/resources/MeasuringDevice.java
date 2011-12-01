package br.uff.tempo.nanicolina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B7945296-4B1F-7236-0201-3B0B5F513FBC]
// </editor-fold> 
public class MeasuringDevice extends Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EE27EFFA-D42A-C366-9292-0B6A41EE8FE9]
    // </editor-fold> 
    private double value;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0FFFCD73-7139-4A3B-A5C2-6532C33D97BC]
    // </editor-fold> 
    public MeasuringDevice (String name, String id, int onOff, Local localization) {
    	super (name,id,onOff,localization);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A0258C21-131B-DBE9-37AE-DE7A5423020C]
    // </editor-fold> 
    public double getValue () {
        return value;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.688DCCBB-20CD-1AC9-BE53-EBDCFDEB6EB4]
    // </editor-fold> 
    public void setValue (double val) {
        this.value = val;
    }

}

