/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import basicBeans.UsersFacade;
import entities.Users;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 */
@Stateful
public class UserBean implements CurrentUserBeanRemote {
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    private UsersFacade myFacade;
    private Users user;
    private ModuleManagerBean myManager;

    /**
     * returns the combined First and Lastname
     * @return
     */
    @Override
    public String getName(){
        return user.getFirstname()+ " " +  user.getLastname();
    }
    
    public String getLastname(){
        myFacade.
        return user.getLastname();
    }
    public String getFirstname(){
        return user.getFirstname();
    }
    @Override
    public ModuleManagerBean getModuleManager(){
        if(myManager == null){
            myManager = new ModuleManagerBean(user);
        }
        return myManager;
    }
    

    public void persist(Object object) {
        em.persist(object);               
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
