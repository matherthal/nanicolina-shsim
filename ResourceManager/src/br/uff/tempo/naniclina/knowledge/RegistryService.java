package br.uff.tempo.naniclina.knowledge;
// #[regen=yes,id=DCE.4882BF1A-C211-E60D-5C0F-58091CEBCBA6]
// </editor-fold> 
public class RegistryService extends ResourceAgent {

    private static RegistryService obj = null;

    private ResourceRepository base;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FEA29F7B-537E-AE0D-9AA8-13CEBA03E58E]
    // </editor-fold> 
    private RegistryService (String URN, String URL) {
        super(URN,URL);
        base = ResourceRepository.getInstance();
    }

    public static RegistryService getInstance(String URN, String URL) {

        if (obj == null)
            obj = new RegistryService(URN, URL);
        return obj;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.09D4FE71-B5E2-C0A9-AF34-B54506BA4534]
    // </editor-fold> 
    public boolean register (ResourceAgent resource)
    {
        base.resources.add(resource);
        //Database steps;
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D3BBCD65-FA68-5B5C-0930-DC8AA0CE41DE]
    // </editor-fold> 
    public boolean unregister (ResourceAgent resource)
    {
        base.resources.remove(resource);
        //Database steps;
        return true;
    }

}

