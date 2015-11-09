/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicBeans;

import entities.Users;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * returns a list of all users that contain the given String either in their first or lastname
     * @param name
     * @return
     */
    public List<Users> findUsersByName(String name){
        List<Users> foundUsers = new ArrayList<>();
        foundUsers.addAll(em.createNamedQuery("Users.findByFirstname").setParameter("firstname", name).getResultList());
        foundUsers.addAll(em.createNamedQuery("Users.findByLastname").setParameter("lastname", name).getResultList());
        return foundUsers;
               
    }


    public UsersFacade() {
        super(Users.class);
    }
    
}
