/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim.aggregators;

import java.util.logging.Level;
import java.util.logging.Logger;
import nanicolinashsim.DiscoveryService;
import nanicolinashsim.ResourceAgent;
import nanicolinashsim.*;
import nanicolinashsim.widgets.Bed;
import nanicolinashsim.widgets.Cooker;


/**
 *
 * @author matheus
 */
public class AggCookerEmergency extends ResourceAgent implements Runnable, Aggregator {
    public String urnCooker;
    public String urnBed;

    //TODO pegar discoveryservice da base de dados. Por enquanto isto é feito atraves de get instance
    private DiscoveryService ds = DiscoveryService.getInstance("SDR", "localhost");

    public AggCookerEmergency(String urn, String url, String urnBed, String urnCooker) {
        super(urn,url);
        this.urnBed = urnBed;
        this.urnCooker = urnCooker;
    }

    public void run() {
        while (true) {
            //Test conditions:
            Bed bed = (Bed) ds.getResourceAgent(urnBed);
            /*
            if (bed.getUsed() != true)
                return;*/
            //Cooker cooker = (Cooker) ds.getResourceAgent(urnCooker);
            /*if (cooker.getTurnedOn() != true)
                return;*/

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AggCookerEmergency.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
