/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.AvailableRoles;
import entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 */
@Stateless
public class LoginManagerBean implements LoginManagerBeanRemote {
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    
    private Users user;
    
    private void findUser(int id){
        user = em.find(Users.class, id);
        user.getAvailableRolesCollection();
        System.out.println(user);
    }

    
//    public boolean isTeacher(int userId){
//        Users user = em.find(Users.class, userId);
//        AvailableRoles teacher = em.find(AvailableRoles.class, 1);
////        user.getAvailableRolesCollection().contains(em)
//                
//    }
    

    public void persist(Object object) {
        em.persist(object);
    }

    
}
