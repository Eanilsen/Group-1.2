/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.AvailableRoles;
import entities.Progress;
import entities.Users;
import enums.RolesEnum;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorgen
 */
@Stateless
public class ProgressManagerBean implements ProgressManagerBeanRemote {

    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    
    /**
     * @author Jorgen L.
     * @return 
     */
    @Override
    public double theProgress(){
        System.out.println("theProgress");
        double modules = 5.0;
        double modulesCompleted = 1.0;
        double prog = modulesCompleted / modules; //replace 1 with modules completed
        //everything inside entity Progress is completed modules. Find the user 
        //and then look for how many modules he has completed. Then divide on 14.
        System.out.println(prog);
        return prog;
    }

}
