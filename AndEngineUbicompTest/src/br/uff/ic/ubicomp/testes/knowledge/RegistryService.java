package br.uff.ic.ubicomp.testes.knowledge;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import nanicolinashsim.InterfacePrototyping;
import nanicolinashsim.ResourceAgent;
import nanicolinashsim.base.DB;

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
        
        int type = 0;
        //Database steps;
        DB db = DB.getInstance();
        try {
			db.persistRA(resource, type);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfacePrototyping.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao carregar bibliotecas da base de dados");
        } catch (SQLException ex) {
            Logger.getLogger(InterfacePrototyping.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de banco de dados");
        }
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

