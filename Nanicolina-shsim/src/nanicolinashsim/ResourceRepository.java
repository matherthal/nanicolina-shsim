/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim;

import java.util.List;

/**
 *
 * @author Mareli
 */
public class ResourceRepository {

    private static ResourceRepository instance = null;

    private ResourceRepository()
    {

        RegistryService r = RegistryService.getInstance("SRR", "localhost");
    }
    public static ResourceRepository getInstance()
    {
        if (instance == null)
            instance = new ResourceRepository();
        return instance;
    }

    public List<ResourceAgent> resources;

}
