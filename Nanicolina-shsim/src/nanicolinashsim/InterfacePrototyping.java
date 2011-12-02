package nanicolinashsim;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import nanicolinashsim.aggregators.AggCookerEmergency;
import nanicolinashsim.rules.RuleCookerEmergency;
import nanicolinashsim.base.DB;
import nanicolinashsim.widgets.*;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B1C4746F-6885-C536-A50C-3BFFE9862A34]
// </editor-fold> 
public class InterfacePrototyping {

    public static final int COOKER = 0;
    public static final int REFRIGERATOR = 1;
    public static final int TV = 2;
    public static final int BED = 3;
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
        
        //Start aggregators
        /*String urn       = "AggCookerEmergency";
        String url       = "localhost";
        String urnCooker = "Fogao da cozinha1";
        String urnBed    = "Cama de solteiro1";
        createResource(urnCooker, new Position(0.0f, 0.0f), InterfacePrototyping.COOKER);
        createResource(urnBed, new Position(0.0f, 0.0f), InterfacePrototyping.BED);
        AggCookerEmergency agg = new AggCookerEmergency(urn, url, urnBed, urnCooker);
        new Thread(agg).start();*/
        //Start rules and associate to aggregators
        //RuleCookerEmergency rule1 = new RuleCookerEmergency(agg);
        listenCommand();
    }

    private void listenCommand() {

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Digite um comando:");
            String command = s.nextLine();

            if (command.compareToIgnoreCase("create") == 0) {
                System.out.println("Escolha o tipo do recurso pelo número:");
                System.out.println(COOKER + " - Fogão");
                System.out.println(REFRIGERATOR + " - Geladeira");
                System.out.println(TV + " - TV");
                System.out.println(BED + " - Cama");
                int tipo = s.nextInt();
                s.nextLine();
                System.out.println("Digite o nome:");
                String nome = s.nextLine();
                System.out.println("Digite posicao x:");
                int x = s.nextInt();
                System.out.println("Digite posicao y:");
                int y = s.nextInt();

                createResource(nome, new Position(x, y), tipo);
                System.out.println("Criado o recurso");
            } else if (command.compareTo("delete") == 0) {

                System.out.println("Digite o nome do recurso:");
                String nome = s.nextLine();

                reg.unregister(ds.getResourceAgent(nome));
                System.out.println("Recurso deletado");
            } else if (command.compareToIgnoreCase("list") == 0) {

                String str = "Nao existem recursos";
                if (repo.resources != null) {

                    str = "";
                    for (ResourceAgent r : repo.resources) {
                        str += r.getURN() + "\n";
                    }
                }

                System.out.println(str);
            }
        }
    }

    private void initAmbient() {
        System.out.println("Inicializando o Ambiente");
        LocalizationService ls = (LocalizationService) ds.getResourceAgent("SLR");

        List<Local> locals = loadMap();
        ls.setMap(locals);

        String strLocals = "";
        if (locals != null) {
            for (Local l : locals) {
                strLocals += l.getURN() + "\n";
            }
        }
        System.out.println("Locais da casa: \n"
                + strLocals);

        //falta uma lista de CARs
        String strResources = "";
        strResources += "Fogão" + "\n";
        strResources += "Geladeira" + "\n";
        strResources += "TV" + "\n";
        strResources += "Cama" + "\n";
        System.out.println("Recursos disponiveis: \n"
                + strResources);

    }

    private void createResource(String nome, Position pos, int type) {

        Widget w = null;

        switch (type) {
            case InterfacePrototyping.COOKER:
                w = new Cooker(nome, "localhost", pos);
                break;
            case InterfacePrototyping.REFRIGERATOR:
                w = new Refrigerator(nome, "localhost", pos);
                break;
            case InterfacePrototyping.TV:
                w = new TV(nome, "localhost", pos);
                break;
            case InterfacePrototyping.BED:
                w = new Bed(nome, "localhost", pos);
                break;
        }

        DB db = DB.getInstance();
        try {
            db.persistRA(w, type);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfacePrototyping.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao carregar bibliotecas da base de dados");
        } catch (SQLException ex) {
            Logger.getLogger(InterfacePrototyping.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de banco de dados");
        }
        reg.register(w);
    }

    private ResourceAgent accessResource(String urn) {

        return ds.getResourceAgent(urn);
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
