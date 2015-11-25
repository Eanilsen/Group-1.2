/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorgen
 */
@Stateless(mappedName = "ProgressManagerBeanRemote")
public class ProgressManagerBean implements ProgressManagerBeanRemote {

    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    
    /**
     * @author Jorgen L.
     * @return 
     */
    @Override
    public double theProgress(){
        System.out.println("TEST: printing from ProgressManagerBean!");
        double modules = 5.0;
        double modulesCompleted = 1.0;
        double prog = modulesCompleted / modules; //replace 1 with modules completed
        //everything inside entity Progress is completed modules. Find the user 
        //and then look for how many modules he has completed. Then divide on 14.
        System.out.println("TEST " + prog);
        return prog;
    }

}
