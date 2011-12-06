/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim.aggregators;

import java.util.Observable;
import java.util.Observer;

import nanicolinashsim.ResourceAgent;
import nanicolinashsim.widgets.Bed;
import nanicolinashsim.widgets.Cooker;
import br.uff.ic.ubicomp.testes.knowledge.DiscoveryService;


/**
 *
 * @author matheus
 */
public class AggCookerEmergency extends ResourceAgent implements IAggregator {
    public String urnCooker;
    public String urnBed;
    private Bed bed;
    private Cooker cooker;
    
    //TODO pegar discoveryservice da base de dados. Por enquanto isto é feito atraves de get instance
    private DiscoveryService ds = DiscoveryService.getInstance("SDR", "localhost");

    //This variable allows to control easily if all the properties changed to the desired one
    //When counter reaches MAX_COUNTER the state of the Aggregator has changed to the desired
    //private static int counter = 0;
    //private final int MAX_COUNTER = 2;
    private boolean[] propChanged = new boolean[]{false, false};

    public AggCookerEmergency(String urn, String url, String urnBed, String urnCooker) {
        super(urn,url);
        this.urnBed = urnBed;
        this.urnCooker = urnCooker;

        //Finding bed and cooker, the RAs of interest of this class
        bed = (Bed) ds.getResourceAgent(urnBed);        
        cooker = (Cooker) ds.getResourceAgent(urnCooker);
        //Starting observers to detect changes in the properties of the RAs
        bed.addObserver(new BedObserver());
        cooker.addObserver(new CookerObserver());
    }
    
    private void stateChanged() {
        if (propChanged[0] & propChanged[1]) {
            //Run action
            cooker.setTurnedOn(false); //Turn cooker off
            System.out.println("DEBUG Agregador Emergência do Fogao:\n   desligando fogao");
        }
        else {
            cooker.setTurnedOn(true);
            System.out.println("DEBUG Agregador Emergência do Fogao:\n   ligando fogao");
        }
    }
    /*public void run() {
        while (true) {
            //Test conditions:
            Bed bed = (Bed) ds.getResourceAgent(urnBed);
            
            if (bed.getUsed() != true)
                return;
            //Cooker cooker = (Cooker) ds.getResourceAgent(urnCooker);
            if (cooker.getTurnedOn() != true)
                return;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AggCookerEmergency.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/

    //Using the observers allow us to monitor the RAs without infinite loops, and its overheads
    private class BedObserver implements Observer {
        //Local allows easily control if the property is in the desired state or not
        //private int local = 0;

        public void update(Observable o, Object arg) {
            //Test property of interest
            Bed bed = (Bed) o;
            System.out.println("DEBUG: mudanca em cama: bed.getUsed() = " + bed.getUsed());

            if (bed.getUsed())
            //    local = 1;
                propChanged[0] = true;
            else
            //    local = 0;
                propChanged[0] = false;
            //Only subtracting counter by 1, or adding by 1, could lead the control to a
            //wrong state more easily
            //counter += local;
            //if (counter == MAX_COUNTER)
            //    stateChanged();
        }
    }

    private class CookerObserver implements Observer {
        //Local allows easily control if the property is in the desired state or not
        //private int local = 0;
        
        public void update(Observable o, Object arg) {
            //Test property of interest
            Cooker cooker = (Cooker) o;
            System.out.println("DEBUG: mudanca em fogao: cooker.getUsed() = " + cooker.getTurnedOn());
            if (cooker.getTurnedOn())
            //    local = 1;
                propChanged[1] = true;
            else
            //    local = 0;
                propChanged[1] = false;
            //Only subtracting counter by 1, or adding by 1, could lead the control to a
            //wrong state more easily
            //counter += local;
            //if (counter == MAX_COUNTER)
            //    stateChanged();
        }
    }
}
