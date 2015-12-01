/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicBeans;

import DTOs.RolesEnum;
import beans.UserManagerBean;
import entities.AvailableRoles;
import entities.Users;

import java.util.ArrayList;
import java.util.Collection;
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


    public UsersFacade() {
        super(Users.class);
    }

    /**
     *returns a userbean which represents a user of the System
     * edit: problem with EJB. cannot hand over a reference from another EJB
     * @param i
     * @return
     */
    //    @Override
    //    public UserBeanRemote getUserBean(int i){
    //      UserBean user = new UserBean(em.find(Users.class, i));
    //      return user;
    //    }
    /**
     * @author JH
     * returns a list of users that are in the specified role
     * @param role
     * @return
     */
    public Collection<Users> findUserByRole(RolesEnum role) {
        return em.find(AvailableRoles.class, role.ordinal()).getUsersCollection();
    }

    /**
     * @author JH
     * returns a list of all users that contain the given String either in their first or lastname
     * @param name
     *
     * @return
     */
    public List<Users> findUsersByName(String name) {
        List<Users> foundUsers = new ArrayList<>();
        foundUsers.addAll(em.createNamedQuery("Users.findByFirstname").setParameter("firstname", name).getResultList());
        foundUsers.addAll(em.createNamedQuery("Users.findByLastname").setParameter("lastname", name).getResultList());
        return foundUsers;
    }
    
}
