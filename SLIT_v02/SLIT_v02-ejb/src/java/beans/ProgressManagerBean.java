/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Progress;
import entities.Users;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorgen
 */
@Stateful
public class ProgressManagerBean implements ProgressManagerBeanRemote {

    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    
    private Users user;
    private Progress progress;
    private UserManagerBean um;
    private ModuleManagerBean mo;

    /**
     * author: Jorgen
     * @return Stats for user 7
     */
    @Override
    public double getCurrentUserProgress(){
        Collection<Progress> userSeven = getApprovedProgressCollection(7);
        
        int i = userSeven.size();
        double approvedModules = (double) i;
        System.out.println(userSeven.size());
        double moduleStats = approvedModules / 13.0; //replace 5 with a list of all modules

        return moduleStats;     
    }    
    
    /**
     * author: Jorgen
     * @param id Which user you want to get the list for
     * @return 
     */
    public Collection<Progress> getApprovedProgressCollection(int id){
       user = em.find(Users.class, id);
        
       
       Collection<Progress> approvedList = new ArrayList<>();
       
       // for each data in table:progress, find all approved = true
       for (Progress p : user.getProgressCollection()){
           if (p.getApproved()){
                approvedList.add(p);
           }
       }
       return approvedList;     
    }
    

    
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
    