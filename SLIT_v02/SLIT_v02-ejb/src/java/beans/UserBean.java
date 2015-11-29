/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import basicBeans.UsersFacade;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 */
@Stateful
public class UserBean implements UserBeanRemote {

    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    private Users user;

    public UserBean() {
    }

    /**
     * returns the combined First and Lastname
     *
     * @return
     */
    
    public UserBean(int id){
        user = em.find(Users.class, id);
    }
    
    @Override
    public String getName() {          
        return user.getFirstname() + " " + user.getLastname();
    }

    public String getLastname() {
        return user.getLastname();
    }

    public String getFirstname() {
        return user.getFirstname();
    }


    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
