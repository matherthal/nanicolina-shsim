package nanicolinashsim;

import java.util.ArrayList;
import java.util.List;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3A1B9179-41A4-57B8-EEC9-CAB557407536]
// </editor-fold> 
public class DiscoveryService extends ResourceAgent {

    private static DiscoveryService obj = null;
    private ResourceRepository base;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F2AA0071-09A6-769E-BE4D-7F462A5EBBD7]
    // </editor-fold> 
    private DiscoveryService (String URN,String URL)
    {
        super(URN,URL);
        base = ResourceRepository.getInstance();
    }

    public static DiscoveryService getInstance(String URN, String URL) {

        if (obj == null) {
            obj = new DiscoveryService(URN,URL);
        }

        return obj;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CFC20F80-102C-89C5-403B-45040F6760E1]
    // </editor-fold> 
    public ResourceAgent getResourceAgent (String URN) {
        //Database steps
        for (ResourceAgent r : base.resources) {
           if (r.getURN().equals(URN))
               return r;
        }
        return null;

    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BAF7AE46-1C8D-6D93-B3F0-BE39789BAD11]
    // </editor-fold> 
    public List<ResourceAgent> getFromLocal (String local) {
        //Database steps
        Entity entity;
        //Database step
        LocalizationService localization = LocalizationService.getInstance();
        List<Local> locals = localization.getMap();
        Local loc = null;
        for (Local l : locals)
        {
            if (l.getURN().equals(local))
                    loc = l;
        }
        
        List<ResourceAgent> result = new ArrayList<ResourceAgent>();
        if (loc!=null)
            for (ResourceAgent r : base.resources) {
                if (r.getClass().isAssignableFrom(Entity.class))
                {
                    entity = (Entity) r;
                    if (loc.isInner(entity.getPosition()))
                        result.add(r);
                }
            }
        return result;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.07D432AA-5CC8-7E4F-F3BD-08244AE6132B]
    // </editor-fold> 
    public ResourceAgent getCloser (ResourceAgent resource) {

        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B000B2FF-9B6E-E348-6D6C-97DAF07BB8AA]
    // </editor-fold> 
    public void getLocalFrom (ResourceAgent resource) {
    }

}

