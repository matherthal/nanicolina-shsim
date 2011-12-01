package nanicolinashsim;

import java.util.ArrayList;
import java.util.List;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B1C4746F-6885-C536-A50C-3BFFE9862A34]
// </editor-fold> 
public class InterfacePrototyping {

    private ResourceRepository repo;
    private DiscoveryService ds;
    RegistryService reg;
    public InterfacePrototyping() {
        
        repo = ResourceRepository.getInstance();
        repo.resources.add(DiscoveryService.getInstance("SDR", "localhost"));
        repo.resources.add(RegistryService.getInstance("SRR", "localhost"));
        //pegar instancia do serviço de descoberta do
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InterfacePrototyping intProt = new InterfacePrototyping();
        intProt.start();
    }

    private void start() {

        ds = (DiscoveryService) repo.resources.get(0);
        reg = (RegistryService) ds.getResourceAgent("SRR");
        reg.register(LocalizationService.getInstance("SLR", "localhost"));

        initAmbient();

    }

    private void initAmbient() {
        System.out.println("Inicializando o Ambiente");
        LocalizationService ls = (LocalizationService) ds.getResourceAgent("SLR");

        List<Local> locals = loadMap();
        ls.setMap(locals);
        

        String strLocals = "";
        if (locals != null)
            for (Local l: locals)
                strLocals+= l.getURN()+"\n";
        System.out.println("Locais da casa: \n"+
                            strLocals);

        //falta uma lista de CARs
        String strResources = "";
        strResources += "Fogão"+"\n";
        strResources += "Geladeira"+"\n";
        strResources += "TV"+"\n";
        System.out.println("Recursos disponiveis: \n"+
                            strResources);

        

    }

    private List<Local> loadMap() {

        Local quarto1 = new Local("Quarto1", "localhost", new Position(0.0f, 0.0f), new Position(5.0f, 5.0f));
        Local quarto2 = new Local("Quarto2", "localhost", new Position(5.0f, 5.0f), new Position(10.0f, 10.0f));
        Local sala = new Local("Sala", "localhost", new Position(10.0f, 10.0f), new Position(15.0f, 15.0f));
        Local coz = new Local("Cozinha", "localhost", new Position(15.0f, 15.0f), new Position(20.0f, 20.0f));

        List<Local> locals = new ArrayList<Local>();

        locals.add(quarto1);
        locals.add(quarto2);
        locals.add(sala);
        locals.add(coz);

        return locals;
    }

}

