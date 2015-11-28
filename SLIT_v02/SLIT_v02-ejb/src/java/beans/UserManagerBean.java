/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.UserDTO;
import basicBeans.UsersFacade;
import entities.AvailableRoles;
import entities.Users;
import DTOs.RolesEnum;
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
    @EJB
    private UsersFacade usersFacade;
    
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;

    private Users currentUser;
    
    /**
     * @author JH
     * returns a list of all users that contain the given String either in their first or lastname 
     * @param name
     * 
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
     * selfexplaining :P
     * @param userID
     * @return 
     */
    @Override
    public String getUserName(int userID){
        Users user = em.find(Users.class, userID);
        String name = user.getFirstname() + " " + user.getLastname();
        return name;
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
    public Collection<Users> findUserByRole(RolesEnum role){
        return em.find(AvailableRoles.class, role.ordinal()).getUsersCollection();       

        
    }
    
    

    public void persist(Object object) {
        em.persist(object);
                List<Users> myUsers = new ArrayList<>();
    }

    /**
     * creates and returns a list of userDTOs 
     * @return 
     */
    @Override
    public List<UserDTO> getUserList() {
        
        List<Users> databaseUser = usersFacade.findAll();
                
        List<UserDTO> userDTO = new ArrayList<>();
        
        for(Users u : databaseUser){
            System.out.println("Creating user " + u.getFirstname() + " " + u.getLastname());
            String name = u.getFirstname() + " " + u.getLastname();
            UserDTO UserToAdd = new UserDTO(u.getIduser(),name);
            userDTO.add(UserToAdd);
        }
        return userDTO;
        
    }
    
}
