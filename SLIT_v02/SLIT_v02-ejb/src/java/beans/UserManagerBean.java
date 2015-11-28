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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author Jons
 */
@Stateless
public class UserManagerBean implements UserManagerBeanRemote {
    
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    private Users user;

    
    public ArrayList<Users> getAllStudents(){
        return null;
    }
    
    @Override
    public void addUsers(int id){
        
        user = em.find(Users.class, id); 
        
//        String fName = user.getFirstname();
//        String lName = user.getLastname();
//        String mail = user.getEmail();
        List<String> userNames = new ArrayList<>();
        
        Query result = em.createQuery("SELECT u.firstname, u.lastname, u.email "
                + "FROM Users u");
        
        List users = result.getResultList();
      
        System.out.println(users);
        //for each user in table Users, add the user in this list
//        for (Users u : users){
//            userNames.add(result);
//        }
    }
    
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
    
    @Override
    public String getUserName(int i){
        Users user = em.find(Users.class, i);
        String name = user.getFirstname() + " " + user.getLastname();
        return name;
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
