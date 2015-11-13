/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.AvailableRoles;
import entities.Users;
import enums.RolesEnum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



/**
 *
 * @author Jons
 */
@Stateless
public class UserManagerBean implements UserManagerBeanRemote {
    
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;

    
    
    
    /**
     * @author JH
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
    
    /**
     * @author JH
     * returns a list of users that are in the specified role
     * @param role
     * @return 
     */
    public Collection<Users> findUserByRole(RolesEnum role){
        return em.find(AvailableRoles.class, role.ordinal()).getUsersCollection();        
    }
    
    

    public void persist(Object object) {
        em.persist(object);
    }
    
}
