package br.uff.tempo.nanicolina.resources;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.ED99E92F-ACC7-2BBE-4AF0-5BB574A74206]
// </editor-fold> 
public class DangerDevice extends Device {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FB2AFC01-C3C8-280C-E848-0EA295221300]
    // </editor-fold> 
    private boolean danger;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A4165C64-7ED4-882C-36D6-FDD31244FEC1]
    // </editor-fold> 
    public DangerDevice (String name, String id, int onOff, Local localization) {
    	super (name,id,onOff,localization);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1F27A86F-AF68-95EC-36F9-57761291A931]
    // </editor-fold> 
    public boolean getDanger () {
        return danger;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.266633B8-B062-C436-B16E-74C67C721AB8]
    // </editor-fold> 
    public void setDanger (boolean val) {
        this.danger = val;
    }

}
