package br.uff.tempo.naniclina.knowledge;


import java.util.List;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3F3A2B03-024C-E7A4-B6D7-18DF9B1B6147]
// </editor-fold> 
public class LocalizationService extends ResourceAgent {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F70FD774-9DFC-C76C-98C1-AACE298444B6]
    // </editor-fold> 
    private List<Local> map;
    private static LocalizationService obj = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.807BB7DE-5705-3126-1C6C-66EEA2E9F9C9]
    // </editor-fold> 
    private LocalizationService (String URN, String URL) {
        super(URN, URL);
    }

    public static LocalizationService getInstance(String URN, String URL) {

        if (obj == null) {
            obj = new LocalizationService(URN, URL);
        }

        return obj;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6A0F9332-DD8E-ED22-D079-8C723ED6ACB7]
    // </editor-fold> 
    public List<Local> getMap () {
        return map;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0C308B54-AE8E-19C2-D4F9-2788F738B9C8]
    // </editor-fold> 
    public void setMap (List<Local> val) {
        this.map = val;
    }
    
}

