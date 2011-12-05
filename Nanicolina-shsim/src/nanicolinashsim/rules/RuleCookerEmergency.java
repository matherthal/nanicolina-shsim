/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim.rules;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import nanicolinashsim.DiscoveryService;
import nanicolinashsim.aggregators.AggCookerEmergency;
import nanicolinashsim.widgets.Bed;
import nanicolinashsim.widgets.Cooker;

/**
 *
 * @author matheus
 */
public class RuleCookerEmergency implements Observer, Rule {
    public String name = "";
    //public List<Tuple<Object, Object>> conditions;

    //Aggregator which monitors the RA's properties
    public AggCookerEmergency agg;
    public List<Object> actions;

    private DiscoveryService ds = DiscoveryService.getInstance("SDR", "localhost");

    public RuleCookerEmergency(AggCookerEmergency agg) {
        /*boolean condSatisfied = false;
        while (!condSatisfied) {
            for (Tuple<Object, Object> t : conditions) {
                if (t.getX().
            }
            
            if (.getClass().isAssignableFrom(Entity.class)
        }*/
        this.agg = agg;
    }

    public void update(Observable o, Object arg) {
        if (o instanceof AggCookerEmergency) {
            Cooker cooker = (Cooker) ds.getResourceAgent(agg.urnCooker);
            if (cooker.getTurnedOn() == false)  //If the cooker is turned on
                return;
            Bed bed = (Bed) ds.getResourceAgent(agg.urnBed);
            //Test conditions related to bed:
            if (bed.getUsed() == false)  //and if the bed is being used
                return;

            //Action:
            cooker.setTurnedOn(false);

        } else {
            System.out.println("Mary says : I don't know you.");
        }
    }
}
