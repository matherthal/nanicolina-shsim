/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nanicolinashsim;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mareli
 */

//Repositorio de interfaces dos recursos, contendo suas operações

public class ResourceRepository {

    private static ResourceRepository instance = null;
    public List<ResourceAgent> resources;
    private ResourceRepository()
    {
        resources = new ArrayList();
    }
    public static ResourceRepository getInstance()
    {
        if (instance == null)
            instance = new ResourceRepository();
        return instance;
    }

    

}
