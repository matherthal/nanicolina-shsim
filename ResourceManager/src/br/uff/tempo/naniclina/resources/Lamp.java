package br.uff.tempo.naniclina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.25720368-9652-CADB-2B8A-CBFF1A063BF2]
// </editor-fold> 
public class Lamp extends Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5ABF433A-A683-25B2-6453-9ED9B1202108]
    // </editor-fold> 
    private double power;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1088EFE2-10A5-AC12-70CE-28437EDF77AE]
    // </editor-fold> 
    public Lamp (String name, String id, int onOff, Local localization, double power) {
    	super (name,id,onOff,localization);
    	this.power = power;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1444C797-47A4-0574-F550-99EB401C8669]
    // </editor-fold> 
    public double getPower () {
        return power;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A8A57DD5-37DD-B075-51BD-D4568CEF0646]
    // </editor-fold> 
    public void setPower (double val) {
        this.power = val;
    }
    
    public String toString()
    {
    	return super.toString()+ "Lamp Attribute: [ power: "+ power+"]";
    }

}

